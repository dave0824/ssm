package cn.dave.dao;

import cn.dave.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    @Select("select * from member where id=#{memberId}")
    Member findById(String memberId);
}
