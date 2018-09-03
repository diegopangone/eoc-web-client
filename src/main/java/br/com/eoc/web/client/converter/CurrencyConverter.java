package br.com.eoc.web.client.converter;

import br.com.eoc.web.client.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "currencyConverter")
public class CurrencyConverter implements Converter {

    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return NumberUtil.convertCurrencyStringToFloat(value);
            } catch (Exception e) {
                return 0L;
            }
        }
        return value;
    }

    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && StringUtils.isNotEmpty(value.toString())) {
            if (value instanceof Float) {
                return NumberUtil.formatFloatToCurrencyString((Float) value);
            }
            return value.toString();
        }
        return null;
    }

}
