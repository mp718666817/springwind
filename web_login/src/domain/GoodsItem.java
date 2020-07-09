package domain;

public class GoodsItem {
	private int number;
	private Goods goods;
	public GoodsItem(int number, Goods goods) {
		super();
		this.number = number;
		this.goods = goods;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
