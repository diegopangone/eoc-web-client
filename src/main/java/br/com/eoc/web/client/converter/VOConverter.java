package br.com.eoc.web.client.converter;

import br.com.eoc.web.client.vo.AbstractVO;
import org.apache.commons.lang3.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "voConverter")
public class VOConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		if (StringUtils.isNotEmpty(value)) {
			return component.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		if (value != null && StringUtils.isNotEmpty(value.toString())) {
			if (value instanceof AbstractVO) {
				AbstractVO vo = (AbstractVO) value;
				component.getAttributes().put(vo.getId().toString(), vo);
				return vo.getId().toString();
			}
			return value.toString();
		}
		return null;
	}

}
