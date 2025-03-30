package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.dto.IterateDto;
import org.seasar.sastruts.example.form.IterateForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 繰り返し入力のサンプルです。
 *
 * @author Naoki Takezoe
 */
public class IterateAction {

	@ActionForm
	@Resource
	protected IterateForm iterateForm;

	public IterateDto[] rows;

	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

	@Execute(validator=false)
	public String send(){
		this.rows = iterateForm.rows;
		return "result.jsp";
	}

}
