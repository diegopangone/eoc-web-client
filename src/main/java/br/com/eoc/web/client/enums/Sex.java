package br.com.eoc.web.client.enums;

import br.com.eoc.web.client.util.EnumUtil;

public enum Sex implements Enum<String>{

    MALE("M"),
    FEMALE("F");	
    
    private String type;

    private Sex(String type) {
	this.type = type;
    }

    public String getValue() {
	return this.type;
    }

    public static Sex fromValue(String sex){
        return EnumUtil.getEnumFromValue(Sex.class, sex);
    }

}
