package br.com.eoc.web.client.enums;

import br.com.eoc.web.client.util.EnumUtil;

import java.util.Calendar;

/**
 * Enum para definição dos dias da semana
 * @author Diego Pangone (diegopangone@gmail.com)
 * @since 14 de Dezembro de 2011
 *
 */
public enum DayOfWeek implements Enum<Integer>{

    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);


    private Integer day;

    private DayOfWeek(Integer type) {
        this.day = type;
    }

    public Integer getValue() {
        return this.day;
    }

    public static DayOfWeek getCurrentDay() {
        Calendar cal = Calendar.getInstance();
        return EnumUtil.getEnumFromValue(DayOfWeek.class, cal.get(Calendar.DAY_OF_WEEK));
    }

    public static DayOfWeek fromValue(Integer value){
        return EnumUtil.getEnumFromValue(DayOfWeek.class, value);
    }

}
