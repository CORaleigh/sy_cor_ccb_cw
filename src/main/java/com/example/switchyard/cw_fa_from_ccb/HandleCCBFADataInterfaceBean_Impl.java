package com.example.switchyard.cw_fa_from_ccb;

import gov.raleigh.employeeservice.service.impl.RequestMessage;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

/*
 * COR - 03/19/2015
 * CC&B/Cityworks integration
 * Takes in XML from CC&B as the messagebody
 * and converts to json and invokes CRUD on work orders in Cityworks
 */
@Service(HandleCCBFADataInterface.class)
public class HandleCCBFADataInterfaceBean_Impl implements
		HandleCCBFADataInterface {
	
	@Inject
	@Reference
	private InvokeCWCreateWOServiceInterface invokeCWCreateWOServiceInterface;
	
	@Inject
	@Reference
	private InvokeCWUpdateWOServiceInterface invokeCWUpdateWOServiceInterface;

	@Inject
	@Reference
	private InvokeCWDeleteWOServiceInterface invokeCWDeleteWOServiceInterface;
	
	
	@Override
	public String getMessage(String messagebody) {
		String woID = "";
		String canceledStatus = "Canceled";
		
		try {
			boolean compoundMeter = false;
			boolean workCompleted = false;
			JAXBContext jaxc = JAXBContext.newInstance("gov.raleigh.employeeservice.service.impl");
			Unmarshaller unmarshaller = jaxc.createUnmarshaller();
			StringReader reader = new StringReader(messagebody);
			RequestMessage request = (RequestMessage) unmarshaller.unmarshal(reader);
			System.out.println("messagebody" + messagebody);
		    
			// Check for compound meters
		    if (request.getRegisters().size() > 1) {
		    	System.out.println("we have a compound meter1");
				compoundMeter = true;			
		    }
						
		    // external ID is the Work Order number returning from Cityworks when a new work order is created
		    // CC&B stores this work order number in the 'external ID' field in CC&B
			String externalID = request.getExternalID();		

			// JsonBuilderFactory can't handle nulls, pre-check for null values and send over a space character
			String statusIn = request.getStatus();
			if (statusIn.equals(canceledStatus)){
				 statusIn = "CANCEL";
			} else {
				 statusIn = request.getStatus();
			}		
			
			String instructions = request.getInstructions();
			if (instructions == null){
				instructions = " ";
			}
			
			String comments = " ";  // are comments always blank?
			
			String spLocationDetail = request.getMeterLocation();
			if (spLocationDetail == null) {
				spLocationDetail = " ";
			}
			
			String customerName = request.getCustomerName();
			if (customerName == null) {
				customerName = " ";
			}
			
			String customerPhone = request.getCustomerPhoneNumber();
			if (customerPhone == null)
				customerPhone = " ";					    
							
			// Handle creation of new Work Orders in Cityworks
			if (externalID == null && compoundMeter == false && workCompleted == false) {
			System.out.println("This is an Insert for a single meter");	
			Map config = new HashMap();
			JsonBuilderFactory factory = Json.createBuilderFactory(config);
			//buildJsonString(request, compoundMeter);  // can we make a generic method to building all json?
			
			JsonObject value = factory.createObjectBuilder()
					 .add("MeterHeader",  factory.createObjectBuilder()
				     .add("FieldActivityId", request.getFieldActivityId())
				     .add("FieldActivityType", factory.createObjectBuilder().add("Code", request.getFAType()))
				     .add("CustomerName", customerName)
				     .add("CustomerPhone", customerPhone)
				     .add("LifeSupport", "false")
				     .add("CurrentMeter", factory.createObjectBuilder()
				    	 .add("MeterId", request.getMeterID())
				    	 .add("BadgeNumber", request.getMeterBadgeNumber())
					     .add("RemoveMeter", "false")
					     .addNull("IsDeviceTest") 
					     .add("CompoundMtr", compoundMeter) 
					     .add("ReadDateTime", "true") 
					     .add("Size", factory.createObjectBuilder().add("Code", request.getMeterSize()))
					    	 .add("Register1", factory.createObjectBuilder() 
				    		 .add("Reading", request.getRegisters().get(0).getLastMeterRead().toBigInteger())
				    		 .add("Dials", request.getRegisters().get(0).getDials())
				    		 .add("Miu", request.getRegisters().get(0).getMIU())
				    		 .add("ReadType", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getReadType()))
				    		 .add("MrSource", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getMrSource()))
				    		 .add("Size", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getRegisterSize())) 
				    	     .add("LowReadThreshold", request.getRegisters().get(0).getLowMeterReadingWarning().toBigInteger())
				    		 .add("HighReadThreshold", request.getRegisters().get(0).getHighMeterReadingWarning().toBigInteger()))
				    		 .addNull("Register2")
				    	 	 .addNull("DeviceTest"))
				     .addNull("InstallMeter")
				     .add("StreetAddress", request.getServiceAddress())
				     .add("FAInstructions", instructions)
				     .add("FAComments", comments)
                     .add("SPLocationDetails", spLocationDetail)
				     .add("SPType", request.getServicePointType())
				     .add("PremiseType", request.getPremiseType())
				     .add("Township", request.getTownship())
				     .add("CityLimit", request.getCityLimit())
				     .add("UseClass", request.getUseClass())
				     .add("Postal", request.getZipCode())
				     .add("FARemark", factory.createObjectBuilder().add("Code","X-NOTES-CM"))
				     .add("SPSourceStatus", factory.createObjectBuilder().add("Code", request.getServicePointSourceStatus().substring(0, 1)))
				     .add("DisconnectLocation", factory.createObjectBuilder().add("Code","METR"))
				     .addNull("DispatchGroup")
				     .add("SPId", request.getServicePointId())
				     .addNull("StockLocation")
				     .addNull("AdjustmentType")
				     .addNull("LetterType")
	                 .addNull("ToDoType")
				     .addNull("AdjustmentValue")
				     .addNull("LetterValue")
				     .addNull("ToDoValue")
				     .add("WorkOrderId", "1"))
				     .add("WorkOrder", factory.createObjectBuilder()
				    		 .add("WorkOrderId", "1")
				    		 .add("DomainId", "284008")
				    		 .add("Description", request.getDescription())
				    		 .add("Supervisor", "")
				    		 .add("RequestedBy", "")
				    		 .add("InitiatedBy", "")
				    		 .add("InitiateDate", request.getScheduledDate())
				    		 .add("Location", "")
				    		 .add("ProjectStartDate", "")
				    		 .add("ProjectFinishDate", "")
				    		 .add("Priority", "")
				    		 .add("NumDaysBefore", "1")
				    		 .add("WoCategory", "")
				       		 .add("SubmitTo", " ")
				    		 .add("Status", "Initiated")
				    		 .add("WoTemplateId", "257702")
				    		 .add("WoAddress", request.getServiceAddress())
				    		 .add("WoXCoordinate", request.getXCoordinate())
				    		 .add("WoYCoordinate", request.getYCoordinate()))
				     .build();
			
			// ugly print the json
			System.out.println("json sample " + value +"\n");
			
			JsonObject response = invokeCWCreateWOServiceInterface.createWO(value);
			System.out.println("response = " + response +"\n");
			
			woID = response.getString("message");
			
			System.out.println("response " + response +"\n" + "woID = " + woID);
			workCompleted = true;
			return "<ResponseMessage><WorkOrderId>" + woID + "</WorkOrderId></ResponseMessage>";
			}	

			// Build message just for Compound meters
			if (externalID == null && compoundMeter == true && workCompleted == false) {			
			System.out.println("This is an Insert for a compound meter");
			
			Map config = new HashMap();
			JsonBuilderFactory factory = Json.createBuilderFactory(config);
			JsonObject value = factory.createObjectBuilder()
					 .add("MeterHeader",  factory.createObjectBuilder()
				     .add("FieldActivityId", request.getFieldActivityId())
				     .add("FieldActivityType", factory.createObjectBuilder().add("Code", request.getFAType()))
				     .add("CustomerName", customerName)
				     .add("CustomerPhone", customerPhone)
				     .add("LifeSupport", "false")
				     .add("CurrentMeter", factory.createObjectBuilder()
				    	 .add("MeterId", request.getMeterID())
				    	 .add("BadgeNumber", request.getMeterBadgeNumber())
					     .add("RemoveMeter", "false")
					     .addNull("IsDeviceTest") 
					     .add("CompoundMtr", compoundMeter) // How to tell we have a compound meter? Registers is of type Registers, need to deal with that
					     .add("ReadDateTime", "true") // bug on Mike's side
					     .add("Size", factory.createObjectBuilder().add("Code", request.getMeterSize()))
					    	 .add("Register1", factory.createObjectBuilder() //Registers is of type Registers, need to deal with that
				    		 .add("Reading", request.getRegisters().get(1).getLastMeterRead())
				    		 .add("Dials", request.getRegisters().get(1).getDials())
				    		 .add("Miu", request.getRegisters().get(1).getMIU())
				    		 .add("ReadType", factory.createObjectBuilder().add("Code", request.getRegisters().get(1).getReadType()))
				    		 .add("MrSource", factory.createObjectBuilder().add("Code", request.getRegisters().get(1).getMrSource()))
				    		 .add("Size", factory.createObjectBuilder().add("Code", request.getRegisters().get(1).getRegisterSize())) 
				    	     .add("LowReadThreshold", request.getRegisters().get(1).getLowMeterReadingWarning())
				    		 .add("HighReadThreshold", request.getRegisters().get(1).getHighMeterReadingWarning()))
				    		 .add("Register2", factory.createObjectBuilder() //Registers is of type Registers, need to deal with that
				    		 .add("Reading", request.getRegisters().get(0).getLastMeterRead())
				    		 .add("Dials", request.getRegisters().get(0).getDials())
				    		 .add("Miu", request.getRegisters().get(0).getMIU())
				    		 .add("ReadType", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getReadType()))
				    		 .add("MrSource", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getMrSource()))
				    		 .add("Size", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getRegisterSize())) 
				    	     .add("LowReadThreshold", request.getRegisters().get(0).getLowMeterReadingWarning())
				    		 .add("HighReadThreshold", request.getRegisters().get(0).getHighMeterReadingWarning()))
				    	 	.addNull("DeviceTest"))
				     .addNull("InstallMeter")
				     .add("StreetAddress", request.getServiceAddress())
				     .add("FAInstructions", instructions)
				     .add("FAComments", comments)
                     .add("SPLocationDetails", spLocationDetail)
				     .add("SPType", request.getServicePointType())
				     .add("PremiseType", request.getPremiseType())
				     .add("Township", request.getTownship())
				     .add("CityLimit", request.getCityLimit())
				     .add("UseClass", request.getUseClass())
				     .add("Postal", request.getZipCode())
				     .add("FARemark", factory.createObjectBuilder().add("Code","X-NOTES-CM"))
				     .add("SPSourceStatus", factory.createObjectBuilder().add("Code", request.getServicePointSourceStatus().substring(0, 1)))
				     .add("DisconnectLocation", factory.createObjectBuilder().add("Code","METR"))
				     .addNull("DispatchGroup")
				     .add("SPId", request.getServicePointId())
				     .addNull("StockLocation")
				     .addNull("AdjustmentType")
				     .addNull("LetterType")
	                 .addNull("ToDoType")
				     .addNull("AdjustmentValue")
				     .addNull("LetterValue")
				     .addNull("ToDoValue")
				     .add("WorkOrderId", "1"))
				     .add("WorkOrder", factory.createObjectBuilder()
				    		 .add("WorkOrderId", "1")
				    		 .add("DomainId", "284008")
				    		 .add("Description", request.getDescription())
				    		 .add("Supervisor", "")
				    		 .add("RequestedBy", "")
				    		 .add("InitiatedBy", "")
				    		 .add("InitiateDate", request.getScheduledDate())
				    		 .add("Location", "")
				    		 .add("ProjectStartDate", "")
				    		 .add("ProjectFinishDate", "")
				    		 .add("Priority", "")
				    		 .add("NumDaysBefore", "1")
				    		 .add("WoCategory", "")
				       		 .add("SubmitTo", " ")
				    		 .add("Status", "Initiated")
				    		 .add("WoTemplateId", "257702")
				    		 .add("WoAddress", request.getServiceAddress())
				    		 .add("WoXCoordinate", request.getXCoordinate())
				    		 .add("WoYCoordinate", request.getYCoordinate()))
				     .build();
			
				// ugly print the json
				System.out.println("json sample " + value +"\n");
				
				JsonObject response = invokeCWCreateWOServiceInterface.createWO(value);
				System.out.println("response = " + response +"\n");
				
				woID = response.getString("message");
				
				System.out.println("response " + response +"\n" + "woID = " + woID);
				workCompleted = true;
				return "<ResponseMessage><WorkOrderId>" + woID + "</WorkOrderId></ResponseMessage>";
			}
			
			// Handle Updating a Work Order in Cityworks
						if (externalID != null && compoundMeter == true && workCompleted == false) {
							System.out.println("This is an Update for a compound meter");
							Map config = new HashMap();
							JsonBuilderFactory factory = Json.createBuilderFactory(config);
							JsonObject value = factory.createObjectBuilder()
									 .add("MeterHeader",  factory.createObjectBuilder()
								     .add("FieldActivityId", request.getFieldActivityId())
								     .add("FieldActivityType", factory.createObjectBuilder()
								     .add("Code", request.getFAType()))
								     .add("CustomerName", customerName)
								     .add("CustomerPhone", customerPhone)
								     .add("LifeSupport", "false")
			     				     .add("CurrentMeter", factory.createObjectBuilder()
								    	 .add("MeterId", request.getMeterID())
								    	 .add("BadgeNumber", request.getMeterBadgeNumber())
									     .add("RemoveMeter", "false") 
									     .addNull("IsDeviceTest") 	
									     .add("CompoundMtr", compoundMeter)
									     .add("ReadDateTime", "true") 
									     .add("Size", factory.createObjectBuilder().add("Code", request.getMeterSize()))
									    	 .add("Register1", factory.createObjectBuilder() //Registers is of type Registers, need to deal with that
								    		 .add("Reading", request.getRegisters().get(1).getLastMeterRead().toBigInteger())
								    		 .add("Dials", request.getRegisters().get(1).getDials())
								    		 .add("Miu", request.getRegisters().get(1).getMIU())
								    		 .add("ReadType", factory.createObjectBuilder().add("Code", request.getRegisters().get(1).getReadType()))
							 				 .add("MrSource", factory.createObjectBuilder().add("Code", request.getRegisters().get(1).getMrSource()))	    		 
								    		 .add("Size", factory.createObjectBuilder().add("Code", request.getRegisters().get(1).getRegisterSize()))) 
								    		 .add("Register2", factory.createObjectBuilder() //Registers is of type Registers, need to deal with that
								    		 .add("Reading", request.getRegisters().get(0).getLastMeterRead())
								    		 .add("Dials", request.getRegisters().get(0).getDials())
								    		 .add("Miu", request.getRegisters().get(0).getMIU())
								    		 .add("ReadType", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getReadType()))
								    		 .add("MrSource", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getMrSource()))
								    		 .add("Size", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getRegisterSize())))
								    	 	.addNull("DeviceTest"))
								     .addNull("InstallMeter")
								     .add("StreetAddress", request.getServiceAddress())
								     .add("FAInstructions", instructions)
								     .add("FAComments", comments)
			    				     .add("SPLocationDetails", spLocationDetail)
								     .add("SPType", request.getServicePointType())
								     .add("PremiseType", request.getPremiseType())
								     .add("Township", request.getTownship())
								     .add("CityLimit", request.getCityLimit())
								     .add("UseClass", request.getUseClass())
								     .add("Postal", request.getZipCode())
								     .add("FARemark", factory.createObjectBuilder().add("Code","X-NOTES-CM"))
						    	     .add("SPSourceStatus", factory.createObjectBuilder().add("Code", request.getServicePointSourceStatus().substring(0, 1)))
								     .add("DisconnectLocation", factory.createObjectBuilder().add("Code","METR"))
								     .addNull("DispatchGroup")
								     .add("SPId", request.getServicePointId())
								     .addNull("StockLocation")
								     .addNull("AdjustmentType")
								     .addNull("LetterType")
								     .addNull("ToDoType")
								     .addNull("AdjustmentValue")
								     .addNull("LetterValue")
								     .addNull("ToDoValue")
								     .add("WorkOrderId", request.getExternalID()))
								     .add("WorkOrder", factory.createObjectBuilder()
								    		 .add("WorkOrderId", request.getExternalID())
								    		 .add("DomainId", "284008")
								    		 .add("Description", request.getDescription())
								    		 .add("Supervisor", "")
								    		 .add("RequestedBy", "")
								    		 .add("InitiatedBy", "")
								    		 .add("InitiateDate", request.getScheduledDate())
								    		 .add("Location", "")
								    		 .add("ProjectStartDate", "")
								    		 .add("ProjectFinishDate", "")
								    		 .add("Priority", "")
								    		 .add("NumDaysBefore", "1")
								    		 .add("WoCategory", "")
								    		 .add("SubmitTo" , " ")
								    		 .add("Status", statusIn)
								    		 .add("WoTemplateId", "257702")
								    		 .add("WoAddress", request.getServiceAddress())
								    		 .add("WoXCoordinate", request.getXCoordinate())
								    		 .add("WoYCoordinate", request.getYCoordinate()))
								     .build();
							
							       System.out.println("External ID " + externalID);
							       System.out.println("Status In " + statusIn +"\n");
							
								   JsonObject response = invokeCWUpdateWOServiceInterface.updateWO(value);	
								   System.out.println("response from update " + response);
								   System.out.println("json update sample " + value +"\n");
						
								   workCompleted = true;
							    return "<ResponseMessage><WorkOrderId>" + request.getExternalID() + "</WorkOrderId></ResponseMessage>";
						}
			
			// Handle Updating a Work Order in Cityworks
			if (externalID != null && compoundMeter == false && workCompleted == false) {
				System.out.println("This is an Update for a single meter");
				Map config = new HashMap();
				JsonBuilderFactory factory = Json.createBuilderFactory(config);
				JsonObject value = factory.createObjectBuilder()
						 .add("MeterHeader",  factory.createObjectBuilder()
					     .add("FieldActivityId", request.getFieldActivityId())
					     .add("FieldActivityType", factory.createObjectBuilder()
					     .add("Code", request.getFAType()))
					     .add("CustomerName", customerName)
					     .add("CustomerPhone", customerPhone)
					     .add("LifeSupport", "false")
     				     .add("CurrentMeter", factory.createObjectBuilder()
					    	 .add("MeterId", request.getMeterID())
					    	 .add("BadgeNumber", request.getMeterBadgeNumber())
						     .add("RemoveMeter", "false") 
						     .addNull("IsDeviceTest") 	
						     .add("CompoundMtr", compoundMeter)
						     .add("ReadDateTime", "true") 
						     .add("Size", factory.createObjectBuilder().add("Code", request.getMeterSize()))
						    	 .add("Register1", factory.createObjectBuilder() //Registers is of type Registers, need to deal with that
					    		 .add("Reading", request.getRegisters().get(0).getLastMeterRead().toBigInteger())
					    		 .add("Dials", request.getRegisters().get(0).getDials())
					    		 .add("Miu", request.getRegisters().get(0).getMIU())
					    		 .add("ReadType", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getReadType()))
				 				 .add("MrSource", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getMrSource()))	    		 
					    		 .add("Size", factory.createObjectBuilder().add("Code", request.getRegisters().get(0).getRegisterSize()))) 
					    		 .addNull("Register2")
					    	 	.addNull("DeviceTest"))
					     .addNull("InstallMeter")
					     .add("StreetAddress", request.getServiceAddress())
					     .add("FAInstructions", instructions)
					     .add("FAComments", comments)
    				     .add("SPLocationDetails", spLocationDetail)
					     .add("SPType", request.getServicePointType())
					     .add("PremiseType", request.getPremiseType())
					     .add("Township", request.getTownship())
					     .add("CityLimit", request.getCityLimit())
					     .add("UseClass", request.getUseClass())
					     .add("Postal", request.getZipCode())
					     .add("FARemark", factory.createObjectBuilder().add("Code","X-NOTES-CM"))
			    	     .add("SPSourceStatus", factory.createObjectBuilder().add("Code", request.getServicePointSourceStatus().substring(0, 1)))
					     .add("DisconnectLocation", factory.createObjectBuilder().add("Code","METR"))
					     .addNull("DispatchGroup")
					     .add("SPId", request.getServicePointId())
					     .addNull("StockLocation")
					     .addNull("AdjustmentType")
					     .addNull("LetterType")
					     .addNull("ToDoType")
					     .addNull("AdjustmentValue")
					     .addNull("LetterValue")
					     .addNull("ToDoValue")
					     .add("WorkOrderId", request.getExternalID()))
					     .add("WorkOrder", factory.createObjectBuilder()
					    		 .add("WorkOrderId", request.getExternalID())
					    		 .add("DomainId", "284008")
					    		 .add("Description", request.getDescription())
					    		 .add("Supervisor", "")
					    		 .add("RequestedBy", "")
					    		 .add("InitiatedBy", "")
					    		 .add("InitiateDate", request.getScheduledDate())
					    		 .add("Location", "")
					    		 .add("ProjectStartDate", "")
					    		 .add("ProjectFinishDate", "")
					    		 .add("Priority", "")
					    		 .add("NumDaysBefore", "1")
					    		 .add("WoCategory", "")
					    		 .add("SubmitTo" , " ")
					    		 .add("Status", statusIn)
					    		 .add("WoTemplateId", "257702")
					    		 .add("WoAddress", request.getServiceAddress())
					    		 .add("WoXCoordinate", request.getXCoordinate())
					    		 .add("WoYCoordinate", request.getYCoordinate()))
					     .build();
				
				       System.out.println("External ID " + externalID);
				       System.out.println("Status In " + statusIn +"\n");
				
					   JsonObject response = invokeCWUpdateWOServiceInterface.updateWO(value);	
					   System.out.println("response from update " + response);
					   System.out.println("json update sample " + value +"\n");
					   
					   workCompleted = true;
				    return "<ResponseMessage><WorkOrderId>" + request.getExternalID() + "</WorkOrderId></ResponseMessage>";
			}
			
			

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "<ResponseMessage><WorkOrderId>" + woID + "</WorkOrderId></ResponseMessage>";

	}

}