package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GoodsDaoImp;
import domain.Goods;

public class GoodsService {
	public List<Goods> getGoods() {
		GoodsDaoImp gdi = new GoodsDaoImp();
	
		try {
			return gdi.query(new Goods());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Goods getGoodsId(String goodsId) {
		GoodsDaoImp gdi = new GoodsDaoImp();
		try {
			return gdi.findById(goodsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
