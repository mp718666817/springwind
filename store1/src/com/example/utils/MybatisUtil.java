package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis会话工具类
 * @author runmu
 */
public class MybatisUtil {
    private static SqlSessionFactory sessionFactory = getSessionFactory();

    /**
     * 获取会话工厂
     * @return
     */
    public static SqlSessionFactory getSessionFactory(){
        if(null == sessionFactory){
            //Ctrl+Alt+T  -- 弹出为选中的代码段添加各种"块操作"
            try {
                //Ctrl+Alt+V-- 重构提炼出某方法的返回值为一个局部变量
                sessionFactory = new SqlSessionFactoryBuilder()
                        // Ctrl+p快捷键弹出方法参数表提示
                        .build(Resources.getResourceAsReader("sqlMapConfig.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }
}













