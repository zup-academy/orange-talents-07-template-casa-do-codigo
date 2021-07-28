package com.github.zlbovolini.casacodigo.validation.constraint;

import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@NotBlank
public @interface Unique {

    String message() default "Valor informado já regristrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
