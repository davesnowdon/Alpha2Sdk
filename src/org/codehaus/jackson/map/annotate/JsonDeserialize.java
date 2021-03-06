package org.codehaus.jackson.map.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.KeyDeserializer;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonDeserialize {
   Class<? extends JsonDeserializer<?>> using() default JsonDeserializer.None.class;

   Class<? extends JsonDeserializer<?>> contentUsing() default JsonDeserializer.None.class;

   Class<? extends KeyDeserializer> keyUsing() default KeyDeserializer.None.class;

   Class<?> as() default NoClass.class;

   Class<?> keyAs() default NoClass.class;

   Class<?> contentAs() default NoClass.class;
}
