package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cart {
private Map<Integer,GoodsItem> map = new HashMap<Integer, GoodsItem>();

public Map<Integer, GoodsItem> getMap() {
	return map;
}
public void setMap(Map<Integer, GoodsItem> map) {
	this.map = map;
}
public boolean addDatas(Goods goods) {
	if (map.containsKey(goods.getGoodsId())) {
		map.get(goods.getGoodsId()).setNumber(map.get(goods.getGoodsId()).getNumber()+1);
		return true;
	}
	else {
		map.put(goods.getGoodsId(), new GoodsItem(1, goods));
		return true;
	}
}
public boolean remove(int goodsId) {
	if (!map.containsKey(goodsId)) {
		return false;
	}
	map.remove(goodsId);
	return true;
}
public boolean updateNumber(int goodsId,int number) {
	if (!map.containsKey(goodsId)) {
		return false;
	}
	map.get(goodsId).setNumber(number);
	return true;
}
public double getMoney() {
	double allMoney=0;
	Set<Entry<Integer, GoodsItem>> entrySet = map.entrySet();
	for (Entry<Integer, GoodsItem> entry : entrySet) {
		allMoney+=entry.getValue().getNumber()*entry.getValue().getGoods().getGoodsPrice();
	}
	return allMoney;
}
}
