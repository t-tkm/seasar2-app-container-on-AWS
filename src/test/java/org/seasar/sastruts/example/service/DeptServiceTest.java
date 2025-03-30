package org.seasar.sastruts.example.service;

import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import org.seasar.extension.dataset.DataSet;
import org.seasar.framework.unit.DataAccessor;
import org.seasar.framework.unit.PreparationType;
import org.seasar.framework.unit.S2Assert;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

/**
 * {@link DeptService}のテストクラスです。
 *
 */
@RunWith(Seasar2.class)
public class DeptServiceTest {

	private TestContext context;
    private DeptService deptService;
    private DataAccessor dataAccessor;

//    /**
//     * 事前処理をします。
//     *
//     * @throws Exception
//     */
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        include("app.dicon");
//    }

    public void before() {
        context.setPreparationType(PreparationType.ALL_REPLACE);
    }

    /**
     * {@link #deptService}が利用可能であることをテストします。
     *
     * @throws Exception
     */
    public void testAvailableTx() throws Exception {
        assertNotNull(deptService);

        DataSet expect = context.getExpected();
        DataSet result = dataAccessor.readDb(expect);

        S2Assert.assertEquals(expect, result);
    }
}