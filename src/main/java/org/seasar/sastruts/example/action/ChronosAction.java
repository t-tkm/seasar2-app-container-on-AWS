package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.task.TaskLogger;
import org.seasar.struts.annotation.Execute;

public class ChronosAction {

	@Resource
	protected TaskLogger taskLogger;

	public String messages;

	@Execute(validator=false)
	public String index(){
		this.messages = this.taskLogger.getMessages();

		return "index.jsp";
	}

}
