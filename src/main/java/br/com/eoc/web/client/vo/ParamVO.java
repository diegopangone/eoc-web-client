/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eoc.web.client.vo;

import br.com.eoc.web.client.enums.ParamType;
import br.com.eoc.web.client.enums.Parameters;

public class ParamVO extends AbstractVO {
    private static final long serialVersionUID = 1L;

    private Integer idParam;
    private Parameters param;
    private ParamType type;
    private String value;
    private String description;

    @Override
    public Integer getId() {
        return this.idParam;
    }

    public Integer getIdParam() {
        return idParam;
    }

    public void setIdParam(Integer idParam) {
        this.idParam = idParam;
    }

    public Parameters getParam() {
        return param;
    }

    public void setParam(Parameters param) {
        this.param = param;
    }

    public ParamType getType() {
        return type;
    }

    public void setType(ParamType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
