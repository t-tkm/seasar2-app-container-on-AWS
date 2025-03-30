package org.seasar.sastruts.example.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.util.TokenProcessor;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

/**
 * トランザクショントークンのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class TokenAction {

	@Resource
	protected HttpServletRequest request;

	@Execute(validator=false)
	public String index(){
		TokenProcessor.getInstance().saveToken(request);
		return "index.jsp";
	}

	@Execute(validator=true, input="index.jsp")
	public String send(){
		if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
			throw new ActionMessagesException("不正なリクエストです。", false);
		}
		return "send.jsp";
	}

}
