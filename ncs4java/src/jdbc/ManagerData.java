package jdbc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ManagerData {
	MemberDTO dto=new MemberDTO();
	MemberDAO dao=new MemberDAO();
	public void inputData() throws NumberFormatException, IOException {
		System.out.println("회원가입페이지");
		System.out.println("id:");
		dto.setId(Integer.parseInt(Menu.in.readLine()));
		System.out.println("name:");
		dto.setName(Menu.in.readLine());
		System.out.println("password:");
		dto.setPass(Menu.in.readLine());
		System.out.println("mail:");
		dto.setEmail(Menu.in.readLine());
		int res=dao.registerMember(dto);
		if(res==1)
			System.out.println("success");
		else
			System.out.println("fail");
	}
	public void writeAll() {
		ArrayList<MemberDTO> list=dao.getAllList();
		Iterator<MemberDTO> it=list.iterator();
		while(it.hasNext()) {
			MemberDTO dto=it.next();
			String str=it.toString();
			System.out.println(str);
		}
		
	}
}
