package org.seasar.sastruts.example.action;

import org.seasar.struts.annotation.Execute;

/**
 * エラー処理のサンプルです。
 *
 * @author Naoki Takezoe
 */
public class ErrorAction {

	public static class Hoge{
		public String name;

		public String execute(){
			return "Hello " + name + "!";
		}
	}

	@Execute(validator=false)
	public String index(){
		throw new RuntimeException("エラー処理のサンプルです。");
	}

}
