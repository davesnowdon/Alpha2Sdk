package org.codehaus.jackson.node;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public final class MissingNode extends BaseJsonNode {
   private static final MissingNode instance = new MissingNode();

   private MissingNode() {
   }

   public static MissingNode getInstance() {
      return instance;
   }

   public JsonToken asToken() {
      return JsonToken.NOT_AVAILABLE;
   }

   public boolean isMissingNode() {
      return true;
   }

   public String getValueAsText() {
      return null;
   }

   public int getValueAsInt(int defaultValue) {
      return 0;
   }

   public long getValueAsLong(long defaultValue) {
      return 0L;
   }

   public double getValueAsDouble(double defaultValue) {
      return 0.0D;
   }

   public JsonNode path(String fieldName) {
      return this;
   }

   public JsonNode path(int index) {
      return this;
   }

   public final void serialize(JsonGenerator jg, SerializerProvider provider) throws IOException, JsonProcessingException {
      jg.writeNull();
   }

   public void serializeWithType(JsonGenerator jg, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonProcessingException {
      jg.writeNull();
   }

   public boolean equals(Object o) {
      return o == this;
   }

   public String toString() {
      return "";
   }
}
