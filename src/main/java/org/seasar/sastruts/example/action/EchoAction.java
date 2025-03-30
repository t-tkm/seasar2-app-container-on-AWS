package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.EchoForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * エコーアプリケーションのアクションです。
 *
 * @author Naoki Takezoe
 */
public class EchoAction {

	/** アクションフォーム */
	@Resource
	@ActionForm
	protected EchoForm echoForm;

	/** 入力画面の実行メソッド */
	@Execute(validator = false)
	public String index(){
		return "input.jsp";
	}

	/** エコー画面の実行メソッド */
	@Execute(validator = true, input = "input.jsp")
	public String echo() {
		return "echo.jsp";
	}

}
