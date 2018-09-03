package br.com.eoc.web.client.scope;

import org.springframework.context.annotation.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface que será utilizada para definir o escopo de VIEW dos Beans JSF gerenciados pelo spring
 */
@Scope("view")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanViewScope {
}
