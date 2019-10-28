package com.liu.cartDemo;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GoodsDao {
    private JdbcTemplate jt=new JdbcTemplate(JDBCUtils.getDataSource());
    public List<Goods> goodsList(){
        String sql="select * from goods";
        List<Goods> goods = jt.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class));
        return goods;
    }
    public Goods oneGoods(Integer pid){
        String sql="select * from goods where pid=?";
        Goods goods = jt.queryForObject(sql, new BeanPropertyRowMapper<>(Goods.class),pid);
        return goods;
    }
}
