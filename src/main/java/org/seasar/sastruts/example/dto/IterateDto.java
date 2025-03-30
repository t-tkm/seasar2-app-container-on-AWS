package org.seasar.sastruts.example.dto;

import org.seasar.sastruts.example.action.IterateAction;
import org.seasar.sastruts.example.form.IterateForm;

/**
 * 繰り返し入力のサンプルで1行分のデータを格納するために使用するDTOです。
 *
 * @author Naoki Takezoe
 * @see IterateForm
 * @see IterateAction
 */
public class IterateDto {

	public String name = "";

	public String mail = "";

}
