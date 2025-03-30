package org.seasar.sastruts.example.entity;

import javax.annotation.Generated;
import org.seasar.sastruts.example.entity.DeptNames._DeptNames;
import org.seasar.sastruts.example.entity.EmpNames._EmpNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.40", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2009/11/08 21:22:29")
public class Names {

    /**
     * {@link Dept}の名前クラスを返します。
     * 
     * @return Deptの名前クラス
     */
    public static _DeptNames dept() {
        return new _DeptNames();
    }

    /**
     * {@link Emp}の名前クラスを返します。
     * 
     * @return Empの名前クラス
     */
    public static _EmpNames emp() {
        return new _EmpNames();
    }
}