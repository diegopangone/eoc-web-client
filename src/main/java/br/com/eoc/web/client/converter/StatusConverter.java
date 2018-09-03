package br.com.eoc.web.client.converter;

import org.apache.commons.lang3.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Classe para converter objetos Boolean em String representando o status Ativo e Inativo
 *
 * @author Diego Pangone (diegopangone@gmail.com)
 * @since 27 de Novembro de 2011
 */
@FacesConverter(value = "statusConverter")
public class StatusConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (StringUtils.isNotEmpty(value)) {
            return component.getAttributes().get(component.getClientId());
        }
        return value;
    }

    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && StringUtils.isNotEmpty(value.toString())) {
            if (value instanceof Boolean) {
                component.getAttributes().put(component.getClientId(), value);
                boolean status = ((Boolean) value).booleanValue();
                return (status ? "Ativo" : "Inativo");
            }
            return value.toString();
        }
        return null;
    }

}
