package cn.e3mall.controller;

import cn.e3mall.common.pojo.DataTreeNode;
import cn.e3mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author HsY
 * @create 2018-04-24 17:02
 * @desc ItemCat处理器
 **/
@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<DataTreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentId){

        List<DataTreeNode> itemCatList = itemCatService.getItemCatList(parentId);
        return itemCatList;
    }

}
