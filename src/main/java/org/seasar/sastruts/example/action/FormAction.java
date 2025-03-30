package org.seasar.sastruts.example.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.seasar.sastruts.example.entity.Emp;
import org.seasar.sastruts.example.form.FormForm;
import org.seasar.sastruts.example.service.EmpService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class FormAction {

	@Resource
	@ActionForm
	protected FormForm formForm;

	@Resource
	protected EmpService empService;

	@Resource
	protected HttpServletRequest request;

	public List<Emp> empList;

	public boolean cancelled;

	@Execute(validator=false)
	public String index(){
		formForm.text = "テキストフィールド";
		formForm.password = "パスワード";
		formForm.textarea = "複数行\n入力可能な\nテキストエリア";

		empList = empService.findAllOrderById();

		return "index.jsp";
	}

	@Execute(validator=true, input="/form/")
	public String send(){
		if(request.getAttribute(Globals.CANCEL_KEY) != null){
			cancelled = true;
		} else {
			cancelled = false;
		}

		return "send.jsp";
	}

}
