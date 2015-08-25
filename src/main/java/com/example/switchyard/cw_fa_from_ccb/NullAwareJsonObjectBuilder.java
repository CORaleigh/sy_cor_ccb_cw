package com.example.switchyard.cw_fa_from_ccb;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public class NullAwareJsonObjectBuilder implements JsonObjectBuilder {
    // Use the Factory Pattern to create an instance.
    public static JsonObjectBuilder wrap(JsonObjectBuilder builder) {
      if (builder == null) {
        throw new IllegalArgumentException("Can't wrap nothing.");
      }
      return new NullAwareJsonObjectBuilder(builder);
    }

    // Decorated object per Decorator Pattern.
    private final JsonObjectBuilder builder;

    private NullAwareJsonObjectBuilder(JsonObjectBuilder builder) {
      this.builder = builder;
    }
    @Override
    public JsonObjectBuilder add(String name, JsonValue value) {
      return builder.add(name, (value == null) ? JsonValue.NULL : value);
    }

	@Override
	public JsonObjectBuilder add(String name, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, BigInteger value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, BigDecimal value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, long value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder addNull(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, JsonObjectBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, JsonArrayBuilder builder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject build() {
		// TODO Auto-generated method stub
		return null;
	}

    // Implement all other JsonObjectBuilder methods.
  
}
