package org.codehaus.jackson.map.ser.impl;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> implements ResolvableSerializer {
   protected JsonSerializer<String> _serializer;

   public IndexedStringListSerializer(BeanProperty property) {
      super(List.class, property);
   }

   protected JsonNode contentSchema() {
      return this.createSchemaNode("string", true);
   }

   public void resolve(SerializerProvider provider) throws JsonMappingException {
      JsonSerializer<?> ser = provider.findValueSerializer(String.class, this._property);
      if (!this.isDefaultSerializer(ser)) {
         this._serializer = ser;
      }

   }

   public void serialize(List<String> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
      jgen.writeStartArray();
      if (this._serializer == null) {
         this.serializeContents(value, jgen, provider);
      } else {
         this.serializeUsingCustom(value, jgen, provider);
      }

      jgen.writeEndArray();
   }

   public void serializeWithType(List<String> value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonGenerationException {
      typeSer.writeTypePrefixForArray(value, jgen);
      if (this._serializer == null) {
         this.serializeContents(value, jgen, provider);
      } else {
         this.serializeUsingCustom(value, jgen, provider);
      }

      typeSer.writeTypeSuffixForArray(value, jgen);
   }

   private final void serializeContents(List<String> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
      int i = 0;

      try {
         for(int len = value.size(); i < len; ++i) {
            String str = (String)value.get(i);
            if (str == null) {
               provider.defaultSerializeNull(jgen);
            } else {
               jgen.writeString(str);
            }
         }
      } catch (Exception var7) {
         this.wrapAndThrow(provider, var7, value, i);
      }

   }

   private final void serializeUsingCustom(List<String> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
      byte i = 0;

      try {
         int len = value.size();
         JsonSerializer<String> ser = this._serializer;

         for(int i = 0; i < len; ++i) {
            String str = (String)value.get(i);
            if (str == null) {
               provider.defaultSerializeNull(jgen);
            } else {
               ser.serialize(str, jgen, provider);
            }
         }
      } catch (Exception var8) {
         this.wrapAndThrow(provider, var8, value, i);
      }

   }
}
