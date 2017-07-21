package dao;

import java.sql.*;


public class DBoperator {
   private Connection conn; 
      private  Statement stmt ;
   
   public DBoperator(){
	   String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/vj?useUnicode=true&characterEncoding=utf-8&useSSL=true";
	   String user = "root";
	   String password = "1234";
	   
	   try {
		Class.forName(driver);
		setConn(DriverManager.getConnection(url, user, password));
		stmt=conn.createStatement();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   }

public Connection getConn() {
	return conn;
}

public void setConn(Connection conn) {
	this.conn = conn;
}
	
public ResultSet Statementexcute(String sql){
	ResultSet rs= null;
	try {
		
		
		rs = stmt.executeQuery(sql);
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rs;
	
}

public ResultSet PreparedStatementexcute(String sql,String ...vars){
	ResultSet rs= null;
	try {
		
		PreparedStatement pstmt =conn.prepareStatement(sql);
		for(int i=0;i<vars.length;i++){
			pstmt.setString(i+1, vars[i]);
		}
		
		rs = pstmt.executeQuery();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rs;
	
}

public int executeupdate(String sql,String ...vars){
	int rs =0;
	try {
		
		PreparedStatement pstmt =conn.prepareStatement(sql);
		for(int i=0;i<vars.length;i++){
			pstmt.setString(i+1, vars[i]);
		}
		
		rs = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return rs;
	
}


}
