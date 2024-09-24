package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.OwnerBean;
import com.bean.UserBean;
import com.connection.DBConnection;

public class UserDao {
	
	Connection connection=null;
	Boolean resultStatus=Boolean.FALSE;
	PreparedStatement ps;
	ResultSet rs;
    Statement st=null;
    String sql;
    boolean flag = false;

	public boolean InsertUserData(UserBean b) {
		sql = "insert into user(name,address,email,mobileno,dob,password,status) values(?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getMobileno());
			ps.setString(5, b.getDob());
			ps.setString(6, b.getPassword());
			ps.setString(7, b.getStatus());

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

	public UserBean CheckUser(String email, String password) {
		UserBean bean=new UserBean();
		sql = "select * from user where email='" + email + "' and password='" + password + "' ";
		int flag = 0;
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));					
				bean.setAddress(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobileno(rs.getString(5));
				bean.setDob(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setStatus(rs.getString(8));
			
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

	public boolean DeleteUser(int id) {
		String sql="delete from user where id='"+id+"'";
		 Connection con=DBConnection.getConnection();
		 try {
			ps=con.prepareStatement(sql);
			int index =ps.executeUpdate();
			if(index>0)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
			return flag;
	}

	public boolean UpdateUserData(UserBean b) {
		sql = "update user set name = ?,address =?,email= ?,mobileno= ?,dob= ?,password= ? where id = ?";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getMobileno());
			ps.setString(5, b.getDob());
			ps.setString(6, b.getPassword());
			/*ps.setString(7, b.getStatus());*/
			ps.setInt(7, b.getId());
			

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

	public boolean UpdateUserPassword(String oldpass, String newpass) {
    
		sql="update user set password=? where password='"+oldpass+"'";
		
		Connection con = DBConnection.getConnection();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newpass);
			
			int index=ps.executeUpdate();
			
			if(index>0)
			{
				flag=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	public OwnerBean CheckArea(String area) {
		OwnerBean bean=new OwnerBean();
		/*sql="select * from ev_bunk where bunkarea=?";*/
		sql = "select * from create_evstation where area='" + area + "'";
		int flag = 0;
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setOwnername(rs.getString(2));					
				bean.setAddress(rs.getString(3));
				bean.setArea(rs.getString(4));
				bean.setCity(rs.getString(5));
				bean.setPath(rs.getString(6));
				bean.setMobileno(rs.getString(7));
				bean.setSlot(rs.getString(8));
				bean.setCapacity(rs.getString(9));
				bean.setStatus(rs.getString(10));
			
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

	public boolean InsertBookingEVStationData(UserBean b) {
		sql = "insert into bookevstation(name,vehicalname,vehicalno,city,area,time,date,accountname,accountno,ifsc,amount,ownername,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getName());
			ps.setString(2, b.getVehicalname());
			ps.setString(3, b.getVehicalno());
			ps.setString(4, b.getCity());
			ps.setString(5, b.getArea());
			ps.setString(6, b.getTime());
			ps.setString(7, b.getDate());
			ps.setString(8, b.getAccountname());
			ps.setString(9, b.getAccountno());
			ps.setString(10, b.getIfsc());
			ps.setString(11, b.getAmount());
			ps.setString(12, b.getOwnername());
			ps.setString(13, b.getStatus());

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

	public boolean InsertOwnerData(UserBean b) {
		sql = "insert into owner(name,address,email,mobileno,dob,password,bankname,bankaddr,accountno,ifsc,status) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getMobileno());
			ps.setString(5, b.getDob());
			ps.setString(6, b.getPassword());
			ps.setString(7, b.getBankname());
			ps.setString(8, b.getBankaddr());
			ps.setString(9, b.getAccountno());		
			ps.setString(10, b.getIfsc());			
			ps.setString(11, b.getStatus());

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

	public UserBean CheckOwner(String email, String password) {
		UserBean bean=new UserBean();
		sql = "select * from owner where email='" + email + "' and password='" + password + "' ";
		int flag = 0;
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				flag = 1;
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));					
				bean.setAddress(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobileno(rs.getString(5));
				bean.setDob(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setBankname(rs.getString(8));
				bean.setBankaddr(rs.getString(9));
				bean.setAccountno(rs.getString(10));
				bean.setIfsc(rs.getString(11));
				bean.setStatus(rs.getString(12));
			
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(flag ==1)
			return bean;
		else 
			return null;
	}

	public boolean AddFeedbackData(UserBean b) {
		sql = "insert into feedback(name,feedback) values(?,?)";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, b.getName());
			ps.setString(2, b.getFeedback());

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
	


