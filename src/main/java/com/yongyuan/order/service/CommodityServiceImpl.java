package com.yongyuan.order.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yongyuan.order.Do.CommodityPageVo;
import com.yongyuan.order.Do.SearchDto;
import com.yongyuan.order.entity.Commodity;
import com.yongyuan.order.mapper.CommodityMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yongyuan.order.utils.WrappersUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengsheming
 * @since 2024-04-23
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {
    @Override
    public IPage<CommodityPageVo> searchCommodity(SearchDto dto) {
        LambdaQueryWrapper<Commodity> eq = Wrappers.lambdaQuery(Commodity.class).eq(StringUtils.isNotEmpty(dto.getCommodityName()), Commodity::getName, dto.getCommodityName())
                .eq(StringUtils.isNotEmpty(dto.getCommoditySort()), Commodity::getSort, dto.getCommoditySort());
        Page page=new Page(dto.getPageNum(),10l);
        Page result = baseMapper.selectPage(page, eq);
        IPage<CommodityPageVo> voResult = WrappersUtils.reverseListVoOfPage(result, CommodityPageVo.class);
        return voResult;
    }
}
