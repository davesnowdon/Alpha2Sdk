package org.msgpack.type;

import java.util.AbstractMap;
import org.msgpack.MessageTypeException;

abstract class AbstractMapValue extends AbstractMap<Value, Value> implements MapValue {
   AbstractMapValue() {
   }

   public ValueType getType() {
      return ValueType.MAP;
   }

   public boolean isMapValue() {
      return true;
   }

   public MapValue asMapValue() {
      return this;
   }

   public boolean isNilValue() {
      return false;
   }

   public boolean isBooleanValue() {
      return false;
   }

   public boolean isIntegerValue() {
      return false;
   }

   public boolean isFloatValue() {
      return false;
   }

   public boolean isArrayValue() {
      return false;
   }

   public boolean isRawValue() {
      return false;
   }

   public NilValue asNilValue() {
      throw new MessageTypeException();
   }

   public BooleanValue asBooleanValue() {
      throw new MessageTypeException();
   }

   public IntegerValue asIntegerValue() {
      throw new MessageTypeException();
   }

   public FloatValue asFloatValue() {
      throw new MessageTypeException();
   }

   public ArrayValue asArrayValue() {
      throw new MessageTypeException();
   }

   public RawValue asRawValue() {
      throw new MessageTypeException();
   }
}
