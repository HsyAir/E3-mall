package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.DataTreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HsY
 * @create 2018-04-24 16:49
 * @desc
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<DataTreeNode> getItemCatList(long parentId) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();

        Criteria criteria = tbItemCatExample.createCriteria();

        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> tbItemCatList = tbItemCatMapper.selectByExample(tbItemCatExample);

        List<DataTreeNode> list = new ArrayList<>();

        for (TbItemCat tbItemCat:tbItemCatList) {
            DataTreeNode dataTreeNode = new DataTreeNode();

            dataTreeNode.setId(tbItemCat.getId());
            dataTreeNode.setText(tbItemCat.getName());
            dataTreeNode.setState(tbItemCat.getIsParent()?"closed":"open");

            list.add(dataTreeNode);
        }

        return list;
    }
}
