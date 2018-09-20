package TestHibernate;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.alibaba.Util.HibernateUtil;
import cn.alibaba.entity.Emp;


public class TestInsert {
	//1.测试将数据库插入Emp类
	@Test
	public void insertEmp() {
		//读取配置文件
		Session session = HibernateUtil.getSession();
		//从session中获取事务对象
		Transaction tr = session.beginTransaction();
		Emp emp = new Emp();
		emp.setEname("测试333");	
		emp.setJob("老师");
		emp.setSalary(5000f);
		emp.setHiredate(Date.valueOf("1999-5-20"));
		//执行数据插入操作,传入对象
		session.save(emp);
		//提交事务
		tr.commit();
		session.close();
		System.out.println("数据插入成功！！");
	}
	//2.测试查询表
	@Test
	public void selectEmp() {
		//读取配置文件
		Configuration conf = new Configuration();
		//解析配置文件
		conf.configure("hibernate_cfg.xml");
		//从Session工厂中获取 Session工厂对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//从session中获取事务对象
		Transaction tr = session.beginTransaction();
		//通过主键查询用户信息
		Emp emp = session.get(Emp.class, 1);
		System.out.println(emp);
		tr.commit();
		session.close();
	}
	//3.修改用户信息
	@Test
	public void updateEmp() {
		//读取配置文件
		Configuration conf = new Configuration();
		//解析配置文件
		conf.configure("hibernate_cfg.xml");
		//从Session工厂中获取 Session工厂对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//从session中获取事务对象
		Transaction tr = session.beginTransaction();
		Emp emp = new Emp();
		emp.setEmpno(2);
		emp.setEname("测试22");	
		emp.setJob("老师");
		emp.setSalary(500022f);
		emp.setHiredate(Date.valueOf("2018-5-20"));

		//执行数据插入操作,传入对象
		session.update(emp);
		//提交事务
		tr.commit();
		session.close();
		System.out.println("数据修改成功！！");
	}

	//4.测试查询表
	@Test
	public void deleteEmp() {//都是对对对象进行操作，实际上底层就是通过sql语句对表进行操作
		//读取配置文件
		Configuration conf = new Configuration();
		//解析配置文件
		conf.configure("hibernate_cfg.xml");
		//从Session工厂中获取 Session工厂对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//获取session对象
		Session session = sessionFactory.openSession();
		//从session中获取事务对象
		Transaction tr = session.beginTransaction();
		//通过主键查询用户信息
		Emp emp = new Emp();
		emp.setEmpno(3);
		session.delete(emp);
		System.out.println(emp);
		tr.commit();
		session.close();
		System.out.println("数据删除成功！！");
	}
}
