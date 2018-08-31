package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.PlayerRecordDao;
import dbpool.DBConnectionManager;
import entities.Member;
import entities.PlayerAVG;

public class PlayerRecord implements PlayerRecordDao{
	DBConnectionManager db = DBConnectionManager.getInstance();
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Override
	public PlayerAVG playeravgSelectOne(String team) {
		String sql = "select * from playeravg where team = '"+team+"'";
		PlayerAVG data = new PlayerAVG();
		try {
			cn = db.getConnection();
	        ps = (PreparedStatement) cn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        if(rs.next()) {
	        	data.setTeam(rs.getString(1));
	        	data.setName(rs.getString(2));
	        	data.setBatting(rs.getString(3));
	        	data.setHit(rs.getString(4));
	        	data.setHr(rs.getString(5));
	        	data.setWalk(rs.getString(6));
	        	rs.close();
	        }
		} catch (Exception e) {
			System.out.println("db error:"+e.getMessage());
		}
		return data;
	}

	@Override
	public int playeravgInsert(PlayerAVG data) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into playeravg values");
		sb.append(" ('"+data.getTeam()+"','"+data.getName()+"', ");
		sb.append(" '"+data.getBatting()+"','"+data.getHit()+"', ");
		sb.append(" '"+data.getHr()+"','"+data.getWalk()+"') ");
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
	
//	@Override
//	public boolean playeravgConfirm(String team) {
//		String sql = "select email from member where email='"+email+"'";
//		boolean confirmresult = false;
//		try {
//			cn = db.getConnection();
//	        ps = (PreparedStatement) cn.prepareStatement(sql);
//	        rs = ps.executeQuery();
//	       if(rs.next()) {
//	    	 confirmresult = true;  
//	       }
//	       rs.close();
//		} catch (Exception e) {
//			System.out.println("db error:"+e.getMessage());
//		}
//		return confirmresult;
//	}
//
//	@Override
//	public ArrayList<Member> memberSearch(String find) {
//		ArrayList<Member> list = new ArrayList<Member>();
//		StringBuffer sb = new StringBuffer();
//		if(find.equals("")|| find == null) {
//			sb.append("select * from member");
//		}else {
//			sb.append("select * from member ");
//			sb.append("where email like '%"+find+"%'");
//		}
//		try {
//			cn = db.getConnection();
//	        ps = (PreparedStatement) cn.prepareStatement(sb.toString());
//	        rs = ps.executeQuery();
//	        Member data=null;
//	        while(rs.next()) {
//	        	data = new Member();
//	        	data.setEmail(rs.getString("email"));
//	        	data.setPassword(rs.getString("password"));
//	        	data.setName(rs.getString("name"));
//	        	data.setPhone1(rs.getString("phone1"));
//	        	data.setPhone2(rs.getString("phone2"));
//	        	data.setPhone3(rs.getString("phone3"));
//	        	list.add(data);
//	        }
//	        rs.close();
//		} catch (Exception e) {
//			System.out.println("db error:"+e.getMessage());
//		}
//		return list;
//	}
}
