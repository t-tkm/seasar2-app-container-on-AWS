package org.seasar.sastruts.example.action;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.annotation.Prerequisite;
import org.seasar.framework.unit.annotation.WarmDeploy;

/**
 * {@link Prerequisite}アノテーションを使用したテストケースのサンプルです。
 *
 * @author Naoki Takezoe
 */
@RunWith(Seasar2.class)
public class IndexActionTest {

	@Prerequisite("getPlatform() == 'Windows'")
	@WarmDeploy(false)
	public void testIndex() {
		IndexAction action = new IndexAction();
		String result = action.index();

		assertEquals("index.jsp", result);
	}

	public String getPlatform(){
		return "Windows";
	}

}
