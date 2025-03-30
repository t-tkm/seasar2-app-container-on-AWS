package org.seasar.sastruts.example.form;

import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Validwhen;

public class ValidationForm {

	public String value1;

	@Validwhen(test="(value1 == value2)", msg=@Msg(key="値1と値2が異なります。", resource=false))
	public String value2;

}
