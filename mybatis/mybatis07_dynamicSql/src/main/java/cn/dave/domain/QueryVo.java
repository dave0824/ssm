package cn.dave.domain;

import java.util.List;

/**
 * @program: mybatis07_dynamicSql
 * @description:一个装id的类，以便于实现根据多个uid查找用户
 * @author: dave
 * @create: 2019-06-26 17:06
 **/

public class QueryVo {
    List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
