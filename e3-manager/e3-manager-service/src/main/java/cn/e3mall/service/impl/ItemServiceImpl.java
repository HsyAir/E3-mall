package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author HsY
 * @create 2018-04-22 0:31
 * @desc
 **/
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItem getItemById(long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult getItemList(int page, int rows) {
//        1）设置分页条件
        PageHelper.startPage(page, rows);
//        2）执行查询
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItemList = tbItemMapper.selectByExample(tbItemExample);
//        3）取总记录数
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
        long total = pageInfo.getTotal();
//        4）创建一个DataGridResult对象
        DataGridResult dataGridResult = new DataGridResult();
//        5）设置属性
        dataGridResult.setTotal((int) total);
        dataGridResult.setRows(tbItemList);
//        6）返回结果

        return dataGridResult;
    }

    @Override
    public E3Result addItem(TbItem tbItem, String desc) {
//        1）生成商品id
        long itemId = IDUtils.genItemId();
//        2）补全item对象的属性
        tbItem.setCid(itemId);
        //1-正常，2-下架，3-删除
        tbItem.setStatus((byte)1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
//        3）向商品表出入数据
        tbItemMapper.insert(tbItem);
//        4）创建一个tb_item_desc表对应的pojo对象
        TbItemDesc tbItemDesc = new TbItemDesc();
//        5）把pojo对象的属性补全
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
//        6）向商品描述表插入数据
        tbItemDescMapper.insert(tbItemDesc);

//        7）返回成功
        return E3Result.ok();
    }

}
