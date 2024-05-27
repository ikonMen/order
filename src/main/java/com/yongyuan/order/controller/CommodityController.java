package com.yongyuan.order.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.yongyuan.order.Do.*;
import com.yongyuan.order.common.Result;
import com.yongyuan.order.entity.Commodity;
import com.yongyuan.order.entity.CommoditySort;
import com.yongyuan.order.service.ICommodityService;
import com.yongyuan.order.service.ICommoditysortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fengsheming
 * @since 2024-04-23
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private ICommodityService  commodityService;
    @Resource
    private ICommoditysortService commoditysortService;

    @GetMapping("/page")
    public String page(Model model){
        Page result = commodityService.page(new Page(1l, 10l));
        List<CommoditySort> sortList = commoditysortService.list();
        model.addAttribute("commodityList",result.getRecords());
        model.addAttribute("commoditySortList",sortList);
        return "CommodityPage";
    }

    @ResponseBody
    @PostMapping("/add")
    public  boolean add(CommodityInsertDto commodityInsertDto){
        Commodity commodity = BeanUtil.copyProperties(commodityInsertDto, Commodity.class);
        return commodityService.saveOrUpdate(commodity);
    }


    @PostMapping("/search")
    public  String  search (SearchDto dto, Model model){
        IPage<CommodityPageVo> result = commodityService.searchCommodity(dto);
        model.addAttribute("commodityList",result.getRecords());
        return "CommodityPage::commodityTable";
    }

    @ResponseBody
    @PostMapping("/remove")
    public Result<Boolean> remove (@RequestBody IdsDto dto){
        boolean achieve = commodityService.removeBatchByIds(dto.getIds());
        return Result.success(achieve);
    }


    @ResponseBody
    @PostMapping("/changeSort")
    public  Result<Boolean> changeSort (@RequestBody ChangeSortDto dto){
        boolean achieve = commoditysortService.removeBatchByIds(dto.getRemoveIds());
        List<CommoditySort> sorts = dto.getInsertSortNames().stream().map(CommoditySort::new).collect(Collectors.toList());
        achieve = commoditysortService.saveBatch(sorts);
        return Result.success(achieve);
    }






}

