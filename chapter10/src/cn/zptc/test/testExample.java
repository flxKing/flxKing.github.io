package cn.zptc.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.zptc.bean.User;
import cn.zptc.dao.DBUtilsExample;


public class testExample {

	@Test
	public void test() throws SQLException {
		DBUtilsExample dbe = new DBUtilsExample();
		boolean list = dbe.findAll();
		
			System.out.println(list);
		
	}
	
	
}
