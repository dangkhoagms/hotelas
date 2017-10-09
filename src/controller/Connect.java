package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private Connection con;
	public Connection getConnect() throws Exception {
		String user = "sa";
		String pass = "123456";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSan";
		con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	
	public void Close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connect ss  = new Connect();
		System.out.println(ss.getConnect());
	}

}
