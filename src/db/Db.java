package db;

import java.sql.*;
import java.util.Iterator;
public class Db {
	String _IP="localhost",_PORT="3306",_USER="root",_PASSWORD="",_DB="",_SQL="";
	Connection cn =null;
	PreparedStatement ps=null;
	
	public Db(String db) {
		this._DB=db;
		getConnection();
	}



	public void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",_IP,_PORT,_DB), _USER,_PASSWORD);
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void Sentencia(String sql) {
		this._SQL=sql;
		if(cn==null)return; 
		try {
			ps= cn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] getRegistro() {
		if(cn==null || ps == null) return null;
		try {
			ResultSet rs = ps.executeQuery();
			String[] aRegistro = new String[rs.getMetaData().getColumnCount()];
			for (int i = 0; i < aRegistro.length; i++) {
				aRegistro[i]=rs.getString(i+1);
				
				return aRegistro;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
