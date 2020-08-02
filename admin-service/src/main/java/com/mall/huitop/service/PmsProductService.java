package com.mall.huitop.service;

import com.mall.huitop.dto.PmsProductParam;
import com.mall.huitop.dto.PmsProductQueryParam;
import com.mall.huitop.dto.PmsProductResult;
import com.mall.huitop.entity.PmsProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 商品service
 * @Auther zhuhaihui
 * @Date 2020-08-02 19:14
 */
public interface PmsProductService {
    /**
     * 分页查询商品
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量上下架
     * @param ids
     * @param publishStatus
     * @return
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量修改推荐状态
     * @param ids
     * @param recommendStatus
     * @return
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 根据商品编号获取更新信息
     * @param id
     * @return
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * 更新商品
     * @param id
     * @param productParam
     * @return
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);
}
