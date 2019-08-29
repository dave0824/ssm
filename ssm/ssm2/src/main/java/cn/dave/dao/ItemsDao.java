package cn.dave.dao;

import cn.dave.domain.Items;

public interface ItemsDao {
    Items findById(Integer id);
}
