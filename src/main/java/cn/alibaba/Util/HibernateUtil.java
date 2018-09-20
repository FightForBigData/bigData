package cn.alibaba.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate工具类
 * @author 晨晓芸峰
 * @time 2018年9月7日下午1:32:02
 * @version V1
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory ;
	static {
		//读取配置文件
		Configuration conf = new Configuration();
		//解析配置文件
		conf.configure("hibernate_cfg.xml");
		//从Session工厂中获取 Session工厂对象
		sessionFactory = conf.buildSessionFactory();
	}
	public static Session getSession() {
		//获取session对象
		Session session = sessionFactory.openSession();
		return session;
	}
}
