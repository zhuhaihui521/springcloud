package com.mall.huitop.mapper;

import com.mall.huitop.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-06-02 10:07
 */
@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM product where id =#{id}")
    Product getProductById(@Param("id") Long id);
    @Select("SELECT * FROM product")
    List<Product> getProductList();

    @Insert("insert into product(id,name,price,stock,pic) values(#{id},#{name},#{price},#{stock},#{pic})")
    void saveProduct(Product product);

    @Update("update product set name=#{name},price=#{price},stock=#{stock},pic=#{pic} where id=#{id}")
    void updateProduct(Product product);

    @Update("update product set stock=stock-1 where id=#{id}")
    int deductProductStock(@Param("id") Long id);

    @Delete("delete from product where id=#{id}")
    void deleteProduct(@Param("id") Long id);
}
