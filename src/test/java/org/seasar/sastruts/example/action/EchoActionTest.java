package org.seasar.sastruts.example.action;

import org.seasar.sastruts.example.form.EchoForm;

import junit.framework.TestCase;

/**
 * {@link EchoAction}のテストケースです。
 *
 * @author Naoki Takezoe
 */
public class EchoActionTest extends TestCase {

	public void testIndex(){
		EchoAction action = new EchoAction();
		String result = action.index();
		assertEquals("input.jsp", result);
	}

	public void testEcho(){
		EchoAction action = new EchoAction();

		EchoForm form = new EchoForm();
		form.name = "Naoki Takezoe";
		action.echoForm = form;

		String result = action.echo();
		assertEquals("echo.jsp", result);
	}

}
