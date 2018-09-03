package br.com.eoc.web.client.util;

import br.com.eoc.web.client.enums.Enum;
import org.jboss.logging.Logger;

import java.util.Arrays;
import java.util.List;

public abstract class EnumUtil {

	private static final Logger log = Logger.getLogger(EnumUtil.class);

	/**
	 * Método para obter a Lista de constantes Enums, a partir de uma Classe Enum
	 * @param enumm Classe Enum que contém os Enums (Propriedades) a serem listados
	 * @return Lista de Enums
	 */
	public static <T extends Enum> List<T> getListEnums(Class<T> enumm) {
		try {
			Class<T> c = (Class<T>) Class.forName(enumm.getName());
			return Arrays.asList(c.getEnumConstants());
		} catch (ClassNotFoundException x) {
			log.fatal("Não foi possível localizar a classe \""+enumm.getName()+"\" filha de Enum", x);
		}
		return null;
	}

	/**
	 * Método para localizar um Enum, à partir do seu valor
	 * @param enumm Classe Enum ao qual irá localizar o Enum (Propriedade)
	 * @param value Valor do Enum
	 * @return Enum de acordo com a classe e valor informado
	 */
	public static <T extends Enum> T getEnumFromValue(Class<T> enumm, Object value) {
		List<T> enums = getListEnums(enumm);
		for( T e : enums ){
			if( e.getValue().equals(value)){
				return e;
			}
		}
		return null;
	}
}
