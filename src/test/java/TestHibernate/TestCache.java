package TestHibernate;

import org.hibernate.Session;
import org.junit.Test;

import cn.alibaba.Util.HibernateUtil;
import cn.alibaba.entity.Emp;
//session一级缓存测试类
public class TestCache {
	@Test
	public void test() {
		//读取配置文件
		Session session = HibernateUtil.getSession();
		Emp emp1 = session.get(Emp.class, 2);
		//第二条数据从缓存中取出
		//通过主键查询用户信息
		Emp emp2 = session.get(Emp.class, 2);
		session.close();
	}
	@Test
	public void test1() {
		//读取配置文件
		Session session = HibernateUtil.getSession();
		Session session1 = HibernateUtil.getSession();
		Emp emp1 = session.get(Emp.class, 2);
		//session1 为独享的 这里的查询是从数据库中单独查询。
		Emp emp2 = session1.get(Emp.class, 2);
		session.close();
		session1.close();
	}
	@Test
	public void test3() {
		//读取配置文件
		Session session = HibernateUtil.getSession();
		Emp emp1 = session.get(Emp.class, 2);
		session.evict(emp1);//清楚一级缓存
		//session1 为独享的 这里的查询是从数据库中单独查询。
		Emp emp2 = session.get(Emp.class, 2);
		session.close();
	}
}
