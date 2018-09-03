package br.com.eoc.web.client.enums;

import br.com.eoc.web.client.util.EnumUtil;

public enum ParamType implements Enum<String>{

    DATE("D"),
    STRING("S"),
    FLOAT("F"),
    INTEGER("I");	
    
    private String type;

    private ParamType(String type) {
	this.type = type;
    }

    public String getValue() {
	return this.type;
    }

    public static ParamType fromValue(String value){
        return EnumUtil.getEnumFromValue(ParamType.class, value);
    }
    
}
