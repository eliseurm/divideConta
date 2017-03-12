package br.eng.eliseu.gwt.material.shared.utils;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class UtilsClient {

	/**
	 * Verifica de o valor do campo � um valor valido.
	 * Um valor valido � quando ele tem o tamanho maior que 3 caracteres. 
	 * @param text
	 * @return 
	 */
	public static boolean isValidFieldText(String text) {
		if (text == null) {
			return false;
		}
		return text.length() > 3;
	}

	/**
	 * Compara o valor em relacao a 0 (zero)
	 * @param valor
	 * @return 
	 * -1 se valor < 0 ou valor = null
	 *  0 se valor = 0
	 *  1 se valor > 0
	 *  
	 */
	public static int isValidFieldDouble( Double valor){
		if ( valor == null ) {
			return -1;
		}
		double n = (double)valor;
		if (n < 0 ){
			return -1;
		} else if (n == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Compara o valor em relacao a 0 (zero)
	 * @param valor
	 * @return
	 * -1 se valor < 0 ou valor = null
	 *  0 se valor = 0
	 *  1 se valor > 0
	 * 
	 */
	public static int isValidFieldInteger( Integer valor){
		if ( valor == null ) {
			return -1;
		}
		int n = (int)valor;
		if (n < 0 ){
			return -1;
		} else if (n == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Compara o valor em relacao a 0 (zero)
	 * @param valor
	 * @return
	 * -1 se valor < 0 ou valor = null
	 *  0 se valor = 0
	 *  1 se valor > 0
	 * 
	 */
	public static int isValidFieldBigDecimal( BigDecimal valor){
		if ( valor == null ) {
			return -1;
		}
		if (valor.compareTo(BigDecimal.valueOf(0)) < 0 ){
			return -1;
		} else if (valor.compareTo(BigDecimal.valueOf(0)) == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Trunca um Double com a quantidade de cadas decimais informada no parametro
	 * @param valor
	 * @param decimais
	 * @return
	 */
	public static Double truncaDouble( Double valor, double decimais){
		if (decimais<0){
			decimais = 0;
		}
		decimais = Math.pow(10, decimais);
		if (valor == null){
			valor = new Double(0);
		}
		valor = Math.floor(valor*decimais)/decimais;

		return valor;
	}

	public static BigDecimal truncaBigDecimal( BigDecimal valor, int decimais){
		if (valor == null){
			valor = new BigDecimal("0");
		}
		return valor.setScale(decimais, RoundingMode.UP);
	}

	/**
	 * Arredonda um valor deixando o resultado com um valor que seja multiplo de "arredonda"<br>
	 * Ex: <br>
	 * 10.50 = arredondaBigDecimal( 10.01, 0.50 )<br>
	 * 10.10 = arredondaBigDecimal( 10.01, 0.10 )<br>
	 * 
	 * @param valor
	 * @param arredonda
	 * @return
	 */
	public static BigDecimal arredondaBigDecimal( BigDecimal valor, String arredonda){
		return arredondaBigDecimal(valor, new BigDecimal(arredonda));
	}

	/**
	 * Arredonda um valor deixando o resultado com um valor que seja multiplo de "arredonda"<br>
	 * Ex: <br>
	 * 10.50 = arredondaBigDecimal( 10.01, 0.50 )<br>
	 * 10.10 = arredondaBigDecimal( 10.01, 0.10 )<br>
	 * 
	 * @param valor
	 * @param arredonda
	 * @return
	 */
	public static BigDecimal arredondaBigDecimal( BigDecimal valor, BigDecimal arredonda){
		if (valor==null){
			valor = new BigDecimal("0");
		}
		if (arredonda==null | arredonda.compareTo(BigDecimal.valueOf(0.0)) == 0){
			arredonda = new BigDecimal("1");
		}

		return valor.divide(arredonda, 0, RoundingMode.UP).multiply(arredonda);
	}

	/**
	 * Arredonda uma valor para cima ou para baixo de acordo com o parametro arredondamento
	 * 
	 * @param valor
	 * @param decimais ( pode ser valor positivo ou negativo )
	 * @param arredondamento ( -1, 0, 1 )
	 * @return
	 */
	public static Double arredondaDouble( Double valor, double decimais, int arredondamento ){
		if ( arredondamento < -1 ){
			arredondamento = -1;
		}
		if (arredondamento > 1){
			arredondamento = 1;
		}

		valor = truncaDouble(valor, decimais);
		if (!valor.equals(0.0)){
			decimais = Math.pow(10, decimais);
			valor = valor + (1 / decimais * arredondamento);
		}

		return valor;
	}

	public static String subStrLeft(String text, int length) {
		if (length<0){
			return "";
		}
		if (text.length() <= length) {
			return text;
		}
		return text.substring(0, length);
	}

	public static String subStrRight(String text, int length) {
		if (length<0){
			return "";
		}
		if (text.length() <= length) {
			return text;
		}
		return text.substring(text.length()-length);
	}  

	public static String subStrMid(String text, int start, int end){
		if (end<0 || text.length()<start ){
			return "";
		}
		return text.substring(start, end);
	}

	public static String Mid(String text, int start){
		if (text.length()<start ){
			return "";
		}
		return text.substring(start, text.length() - start);
	}


}
