package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.form.ValidationForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 相関チェックのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class ValidationAction {

	@Resource
	@ActionForm
	protected ValidationForm validationForm;

	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

	@Execute(validator=true, input="index.jsp")
	public String send(){
		return "send.jsp";
	}
}
