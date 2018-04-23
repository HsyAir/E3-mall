package cn.e3mall.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author HsY
 * @create 2018-04-23 16:25
 * @desc 分页数据表格展示
 **/
public class DataGridResult implements Serializable{
    private Integer total;
    private List<?> rows;

    public DataGridResult() {
    }

    public DataGridResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
