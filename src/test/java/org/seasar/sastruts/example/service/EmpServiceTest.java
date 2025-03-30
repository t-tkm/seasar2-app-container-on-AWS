package org.seasar.sastruts.example.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import javax.annotation.Generated;

import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.impl.SqlReader;
import org.seasar.extension.unit.S2TestCase;
import org.seasar.sastruts.example.entity.Emp;

/**
 * {@link EmpService}のテストクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.39", "org.seasar.extension.jdbc.gen.internal.model.ServiceTestModelFactoryImpl"}, date = "2009/10/03 1:13:38")
public class EmpServiceTest extends S2TestCase {

    private EmpService empService;

	/**
     * 事前処理をします。
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("app.dicon");
    }

    /**
     * {@link #empService}が利用可能であることをテストします。
     *
     * @throws Exception
     */
    public void testAvailable() throws Exception {
        assertNotNull(empService);
    }

//    public void testFindByNameTx(){
//        // TODO 初期データの投入
//        Emp emp = empService.findByName("SMITH");
//        assertEquals("SMITH", emp.empName);
//    }

    public void testInsertTx(){
    	readXlsAllReplaceDb("EmpServiceTest_testInsert_data.xls");

        Emp emp = new Emp();
        emp.empName = "Naoki Takezoe";
        emp.empNo = 99;
        emp.deptId = 1;
        emp.hiredate = new Date(Calendar.getInstance().getTimeInMillis());
        emp.mgrId = 1;
        emp.sal = new BigDecimal(1000);

        empService.insert(emp);

        SqlReader reader = new SqlReader(getDataSource());
        reader.addTable("EMP");
        DataSet result = reader.read();
        DataSet expect = readXls("EmpServiceTest_testInsert_expect.xls");

        assertEquals(expect, result);
    }

}