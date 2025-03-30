package org.seasar.sastruts.example.util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.seasar.struts.taglib.S2Functions;

/**
 * カスタムタグのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class HelloTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String name;

	public void setName(String name){
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().write(
					String.format("こんにちは、<strong>%s</strong>さん！",
						S2Functions.h(this.name)));

			return SKIP_BODY;

		} catch(IOException ex){
			throw new JspException(ex);
		}
	}

}
