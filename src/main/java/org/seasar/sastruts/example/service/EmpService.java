package org.seasar.sastruts.example.service;

import static org.seasar.extension.jdbc.operation.Operations.asc;
import static org.seasar.sastruts.example.entity.EmpNames.id;

import java.util.List;

import javax.annotation.Generated;

import org.seasar.sastruts.example.SqlFiles;
import org.seasar.sastruts.example.dto.EmpWithDept;
import org.seasar.sastruts.example.entity.Emp;

/**
 * {@link Emp}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.39", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2009/10/02 11:05:29")
public class EmpService extends AbstractService<Emp> {

    /**
     * 識別子でエンティティを検索します。
     *
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Emp findById(Long id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子とバージョン番号でエンティティを検索します。
     *
     * @param id
     *            識別子
     * @param versionNo
     *            バージョン番号
     * @return エンティティ
     */
    public Emp findByIdVersion(Long id, Integer versionNo) {
        return select().id(id).version(versionNo).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     *
     *
     * @return エンティティのリスト
     */
    public List<Emp> findAllOrderById() {
        return select().orderBy(asc(id()))
            .getResultList();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     *
     * @param limit 表示件数
     * @param offset オフセット
     * @return エンティティのリスト
     */
    public List<Emp> findAllOrderById(int limit, int offset) {
        return select().orderBy(asc(id()))
            .limit(limit)
            .offset(offset)
            .getResultList();
    }

    public List<EmpWithDept> getEmpWithDept(){
    	return jdbcManager.selectBySqlFile(EmpWithDept.class,
    		SqlFiles.SERVICE_EMP_SERVICE_GET_EMP_WITH_DEPT)
    		.getResultList();
    }

    /**
     * SQLファイルに渡すパラメータを格納するDTO
     */
    public class SearchEmployeeParam {
    	public Integer salaryMin;
    	public Integer salaryMax;
    }

    /**
     * SQLファイルの検索結果を受け取るDTO
     */
    public class SearchEmployeeDto {
    	public Long id;
    	public String empName;
    }
}