package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.Impl.UserDaoImpl;
import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public boolean regist(User user) {
        User u = dao.findByUserName(user.getUsername());
        if (u!=null) {
            return false;
        }
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        new UserDaoImpl().save(user);
        String content = "<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>黑马旅游网激活</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = dao.findByCode(code);
        if (user!=null){
            dao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        User u = dao.findByUserNameAndPwd(user.getUsername(),user.getPassword());
        return u;
    }

}
