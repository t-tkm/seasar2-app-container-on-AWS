package org.seasar.sastruts.example.service;

import java.util.List;
import javax.annotation.Generated;
import org.seasar.sastruts.example.entity.Dept;

import static org.seasar.extension.jdbc.operation.Operations.*;
import static org.seasar.sastruts.example.entity.DeptNames.*;

/**
 * {@link Dept}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.39", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2009/10/03 1:08:37")
public class DeptService extends AbstractService<Dept> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Dept findById(Long id) {
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
    public Dept findByIdVersion(Long id, Integer versionNo) {
        return select().id(id).version(versionNo).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Dept> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
}