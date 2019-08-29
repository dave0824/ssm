package cn.dave.service;

import cn.dave.domain.Product;

import java.util.List;

public interface IProductService {

     void save(Product product);

    List<Product> findAll();
}
