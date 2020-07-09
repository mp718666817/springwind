package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategroyDao;
import cn.itcast.travel.dao.Impl.CategroyDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategroyService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategroyServiceImpl implements CategroyService {
    CategroyDao dao = new CategroyDaoImpl();
    List<Category> list = null;

    @Override
    public List<Category> findCaAll() {
        System.out.println("执行findCaAll");
        Jedis jedis = JedisUtil.getJedis();
        //Set<String> categroys = jedis.zrange("categroy", 0, -1);
        Set<Tuple> categroys = jedis.zrangeByScoreWithScores("categroy", 0, -1);
        if ((categroys.size()==0)||categroys==null){
            list = dao.findAll();
            for(int i = 0;i<list.size();i++){
                jedis.zadd("categroy",list.get(i).getCid(),list.get(i).getCname());
            }
        }
        else {
            list = new ArrayList<Category>();
            for (Tuple tuple : categroys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                list.add(category);
            }
        }
        return  list;
    }
}
