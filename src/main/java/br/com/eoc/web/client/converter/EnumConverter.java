package br.com.eoc.web.client.converter;

import br.com.eoc.web.client.enums.Enum;
import org.apache.commons.lang3.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Classe para converter os Objetos filhos de Enum, que são utilizados nos componentes na interface
 *
 * @author Diego Pangone (diegopangone@gmail.com)
 * @since 11 de Setembro de 2011
 */
@FacesConverter(value = "enumConverter")
public class EnumConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (StringUtils.isNotEmpty(value)) {
            return component.getAttributes().get(value);
        }
        return value;
    }

    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null) {
            if (value instanceof Enum) {
                Enum enumm = (Enum) value;
                component.getAttributes().put(enumm.getValue().toString(), enumm);
                return enumm.getValue().toString();
            }
            return value.toString();
        }
        return null;
    }

}
