package br.com.eoc.web.client.converter;

import br.com.eoc.web.client.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Date;

/**
 * Classe para converter objetos Date em String interface
 *
 * @author Diego Pangone (diegopangone@gmail.com)
 * @since 04 de Setembro de 2011
 */
@FacesConverter(value = "dateConverter")
public class DateConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (StringUtils.isNotEmpty(value)) {
            return component.getAttributes().get(component.getClientId());
        }
        return value;
    }

    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && StringUtils.isNotEmpty(value.toString())) {
            if (value instanceof Date) {
                component.getAttributes().put(component.getClientId(), value);
                return DateUtil.parseDateToString((Date) value);
            }
            return value.toString();
        }
        return null;
    }

}
