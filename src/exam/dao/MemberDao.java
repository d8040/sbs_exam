package exam.dao;

import java.util.ArrayList;
import java.util.List;

import exam.dto.Member;

public class MemberDao {

	private int lastId;
	private List<Member> members;
	
	public MemberDao() {
		lastId = 0;
		members = new ArrayList<Member>();
	}

	public int join(String loginId, String loginPw, String name) {
		Member member = new Member();
		
		member.id = lastId + 1;
		member.loginId = loginId;
		member.loginPw = loginPw;
		member.name = name;
		members.add(member);
		lastId = member.id;

		return member.id;
	}

	public Member getMemberByloginId(String loginId) {
		for(Member member : members) {
			if(member.loginId.equals(loginId)) {
				return member;
			}
		}
		return null;
	}

	public Member getMemberById(int id) {
		for(Member member : members) {
			if (member.id == id) {
				return member;
			}
		}
		return null;
	}

}
