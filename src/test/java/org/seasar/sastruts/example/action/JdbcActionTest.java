package org.seasar.sastruts.example.action;

import static org.easymock.EasyMock.expect;

import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.aop.interceptors.MockInterceptor;
import org.seasar.framework.unit.S2TigerTestCase;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.sastruts.example.entity.Emp;
import org.seasar.sastruts.example.form.JdbcForm;
import org.seasar.sastruts.example.service.EmpService;

/**
 * {@link JdbcAction}のテストケースです。
 *
 * @author Naoki Takezoe
 */
public class JdbcActionTest extends S2TigerTestCase {

	@EasyMock
	private EmpService empService;

	public void setUp() throws Exception {
		super.setUp();
	}

	public void testIndexWithDicon() {
		include("JdbcActionTest.dicon");

		JdbcAction action = new JdbcAction();

		JdbcForm jdbcForm = new JdbcForm();
		jdbcForm.page = "0";
		action.jdbcForm = jdbcForm;

		action.empService = (EmpService) getComponent(EmpService.class);

		String result = action.index();

		assertEquals("index.jsp", result);
		assertEquals(3, action.empList.size());
		assertEquals(100, action.total);
	}

	public void testIndexWithoutDicon() {
		JdbcAction action = new JdbcAction();

		JdbcForm jdbcForm = new JdbcForm();
		jdbcForm.page = "0";
		action.jdbcForm = jdbcForm;

		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp());
		empList.add(new Emp());
		empList.add(new Emp());

		MockInterceptor mock = new MockInterceptor();
		mock.setReturnValue("findAllOrderById", empList);
		mock.setReturnValue("getCount", 100);

		action.empService = (EmpService) mock.createProxy(EmpService.class);

		String result = action.index();

		assertEquals("index.jsp", result);
		assertEquals(3, action.empList.size());
		assertEquals(100, action.total);
	}

	public void recordIndexWithEasyMock() throws Exception {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp());
		empList.add(new Emp());
		empList.add(new Emp());

		expect(empService.getCount()).andReturn(100l);
		expect(empService.findAllOrderById(5, 0)).andReturn(empList);
	}

	public void testIndexWithEasyMock() {
		JdbcAction action = new JdbcAction();
		action.empService = empService;

		JdbcForm jdbcForm = new JdbcForm();
		jdbcForm.page = "0";
		action.jdbcForm = jdbcForm;

		String result = action.index();

		assertEquals("index.jsp", result);
		assertEquals(3, action.empList.size());
		assertEquals(100, action.total);
	}


}
