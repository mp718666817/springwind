package utils;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DButils {
	private static ComboPooledDataSource ps = new ComboPooledDataSource();
	public static QueryRunner getQueryRunner() {
		QueryRunner qr = new QueryRunner(ps);
		return qr;
	}
}
