package TestHibernate;

import org.hibernate.Session;
import org.junit.Test;

import cn.alibaba.Util.HibernateUtil;
import cn.alibaba.entity.Emp;
//session一级缓存测试类
public class TestLoad {
	@Test
	public void test() {
		//读取配置文件
		Session session = HibernateUtil.getSession();
		//Emp emp1 = session.get(Emp.class, 2);
		//第二条数据从缓存中取出
		//通过主键查询用户信息
		Emp emp = session.load(Emp.class, 2);
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println(emp.getEname());
		session.close();
	}

}
