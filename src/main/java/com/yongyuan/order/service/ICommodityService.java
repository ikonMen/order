package com.yongyuan.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yongyuan.order.Do.CommodityPageVo;
import com.yongyuan.order.Do.SearchDto;
import com.yongyuan.order.entity.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengsheming
 * @since 2024-04-23
 */
public interface ICommodityService extends IService<Commodity> {

    IPage<CommodityPageVo> searchCommodity(SearchDto dto);

}
