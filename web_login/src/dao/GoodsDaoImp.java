package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import domain.Goods;
import utils.DButils;

public class GoodsDaoImp implements GoodsDao{
	@Override
	public List<Goods> query(Goods goods) throws SQLException {
		return DButils.getQueryRunner().query("select * from goods",new BeanListHandler<>(Goods.class));
	}


	@Override
	public Goods findById(Object goodsId) throws SQLException {
		return DButils.getQueryRunner().query("select*from goods where goodsId=?",new Object[] {goodsId}, new BeanHandler<>(Goods.class));
	}
	
}
