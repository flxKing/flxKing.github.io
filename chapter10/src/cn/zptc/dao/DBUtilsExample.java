package cn.zptc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import cn.zptc.bean.User;
import cn.zptc.example.Example;

public class DBUtilsExample {
    public boolean findAll() throws SQLException{
		QueryRunner runner = new QueryRunner(Example.getDataSource());
		String sql = "delete from users where id=19";
		int i = runner.update(sql);
		if (i==1) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
