package service;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GoodsDao;
import dao.GoodsDaoImp;
import dao.UserDaoImp;
import domain.Cart;
import domain.GoodsItem;
import domain.User;
import exception.UserServiceException;

public class UserService {
	public boolean login(User u) throws UserServiceException 
	{
		UserDaoImp userDao = new UserDaoImp();
		try {
			User user = userDao.FindByNameAndPwd(u);
			if (user!=null) {
				return true;
			}
			else {
				throw new UserServiceException("登录失败账号密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserServiceException("系统故障");
		} 	
	}
	public boolean insert(User u) throws UserServiceException 
	{
		UserDaoImp daoImp = new UserDaoImp();
		try {
			boolean update = daoImp.Update(u);
			if (update) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean buyGoods(HttpSession session, String goodsId) {
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart==null) {
			cart = new Cart();
		}
		GoodsDao dao = new GoodsDaoImp();
		try {
			cart.addDatas(dao.findById(goodsId));
			session.setAttribute("cart", cart);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
