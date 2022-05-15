package com.tutorial.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class inqRepository {
	
	
	Connection con = null;
	
	public inqRepository() {
		String url = "jdbc:mysql://localhost:3306/eg";
		String username = "root";
		String password = "";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<inq> getInqs(){
		
		List<inq> inqieries = new ArrayList<>();
		String sql = "select * from inquiry";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				inq i = new inq();
				i.setId(rs.getInt(1));
				i.setUserId(rs.getInt(2));
				i.setType(rs.getString(3));
				i.setReason(rs.getString(4));
				
				inqieries.add(i);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return inqieries;
	}
	
	public inq getInq(int id) {
		
		String sql = "select * from inquiry where id="+id;
		inq i = new inq();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				i.setId(rs.getInt(1));
				i.setUserId(rs.getInt(2));
				i.setType(rs.getString(3));
				i.setReason(rs.getString(4));	
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public void create(inq i1) {
		String sql = "insert into inquiry values (?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, i1.getId());
			st.setInt(2, i1.getUserId());
			st.setString(3, i1.getType());
			st.setString(4, i1.getReason());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public void update(inq i1) {
		String sql = "update inquiry set type=?, reason=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, i1.getType());
			st.setString(2, i1.getReason());
			st.executeUpdate();
			System.out.println("Updated Successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void delete(int id) {
		
		String sql = "delete from inquiry where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
	
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
