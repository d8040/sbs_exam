package exam.session;

public class Session {
	public int loginedMemberId;
	
	public boolean isLogined() {
		return loginedMemberId != 0;
	}

	public void logout() {
		loginedMemberId = 0;
	}
}
