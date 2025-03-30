package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.ArrayCheckForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 配列の入力チェックのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class ArrayCheckAction {

	@ActionForm
	@Resource
	protected ArrayCheckForm arrayCheckForm;

	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

	@Execute(validator=true, input="index.jsp")
	public String send(){
		return "result.jsp";
	}


}
