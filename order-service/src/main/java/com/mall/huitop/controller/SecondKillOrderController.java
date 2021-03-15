//package com.mall.huitop.controller;
//
//import com.mall.huitop.entity.Product;
//import com.mall.huitop.event.OrderEvent;
//import com.mall.huitop.haoge.Result;
//import com.mall.huitop.model.OrderDto;
//import com.mall.huitop.service.EventPublishService;
//import com.mall.huitop.service.ProductService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.TimeUnit;
//
///**
// * 秒杀商品
// * @author zhuhaihui
// * @date 2020-06-01 11:14
// */
//@RestController
//@RefreshScope
//public class SecondKillOrderController {
//    private static final Logger logger= LoggerFactory.getLogger(SecondKillOrderController.class);
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private EventPublishService eventPublishService;
//
//    @Autowired
//    private Sender sender;
//    public final static ConcurrentMap<Long,Boolean> productSoldOutMap=new ConcurrentHashMap<Long,Boolean>();
//    public final static int ZERO = 0;
//    public final static int NINENINENIE = 9999;
//    public static ConcurrentMap<Long, Boolean> getProductSoldOutMap() {
//        return productSoldOutMap;
//    }
//
//    @PostConstruct
//    public void initStock(){
//        List<Product> products = productService.getProductList();
//        for (Product product:products){
//            stringRedisTemplate.opsForValue().set(String.valueOf(product.getId()),product.getStock()+"",300L, TimeUnit.SECONDS);
//            productSoldOutMap.put(product.getId(),false);
//        }
//    }
//
//    @GetMapping("/secondKill/{productId}")
//    public Result<String> secondKill(@PathVariable("productId") Long productId){
//        try{
//            if (productSoldOutMap.get(productId) == true){
//                logger.info("商品已售完");
//                return Result.ofFail(NINENINENIE,"商品已售完");
//            }
//            //校验订单是否合法，合法就redis库存减去1
//            Long decrement = stringRedisTemplate.opsForValue().decrement(productId+"");
//            if (decrement < ZERO){
//                productSoldOutMap.put(productId,true);
//                stringRedisTemplate.opsForValue().increment(productId+"");
//                return Result.ofFail(NINENINENIE,"商品已售完");
//            }
//            OrderDto orderDto=new OrderDto();
//            orderDto.setName("jack");
//            orderDto.setPhone("11111111");
//            //发布一个事件短信通知
//            eventPublishService.publishEvent(new OrderEvent(this,orderDto));
//            sender.send(productId);
//        }catch (Exception e){
//            logger.error("创建订单失败",e);
//            stringRedisTemplate.opsForValue().increment(productId+"");
//            return Result.ofFail(NINENINENIE,"创建订单失败");
//        }
//        return Result.ofSuccess("秒杀成功");
//    }
//
//    public String fallback(String name, Throwable e){
//        return "fallback";
//    }
//
//
//}
