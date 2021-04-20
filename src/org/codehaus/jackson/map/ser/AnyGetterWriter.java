package org.codehaus.jackson.map.ser;

import java.lang.reflect.Method;
import java.util.Map;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

public class AnyGetterWriter {
   protected final Method _anyGetter;
   protected final MapSerializer _serializer;

   public AnyGetterWriter(AnnotatedMethod anyGetter, MapSerializer serializer) {
      this._anyGetter = anyGetter.getAnnotated();
      this._serializer = serializer;
   }

   public void getAndSerialize(Object bean, JsonGenerator jgen, SerializerProvider provider) throws Exception {
      Object value = this._anyGetter.invoke(bean);
      if (value != null) {
         if (!(value instanceof Map)) {
            throw new JsonMappingException("Value returned by 'any-getter' (" + this._anyGetter.getName() + "()) not java.util.Map but " + value.getClass().getName());
         } else {
            this._serializer.serializeFields((Map)value, jgen, provider);
         }
      }
   }

   public void resolve(SerializerProvider provider) throws JsonMappingException {
      this._serializer.resolve(provider);
   }
}
