package TestHibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.alibaba.Util.HibernateUtil;
import cn.alibaba.entity.Emp;
//session一级缓存测试类
public class TestPersistent {
	@Test
	//1.处于一级缓存
	public void test() {
		Session session = HibernateUtil.getSession();
		//从session中获取事务对象
		Transaction tr = session.beginTransaction();
		Emp emp = new Emp();
		emp.setEname("测试6633");	
		emp.setJob("老师");
		emp.setSalary(5000f);
		emp.setHiredate(Date.valueOf("1999-5-20"));
		//执行数据插入操作,传入对象
		session.save(emp);
		//提交事务
		tr.commit();
		System.out.println("数据插入成功！！");
		Emp emp1 = session.get(Emp.class, 5);
	}
	
}
