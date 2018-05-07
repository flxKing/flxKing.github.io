package cn.zptc.example;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.zptc.bean.User;
import cn.zptc.dao.DBUtilsExample;

public class Example {

	public static DataSource ds = null;
	
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource("zptc");
		ds = cpds;
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static void main(String[] args) throws SQLException{
		System.out.println(ds.getConnection());
		DBUtilsExample dbe = new DBUtilsExample();
		boolean list = dbe.findAll();
	    if (list) {
	    	System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
			
	
	}
}
