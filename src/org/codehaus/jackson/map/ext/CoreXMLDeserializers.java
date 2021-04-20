package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.deser.StdScalarDeserializer;
import org.codehaus.jackson.map.util.Provider;

public class CoreXMLDeserializers implements Provider<StdDeserializer<?>> {
   static final DatatypeFactory _dataTypeFactory;

   public CoreXMLDeserializers() {
   }

   public Collection<StdDeserializer<?>> provide() {
      return Arrays.asList(new CoreXMLDeserializers.DurationDeserializer(), new CoreXMLDeserializers.GregorianCalendarDeserializer(), new CoreXMLDeserializers.QNameDeserializer());
   }

   static {
      try {
         _dataTypeFactory = DatatypeFactory.newInstance();
      } catch (DatatypeConfigurationException var1) {
         throw new RuntimeException(var1);
      }
   }

   public static class QNameDeserializer extends FromStringDeserializer<QName> {
      public QNameDeserializer() {
         super(QName.class);
      }

      protected QName _deserialize(String value, DeserializationContext ctxt) throws IllegalArgumentException {
         return QName.valueOf(value);
      }
   }

   public static class GregorianCalendarDeserializer extends StdScalarDeserializer<XMLGregorianCalendar> {
      public GregorianCalendarDeserializer() {
         super(XMLGregorianCalendar.class);
      }

      public XMLGregorianCalendar deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
         Date d = this._parseDate(jp, ctxt);
         if (d == null) {
            return null;
         } else {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(d);
            return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(calendar);
         }
      }
   }

   public static class DurationDeserializer extends FromStringDeserializer<Duration> {
      public DurationDeserializer() {
         super(Duration.class);
      }

      protected Duration _deserialize(String value, DeserializationContext ctxt) throws IllegalArgumentException {
         return CoreXMLDeserializers._dataTypeFactory.newDuration(value);
      }
   }
}
