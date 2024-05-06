package com.yongyuan.order.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.yongyuan.order.Do.CommodityInsertDto;
import com.yongyuan.order.Do.CommodityPageVo;
import com.yongyuan.order.Do.IdsDto;
import com.yongyuan.order.Do.SearchDto;
import com.yongyuan.order.common.Result;
import com.yongyuan.order.entity.Commodity;
import com.yongyuan.order.entity.Commoditysort;
import com.yongyuan.order.service.ICommodityService;
import com.yongyuan.order.service.ICommoditysortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


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
        List<Commoditysort> sortList = commoditysortService.list();
        model.addAttribute("commodityList",result.getRecords());
        model.addAttribute("commoditySortList",sortList);
        return "page1";
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
        return "page1::commodityTable";
    }

    @ResponseBody
    @PostMapping("/remove")
    public Result<Boolean> remove (@RequestBody IdsDto dto){
        boolean achieve = commodityService.removeBatchByIds(dto.getIds());
        return Result.success(achieve);
    }




}

