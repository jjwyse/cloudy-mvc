package com.jjw.cloudymvc.web.mvc;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
@Documented
@Inherited
public @interface CloudElementApi {

    /**
     * @return
     */
    Version version() default Version.ONE;

    /**
     * @return
     */
    boolean tokenRequired() default true;
}
