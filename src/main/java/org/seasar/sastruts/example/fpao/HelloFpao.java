package org.seasar.sastruts.example.fpao;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * S2Fisshplateのサンプルインターフェースです。
 *
 * @author Naoki Takezoe
 */
public interface HelloFpao {

	public HSSFWorkbook hello(HelloDto helloDto);

	/**
	 * {@link HelloFpao}で使用するDTOです。
	 *
	 * @author Naoki Takezoe
	 * @see HelloFpao#hello(HelloDto)
	 */
	public static class HelloDto {
		public String name;
	}

}
