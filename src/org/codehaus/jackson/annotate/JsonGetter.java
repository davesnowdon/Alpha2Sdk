package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** @deprecated */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
@Deprecated
public @interface JsonGetter {
   String value() default "";
}
