package cn.dave.service;

import cn.dave.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll() throws Exception;

    Orders findById(String id) throws Exception;

    List<Orders> findAll(int page, int size) throws Exception;
}
