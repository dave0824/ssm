package cn.dave.mybatis.cfg;

/**
 * @program: mybatis04design
 * @description:用于封装执行SQL语句和结果类型的全限定类名
 * @author: dave
 * @create: 2019-06-24 11:23
 **/

public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
