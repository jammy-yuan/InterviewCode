package cn.yueqian.utils;

import java.io.FileInputStream;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtils {
	public static DataSource getDataSource() {
		Properties p=new Properties();
		FileInputStream in;
		DataSource ds=null;		
		try {
			String path = DruidUtils.class.getResource("/").toURI().getPath() + "db.properties"; 
			in=new FileInputStream(path);
			p.load(in);
			ds=DruidDataSourceFactory.createDataSource(p);
			ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

}
