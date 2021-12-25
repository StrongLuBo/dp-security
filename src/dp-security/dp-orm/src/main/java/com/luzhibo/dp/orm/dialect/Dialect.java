package com.luzhibo.dp.orm.dialect;

/**
 * 数据库方言抽象类
 * @author 89754
 */
public abstract class Dialect {

    /**
     * 得到分页sql
     * @param sql
     * @param offset
     * @param limit
     * @return String
     */
    public abstract String getLimitString(String sql, int offset, int limit);

    /**
     * 得到分页sql
     * @param sql
     * @return String
     */
    public abstract String getCountString(String sql);

}
