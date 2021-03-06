package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;

/**
 * @author HsY
 * @create 2018-04-22 0:26
 * @desc 商品信息service层接口
 **/
public interface ItemService {
    TbItem getItemById(long id);

    DataGridResult getItemList(int page,int rows);

    E3Result addItem(TbItem tbItem,String desc);
}
