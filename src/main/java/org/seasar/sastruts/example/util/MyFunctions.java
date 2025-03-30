package org.seasar.sastruts.example.util;

/**
 * EL関数のサンプルです。
 *
 * @author Naoki Takezoe
 */
public class MyFunctions {

	/**
	 * <code>boolean</code>値を表示用の文字列に変換します。
	 *
	 * @param value 変換する<code>boolean</code>値
	 * @return <code>true</code>の場合○、<code>false</code>の場合×
	 */
	public static String boolean2label(boolean value){
		if(value){
			return "○";
		} else {
			return "×";
		}
	}

}
