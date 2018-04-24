package cn.e3mall.service;

import cn.e3mall.common.pojo.DataTreeNode;

import java.util.List;

/**
 * @author HsY
 * @create 2018-04-24 16:47
 * @desc ItemCat接口
 **/
public interface ItemCatService {
    List<DataTreeNode> getItemCatList(long parentId);
}
