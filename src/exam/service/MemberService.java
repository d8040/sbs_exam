package exam.service;

import exam.dao.MemberDao;
import exam.dto.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		memberDao = new MemberDao();
	}

	public int join(String loginId, String loginPw, String name) {
		return memberDao.join(loginId, loginPw, name);
	}

	public Member getMemberByloginId(String loginId) {
		return memberDao.getMemberByloginId(loginId);
	}

	public boolean isJoinableLoginId(String loginId) {
		Member member = memberDao.getMemberByloginId(loginId);
		if (member != null) {
			return false;
		}
		return true;
	}

	public Member getMemberById(int id) {
		return memberDao.getMemberById(id);
	}

}
