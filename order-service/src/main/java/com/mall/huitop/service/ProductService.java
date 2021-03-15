package com.mall.huitop.service;


import com.mall.huitop.entity.Product;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-06-02 10:17
 */
public interface ProductService {
    public void secill(Long productId);
    public Product getProductById(Long productId);
    public int deductProductStock(Long productId);
    public List<Product> getProductList();
}
