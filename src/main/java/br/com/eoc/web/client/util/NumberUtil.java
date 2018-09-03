package br.com.eoc.web.client.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Classe para implementar métodos utilitários para manipulação de Números
 *
 * @author Diego Pangone (diegopangone@gmail.com)
 * @since 03 de Novembro de 2011
 */
public final class NumberUtil {

    public static final String CURRENCY_FORMAT = "###,##0.00";

    /**
     * Método para formatar um valor Float em uma String no formato de moeda Brasileira
     *
     * @param value Valor a ser formatado
     * @return String no formato de Moeda
     */
    public static String formatFloatToCurrencyString(Float value) {
        NumberFormat nf = new DecimalFormat(CURRENCY_FORMAT);
        return nf.format((Float) value);
    }

    /**
     * Método para formatar um valor String Moeda em um Float
     *
     * @param value String no formato Moeda a ser convertida para Float
     * @return Float valor convertido
     */
    public static Float convertCurrencyStringToFloat(String currencyStr) {
        try {
            NumberFormat nf = new DecimalFormat(CURRENCY_FORMAT);
            return nf.parse(currencyStr).floatValue();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Método para aplicar o ROUD e o SCALE default ao BigDecimal
     *
     * @param number
     * @return
     */
    public static BigDecimal formatDefaultBigDecimal(BigDecimal number) {
        return number.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Método para aplicar o ROUD e o SCALE default ao Float
     *
     * @param number
     * @return
     */
    public static Float formatDefaultFloat(Float number) {
        return formatDefaultBigDecimal(new BigDecimal(number)).floatValue();
    }

    /**
     * Método para subtrair dois valores do tipo moeda
     *
     * @return
     */
    public static Float substractCurrency(Float number1, Float number2) {
        BigDecimal b1 = new BigDecimal(number1);
        BigDecimal b2 = new BigDecimal(number2);
        return formatDefaultBigDecimal(b1.subtract(b2)).floatValue();
    }

    /**
     * Método para calcular a divisão de dois números
     *
     * @return
     */
    public static Float divideCurrency(Float number1, Float number2) {
        BigDecimal b1 = new BigDecimal(number1);
        BigDecimal b2 = new BigDecimal(number2);
        return formatDefaultBigDecimal(b1.divide(b2)).floatValue();
    }

    /**
     * Método para calcular a multiplicação de dois números
     *
     * @return
     */
    public static Float multiplyCurrency(Float number1, Float number2) {
        BigDecimal b1 = new BigDecimal(number1);
        BigDecimal b2 = new BigDecimal(number2);
        return formatDefaultBigDecimal(b1.multiply(b2)).floatValue();
    }

    /**
     * Método para subtrair dois valores do tipo moeda
     *
     * @return
     */
    public static Float sumCurrency(Float number1, Float number2) {
        BigDecimal b1 = new BigDecimal(number1);
        BigDecimal b2 = new BigDecimal(number2);
        return formatDefaultBigDecimal(b1.add(b2)).floatValue();
    }

    /**
     * Método para verificar se data string, ela representa um valor numérico
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
