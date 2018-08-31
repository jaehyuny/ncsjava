package jdbc;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO extends MemberDTO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;
	public int registerMember(MemberDTO dto) {
		return 0;
	}
	public ArrayList<MemberDTO> getAllList() {
		String sql="select * from member2";
		ArrayList<MemberDTO> list=new ArrayList<MemberDTO>();
		MemberDTO dto=null;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto=new MemberDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setEmail(rs.getString("email"));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
