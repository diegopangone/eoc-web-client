package br.com.eoc.web.client.enums;


import br.com.eoc.web.client.util.EnumUtil;

public enum PersonType implements Enum<String>{

    JURIDICAL("J"),
    PHYSICS("P");

    private String type;

    private PersonType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.type;
    }

    public static PersonType fromValue(String sex){
        return EnumUtil.getEnumFromValue(PersonType.class, sex);
    }
}
