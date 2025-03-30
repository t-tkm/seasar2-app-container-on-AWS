package org.seasar.sastruts.example.action;

import org.seasar.extension.dataset.DataSet;
import org.seasar.extension.dataset.impl.SqlReader;
import org.seasar.extension.unit.S2TestCase;

public class WriteTest extends S2TestCase {

	public void setUp() throws Exception {
		super.setUp();
		include("app.dicon");
	}

	public void testWriteExcel(){
        SqlReader reader = new SqlReader(getDataSource());
        reader.addTable("DEPT");
        reader.addTable("EMP");

        DataSet result = reader.read();
        writeXls("Test.xls", result);
	}

}
