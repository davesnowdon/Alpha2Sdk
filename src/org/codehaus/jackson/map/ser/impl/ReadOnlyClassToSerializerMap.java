package org.codehaus.jackson.map.ser.impl;

import java.util.HashMap;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ser.SerializerCache;
import org.codehaus.jackson.type.JavaType;

public final class ReadOnlyClassToSerializerMap {
   protected final JsonSerializerMap _map;
   protected final SerializerCache.TypeKey _cacheKey = new SerializerCache.TypeKey(this.getClass(), false);

   private ReadOnlyClassToSerializerMap(JsonSerializerMap map) {
      this._map = map;
   }

   public ReadOnlyClassToSerializerMap instance() {
      return new ReadOnlyClassToSerializerMap(this._map);
   }

   public static ReadOnlyClassToSerializerMap from(HashMap<SerializerCache.TypeKey, JsonSerializer<Object>> src) {
      return new ReadOnlyClassToSerializerMap(new JsonSerializerMap(src));
   }

   public JsonSerializer<Object> typedValueSerializer(JavaType type) {
      this._cacheKey.resetTyped(type);
      return this._map.find(this._cacheKey);
   }

   public JsonSerializer<Object> typedValueSerializer(Class<?> cls) {
      this._cacheKey.resetTyped(cls);
      return this._map.find(this._cacheKey);
   }

   public JsonSerializer<Object> untypedValueSerializer(Class<?> cls) {
      this._cacheKey.resetUntyped(cls);
      return this._map.find(this._cacheKey);
   }

   public JsonSerializer<Object> untypedValueSerializer(JavaType type) {
      this._cacheKey.resetUntyped(type);
      return this._map.find(this._cacheKey);
   }
}
