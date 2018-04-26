package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
