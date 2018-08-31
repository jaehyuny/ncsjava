package dao;

import java.util.ArrayList;

import entities.Member;

public interface MemberDao {
	Member memberSelectOne(String email);
	int memberInsert(Member data);
	boolean memberConfirm(String email);
	ArrayList<Member> memberSearch(String find);
}
