package br.com.eoc.web.client.enums;


import br.com.eoc.web.client.util.EnumUtil;

public enum Parameters implements Enum<String> {

    QTDE_HORAS_CORTE_DISPONIBILIDADE_VENDA_DA_ROTA,
    MAILCHIMP_HABILITA,
    MAILCHIMP_DE_PARA,
    MAILCHIMP_API_KEY,
    HABILITA_ENVIO_EMAIL_COM_PEDIDOS_PARA_FORNECEDOR,
    ;

    @Override
    public String getValue() {
        return this.name();
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static Parameters fromValue(String value){
        return EnumUtil.getEnumFromValue(Parameters.class, value);
    }
}
