package cn.e3mall.pagehelper;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author HsY
 * @create 2018-04-23 17:15
 * @desc 分页测试
 **/
public class PageHelperTest {

    @Test
    public void testPageHelper(){
        // 设置分页
        PageHelper.startPage(1,10);
        //执行查询
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //从容器中获得代理对象
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        //执行查询
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItemList = tbItemMapper.selectByExample(tbItemExample);
        System.out.println(tbItemList.size());
        //去分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemList);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());

    }
}
