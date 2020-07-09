package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Goods;

public interface GoodsDao {
	List<Goods> query(Goods goods) throws SQLException;
	Goods findById(Object goodsId)throws SQLException;
}
