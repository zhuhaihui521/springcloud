package com.mall.huitop.service.impl;

import com.mall.huitop.entity.Product;
import com.mall.huitop.mapper.ProductMapper;
import com.mall.huitop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-06-02 10:18
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void secill(Long productId) {

    }

    @Override
    public Product getProductById(Long productId) {
        return productMapper.getProductById(productId);    }

    @Override
    public int deductProductStock(Long productId) {
        return productMapper.deductProductStock(productId);
    }

    @Override
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
}
