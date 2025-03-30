package org.seasar.sastruts.example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Validator;

/**
 * 配列の必須チェック用のアノテーションです。
 *
 * @author Naoki Takezoe
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Validator("requiredArray")
public @interface RequiredArray {

    Msg msg() default @Msg(key = "errors.required");

    Arg arg0() default @Arg(key = "");

    String target() default "";
}
