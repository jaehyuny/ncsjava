package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.MemberDao;
import dbpool.DBConnectionManager;
import entities.Member;

public class MemberDaoService implements MemberDao{
	DBConnectionManager db = DBConnectionManager.getInstance();
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
	@Override
	public Member memberSelectOne(String email) {
		String sql = "select * from member where email = '"+email+"'";
		Member data = new Member();
		try {
			cn = db.getConnection();
	        ps = (PreparedStatement) cn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	        	data.setEmail(rs.getString(1));
	        	data.setName(rs.getString(2));
	        	data.setPhone1(rs.getString(3));
	        	data.setPhone2(rs.getString(4));
	        	data.setPhone3(rs.getString(5));
	        	data.setBirthday(rs.getString(6));
	        	data.setGender(rs.getString(7));
	        	data.setPostno(rs.getString(8));
	        	data.setAddr1(rs.getString(9));
	        	data.setAddr2(rs.getString(10));
	        	data.setPhoto(rs.getString(11));
	        	data.setMemlevel(rs.getInt(12));
	        	data.setInputdate(rs.getString(13));
	        	data.setPassword(rs.getString(14));
	        	rs.close();
	        }
		} catch (Exception e) {
			System.out.println("db error:"+e.getMessage());
		}
		return data;
	}

	@Override
	public int memberInsert(Member data) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into member(email, name, password, phone1, phone2, phone3)values");
		sb.append(" ('"+data.getEmail()+"','"+data.getName()+"', ");
		sb.append(" '"+data.getPassword()+"','"+data.getPhone1()+"', ");
		sb.append(" '"+data.getPhone2()+"','"+data.getPhone3()+"') ");
		int saveresult = 0;
		try {
			cn = db.getConnection();
	        ps = (PreparedStatement) cn.prepareStatement(sb.toString());
	        saveresult = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return saveresult;
	}
	
	@Override
	public boolean memberConfirm(String email) {
		String sql = "select email from member where email='"+email+"'";
		boolean confirmresult = false;
		try {
			cn = db.getConnection();
	        ps = (PreparedStatement) cn.prepareStatement(sql);
	        rs = ps.executeQuery();
	       if(rs.next()) {
	    	 confirmresult = true;  
	       }
	       rs.close();
		} catch (Exception e) {
			System.out.println("db error:"+e.getMessage());
		}
		return confirmresult;
	}

	@Override
	public ArrayList<Member> memberSearch(String find) {
		ArrayList<Member> list = new ArrayList<Member>();
		StringBuffer sb = new StringBuffer();
		if(find.equals("")|| find == null) {
			sb.append("select * from member");
		}else {
			sb.append("select * from member ");
			sb.append("where email like '%"+find+"%'");
		}
		try {
			cn = db.getConnection();
	        ps = (PreparedStatement) cn.prepareStatement(sb.toString());
	        rs = ps.executeQuery();
	        Member data=null;
	        while(rs.next()) {
	        	data = new Member();
	        	data.setEmail(rs.getString("email"));
	        	data.setPassword(rs.getString("password"));
	        	data.setName(rs.getString("name"));
	        	data.setPhone1(rs.getString("phone1"));
	        	data.setPhone2(rs.getString("phone2"));
	        	data.setPhone3(rs.getString("phone3"));
	        	list.add(data);
	        }
	        rs.close();
		} catch (Exception e) {
			System.out.println("db error:"+e.getMessage());
		}
		return list;
	}

}
