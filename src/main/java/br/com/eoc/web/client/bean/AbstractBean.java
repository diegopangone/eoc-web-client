package br.com.eoc.web.client.bean;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@URLMappings(mappings = {
        @URLMapping(id = "home", pattern = "/home", viewId = "/pages/home.jsf"),
        @URLMapping(id = "home-teste", pattern = "/home-teste", viewId = "/pages/home-teste.jsf"),
        @URLMapping(id = "hello", pattern = "/hello", viewId = "/pages/hello.jsf"),
        @URLMapping(id = "accessDenied", pattern = "/accessDenied", viewId = "/pages/accessDenied.jsf"),
        @URLMapping(id = "accessSucess", pattern = "/accessSucess", viewId = "/pages/accessSucess.jsf"),
        @URLMapping(id = "usuario", pattern = "/usuario", viewId = "/pages/user/usuario.jsf"),
        @URLMapping(id = "quem-somos", pattern = "/quem-somos", viewId = "/pages/quem-somos.jsf"),
        @URLMapping(id = "produtores-e-fornecedores", pattern = "/produtores-e-fornecedores", viewId = "/pages/produtores-fornecedores.jsf"),
        @URLMapping(id = "loja", pattern = "/loja", viewId = "/pages/loja.jsf"),

})
public abstract class AbstractBean implements Serializable {

    private static final Logger log = Logger.getLogger(AbstractBean.class);

    protected abstract void initBean();

    @PostConstruct
    protected void init() {
        log.debug("Inicializando Bean: " + this.getClass());
        this.initBean();
    }

}
