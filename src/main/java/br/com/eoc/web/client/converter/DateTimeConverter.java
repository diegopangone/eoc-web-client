package br.com.eoc.web.client.converter;

import br.com.eoc.web.client.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Date;

@FacesConverter(value = "dateTimeConverter")
public class DateTimeConverter implements Converter {

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
                return DateUtil.parseDateToDateTimeString((Date) value);
            }
            return value.toString();
        }
        return null;
    }

}
