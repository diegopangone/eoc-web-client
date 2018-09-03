package br.com.eoc.web.client.util;

import org.jboss.logging.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateUtil {

	private static final Logger log = Logger.getLogger(DateUtil.class);

	/**
	 * Padrão de datas utilizadas pelo sistema
	 */
	public static final String DATE_PATTERN = "dd/MM/yyyy";

	/**
	 * Padrão de hora e minutos utilizadas pelo sistema
	 */
	public static final String HOUR_MINUTE_PATTERN = "HH:mm";

	/**
	 * Padrão de datas utilizadas pelo sistema
	 */
	public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

	/**
	 * Método para converter uma Data em uma String no formato padrão utilizado pelo aplicativo
	 *
	 * @param date
	 *            Data a ser convertida
	 * @return String no formato de data padrão do sistema
	 */
	public static String parseDateToString(Date date) {
		try {
			return new SimpleDateFormat(DATE_PATTERN).format(date);
		} catch (Exception e) {
			log.warn("Erro na conversão da data " + date + " para uma string no formato " + DATE_PATTERN);
			return null;
		}
	}

	/**
	 * Método para converter uma Data em uma String no formato de data e hora
	 *
	 * @param date
	 *            Data a ser convertida
	 * @return String no formato de data e hora padrão do sistema
	 */
	public static String parseDateToDateTimeString(Date date) {
		try {
			return new SimpleDateFormat(DATE_TIME_PATTERN).format(date);
		} catch (Exception e) {
			log.warn("Erro na conversão da data " + date + " para uma string no formato " + DATE_TIME_PATTERN);
			return null;
		}
	}

	/**
	 * Método para converter uma string, em um objeto Date
	 *
	 * @return
	 */
	public static Date parseStringToDate(String strDate) {
		try {
			DateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
			return formatter.parse(strDate);
		} catch (Exception ex) {
			log.warn("Erro na conversão da String " + strDate + " para um Objeto Date no formato " + DATE_PATTERN);
			return null;
		}
	}

	/**
	 * Método para obter a diferença de meses entre duas datas
	 *
	 * @param dateStart
	 *            Data inicial, Menor data
	 * @param dateEnd
	 *            Data final, Maior data
	 * @return diferença de meses
	 */
	public static int getMonthDiff(Date dateStart, Date dateEnd) {
		int count = 0;
		if (dateStart != null && dateEnd != null && dateStart.before(dateEnd)) {

			Calendar clStart = Calendar.getInstance();
			clStart.setTime(dateStart);

			Calendar clEnd = Calendar.getInstance();
			clEnd.setTime(dateEnd);

			while (clStart.get(Calendar.MONTH) != clEnd.get(Calendar.MONTH) || clStart.get(Calendar.YEAR) != clEnd.get(Calendar.YEAR)) {
				clStart.add(Calendar.MONTH, 1);
				count++;
			}
		}
		return count;
	}

	/**
	 * Método para obter o dia corrente do mês
	 *
	 * @return
	 */
	public static int getCurrentDayOfWeek() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Método para converter uma String em um Time (Objeto Date)
	 *
	 * @param strDate
	 * @return
	 */
	public static Date parseStringToTime(String strDate) {
		try {
			DateFormat formatter = new SimpleDateFormat(HOUR_MINUTE_PATTERN);
			return formatter.parse(strDate);
		} catch (Exception ex) {
			log.warn("Erro na conversão da String " + strDate + " para um Objeto Date no formato " + HOUR_MINUTE_PATTERN);
			return null;
		}
	}

	/**
	 * Método para converter um Date em uma String representando um Time HH:mm
	 *
	 * @param time
	 * @return
	 */
	public static String parseTimeToString(Date time) {
		try {
			DateFormat formatter = new SimpleDateFormat(HOUR_MINUTE_PATTERN);
			return formatter.format(time);
		} catch (Exception ex) {
			log.warn("Erro na conversão da String " + time + " para um Objeto Date no formato " + HOUR_MINUTE_PATTERN);
			return null;
		}
	}

	/**
	 * Método para atribuir a data/hora corrente em objeto date
	 *
	 * @param onlyDate
	 * @return
	 */
	public static Date setCurrentTimeStampOnDate(Date onlyDate) {
		Calendar dateTime = Calendar.getInstance();
		Calendar date = Calendar.getInstance();
		date.setTime(onlyDate);
		date.set(Calendar.HOUR_OF_DAY, dateTime.get(Calendar.HOUR_OF_DAY));
		date.set(Calendar.MINUTE, dateTime.get(Calendar.MINUTE));
		date.set(Calendar.SECOND, dateTime.get(Calendar.SECOND));
		return date.getTime();
	}

}
