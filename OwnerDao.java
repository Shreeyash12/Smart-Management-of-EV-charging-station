package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.OwnerBean;
import com.connection.DBConnection;

public class OwnerDao {
	
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
    String sql;
    boolean flag = false;

	public boolean InsertEVCreateStationData(OwnerBean b) {
		sql = "insert into create_evstation(ownername,address,area,city,path,mobileno,slot,capacity,status) values(?,?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getOwnername());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getArea());
			ps.setString(4, b.getCity());
			ps.setString(5, b.getPath());
			ps.setString(6, b.getMobileno());
			ps.setString(7, b.getSlot());
			ps.setString(8, b.getCapacity());
			ps.setString(9, b.getStatus());

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

}
