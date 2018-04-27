package cn.e3mall.controller;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HsY
 * @create 2018-04-21 23:03
 * @desc 订单项处理器
 **/
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {

        TbItem tbItem = itemService.getItemById(itemId);

        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public DataGridResult getItemList(int page, int rows) {

        DataGridResult itemList = itemService.getItemList(page, rows);
        return itemList;
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public E3Result addItem(TbItem tbItem,String desc){
        E3Result e3Result = itemService.addItem(tbItem, desc);

        return e3Result;

    }

}
