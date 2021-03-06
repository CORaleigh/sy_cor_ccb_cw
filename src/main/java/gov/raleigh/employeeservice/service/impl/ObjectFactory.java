//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.08 at 11:10:41 AM EST 
//


package gov.raleigh.employeeservice.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.raleigh.employeeservice.service.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _YCoordinate_QNAME = new QName("", "YCoordinate");
    private final static QName _MeterSize_QNAME = new QName("", "MeterSize");
    private final static QName _Dials_QNAME = new QName("", "dials");
    private final static QName _CityLimit_QNAME = new QName("", "CityLimit");
    private final static QName _UseClass_QNAME = new QName("", "UseClass");
    private final static QName _LifeSupport_QNAME = new QName("", "LifeSupport");
    private final static QName _LowMeterReadingWarning_QNAME = new QName("", "lowMeterReadingWarning");
    private final static QName _ServicePointId_QNAME = new QName("", "ServicePointId");
    private final static QName _Sequence_QNAME = new QName("", "Sequence");
    private final static QName _Route_QNAME = new QName("", "Route");
    private final static QName _ServicePointSourceStatus_QNAME = new QName("", "ServicePointSourceStatus");
    private final static QName _MeterBadgeNumber_QNAME = new QName("", "MeterBadgeNumber");
    private final static QName _ServicePointCreationDate_QNAME = new QName("", "ServicePointCreationDate");
    private final static QName _MeterInstallDate_QNAME = new QName("", "MeterInstallDate");
    private final static QName _CustomerName_QNAME = new QName("", "CustomerName");
    private final static QName _XCoordinate_QNAME = new QName("", "XCoordinate");
    private final static QName _RegisterId_QNAME = new QName("", "registerId");
    private final static QName _CustomerPhoneNumber_QNAME = new QName("", "CustomerPhoneNumber");
    private final static QName _Instructions_QNAME = new QName("", "Instructions");
    private final static QName _Cycle_QNAME = new QName("", "Cycle");
    private final static QName _Logs_QNAME = new QName("", "Logs");
    private final static QName _FieldActivityId_QNAME = new QName("", "FieldActivityId");
    private final static QName _ExternalID_QNAME = new QName("", "ExternalID");
    private final static QName _Step1_QNAME = new QName("", "Step1");
    private final static QName _Step2_QNAME = new QName("", "Step2");
    private final static QName _Step3_QNAME = new QName("", "Step3");
    private final static QName _HighMeterReadingWarning_QNAME = new QName("", "highMeterReadingWarning");
    private final static QName _ReadSequence_QNAME = new QName("", "readSequence");
    private final static QName _ServicePointType_QNAME = new QName("", "ServicePointType");
    private final static QName _RegisterSize_QNAME = new QName("", "RegisterSize");
    private final static QName _ReadType_QNAME = new QName("", "readType");
    private final static QName _ServicePointDisconnectLocation_QNAME = new QName("", "ServicePointDisconnectLocation");
    private final static QName _DispatchGroup_QNAME = new QName("", "DispatchGroup");
    private final static QName _MIU_QNAME = new QName("", "MIU");
    private final static QName _MeterLocation_QNAME = new QName("", "MeterLocation");
    private final static QName _LastMeterRead_QNAME = new QName("", "lastMeterRead");
    private final static QName _Description_QNAME = new QName("", "Description");
    private final static QName _ServiceAddress_QNAME = new QName("", "ServiceAddress");
    private final static QName _MeterID_QNAME = new QName("", "MeterID");
    private final static QName _Township_QNAME = new QName("", "Township");
    private final static QName _MrSource_QNAME = new QName("", "mrSource");
    private final static QName _ScheduledDate_QNAME = new QName("", "ScheduledDate");
    private final static QName _UploadStatus_QNAME = new QName("", "UploadStatus");
    private final static QName _ZipCode_QNAME = new QName("", "ZipCode");
    private final static QName _FAType_QNAME = new QName("", "FAType");
    private final static QName _Priority_QNAME = new QName("", "Priority");
    private final static QName _Status_QNAME = new QName("", "Status");
    private final static QName _PremiseType_QNAME = new QName("", "PremiseType");
    private final static QName _MeterModel_QNAME = new QName("", "MeterModel");
    private final static QName _FAClass_QNAME = new QName("", "FAClass");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.raleigh.employeeservice.service.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Registers }
     * 
     */
    public Registers createRegisters() {
        return new Registers();
    }

    /**
     * Create an instance of {@link RequestMessage }
     * 
     */
    public RequestMessage createRequestMessage() {
        return new RequestMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "YCoordinate")
    public JAXBElement<BigDecimal> createYCoordinate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_YCoordinate_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MeterSize")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createMeterSize(String value) {
        return new JAXBElement<String>(_MeterSize_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dials")
    public JAXBElement<BigInteger> createDials(BigInteger value) {
        return new JAXBElement<BigInteger>(_Dials_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CityLimit")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCityLimit(String value) {
        return new JAXBElement<String>(_CityLimit_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UseClass")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createUseClass(String value) {
        return new JAXBElement<String>(_UseClass_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LifeSupport")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLifeSupport(String value) {
        return new JAXBElement<String>(_LifeSupport_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "lowMeterReadingWarning")
    public JAXBElement<BigDecimal> createLowMeterReadingWarning(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LowMeterReadingWarning_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServicePointId")
    public JAXBElement<BigInteger> createServicePointId(BigInteger value) {
        return new JAXBElement<BigInteger>(_ServicePointId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Sequence")
    public JAXBElement<BigInteger> createSequence(BigInteger value) {
        return new JAXBElement<BigInteger>(_Sequence_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Route")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createRoute(String value) {
        return new JAXBElement<String>(_Route_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServicePointSourceStatus")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createServicePointSourceStatus(String value) {
        return new JAXBElement<String>(_ServicePointSourceStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MeterBadgeNumber")
    public JAXBElement<BigInteger> createMeterBadgeNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_MeterBadgeNumber_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServicePointCreationDate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createServicePointCreationDate(String value) {
        return new JAXBElement<String>(_ServicePointCreationDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MeterInstallDate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createMeterInstallDate(String value) {
        return new JAXBElement<String>(_MeterInstallDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CustomerName")
    public JAXBElement<String> createCustomerName(String value) {
        return new JAXBElement<String>(_CustomerName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "XCoordinate")
    public JAXBElement<BigDecimal> createXCoordinate(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_XCoordinate_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "registerId")
    public JAXBElement<BigInteger> createRegisterId(BigInteger value) {
        return new JAXBElement<BigInteger>(_RegisterId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CustomerPhoneNumber")
    public JAXBElement<String> createCustomerPhoneNumber(String value) {
        return new JAXBElement<String>(_CustomerPhoneNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Instructions")
    public JAXBElement<String> createInstructions(String value) {
        return new JAXBElement<String>(_Instructions_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Cycle")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createCycle(String value) {
        return new JAXBElement<String>(_Cycle_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Logs")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createLogs(String value) {
        return new JAXBElement<String>(_Logs_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FieldActivityId")
    public JAXBElement<BigInteger> createFieldActivityId(BigInteger value) {
        return new JAXBElement<BigInteger>(_FieldActivityId_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExternalID")
    public JAXBElement<BigInteger> createExternalID(BigInteger value) {
        return new JAXBElement<BigInteger>(_ExternalID_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Step1")
    public JAXBElement<String> createStep1(String value) {
        return new JAXBElement<String>(_Step1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Step2")
    public JAXBElement<String> createStep2(String value) {
        return new JAXBElement<String>(_Step2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Step3")
    public JAXBElement<String> createStep3(String value) {
        return new JAXBElement<String>(_Step3_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "highMeterReadingWarning")
    public JAXBElement<BigDecimal> createHighMeterReadingWarning(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_HighMeterReadingWarning_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "readSequence")
    public JAXBElement<BigInteger> createReadSequence(BigInteger value) {
        return new JAXBElement<BigInteger>(_ReadSequence_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServicePointType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createServicePointType(String value) {
        return new JAXBElement<String>(_ServicePointType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RegisterSize")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createRegisterSize(String value) {
        return new JAXBElement<String>(_RegisterSize_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "readType")
    public JAXBElement<BigInteger> createReadType(BigInteger value) {
        return new JAXBElement<BigInteger>(_ReadType_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServicePointDisconnectLocation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createServicePointDisconnectLocation(String value) {
        return new JAXBElement<String>(_ServicePointDisconnectLocation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DispatchGroup")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDispatchGroup(String value) {
        return new JAXBElement<String>(_DispatchGroup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MIU")
    public JAXBElement<BigInteger> createMIU(BigInteger value) {
        return new JAXBElement<BigInteger>(_MIU_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MeterLocation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createMeterLocation(String value) {
        return new JAXBElement<String>(_MeterLocation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "lastMeterRead")
    public JAXBElement<BigDecimal> createLastMeterRead(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_LastMeterRead_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ServiceAddress")
    public JAXBElement<String> createServiceAddress(String value) {
        return new JAXBElement<String>(_ServiceAddress_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MeterID")
    public JAXBElement<BigInteger> createMeterID(BigInteger value) {
        return new JAXBElement<BigInteger>(_MeterID_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Township")
    public JAXBElement<String> createTownship(String value) {
        return new JAXBElement<String>(_Township_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mrSource")
    public JAXBElement<String> createMrSource(String value) {
        return new JAXBElement<String>(_MrSource_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ScheduledDate")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createScheduledDate(String value) {
        return new JAXBElement<String>(_ScheduledDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UploadStatus")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createUploadStatus(String value) {
        return new JAXBElement<String>(_UploadStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ZipCode")
    public JAXBElement<BigInteger> createZipCode(BigInteger value) {
        return new JAXBElement<BigInteger>(_ZipCode_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FAType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createFAType(String value) {
        return new JAXBElement<String>(_FAType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Priority")
    public JAXBElement<String> createPriority(String value) {
        return new JAXBElement<String>(_Priority_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Status")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PremiseType")
    public JAXBElement<String> createPremiseType(String value) {
        return new JAXBElement<String>(_PremiseType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MeterModel")
    public JAXBElement<String> createMeterModel(String value) {
        return new JAXBElement<String>(_MeterModel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FAClass")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createFAClass(String value) {
        return new JAXBElement<String>(_FAClass_QNAME, String.class, null, value);
    }

}
