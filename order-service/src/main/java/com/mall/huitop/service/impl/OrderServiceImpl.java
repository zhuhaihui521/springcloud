package com.mall.huitop.service.impl;

import com.mall.huitop.entity.Order;
import com.mall.huitop.entity.Product;
import com.mall.huitop.mapper.OrderMapper;
import com.mall.huitop.service.OrderService;
import com.mall.huitop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuhaihui
 * @date 2020-06-02 10:11
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductService productService;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void seckill(Long productId) {
        //查询商品
        Product product = productService.getProductById(productId);
        if (product.getStock() <= 0){
            throw new RuntimeException("商品库存已售完");
        }
        //创建秒杀订单
        Order order=new Order();
        order.setProductid(productId);
        order.setAmount(product.getPrice());
        saveOrder(order);

        //减库存
        int productStock = productService.deductProductStock(productId);
        if (productStock <= 0){
            throw new RuntimeException("商品库存已售完");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrder(Order order) {
        return orderMapper.save(order);
    }
}
