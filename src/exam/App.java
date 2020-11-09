package exam;

import exam.container.Container;
import exam.controller.ArticleController;
import exam.controller.Controller;
import exam.controller.MemberController;
import exam.service.ArticleService;
import exam.service.MemberService;

public class App {

	private MemberController memberController;
	private ArticleController articleController;

	public App() {
		memberController = new MemberController();
		articleController = new ArticleController();
		
		testData();
	}

	private void testData() {
		MemberService memberService = Container.memberService;
		ArticleService articleService = Container.articleService;
		
		//회원 2명 생성
		int firstMemberId = memberService.join("aaa", "aaa", "aaa");
		int secondMemberId = memberService.join("bbb", "bbb", "bbb");
		
		//공지사항 게시판 생성
		int noticeBoardId = articleService.makeBoard(1, "공지사항");
		int freeBoardId = articleService.makeBoard(1, "자유");
		
		// 1번 회원이 공지사항 게시물 5개 작성
		for(int i = 1; i<= 5; i++) {
			articleService.add(noticeBoardId, firstMemberId, "제목"+i, "내용" + i);
		}
		for(int i = 6; i<= 10; i++) {
			articleService.add(freeBoardId, secondMemberId, "제목"+i, "내용" + i);
		}
	}

	public void run() {
		while (true) {
			System.out.printf("명령어) ");
			String cmd = Container.sc.nextLine();

			if (cmd.equals("exit")) {
				System.out.println("== 시스템종료 ==");
				break;
			}
			Controller controller = getControllerByCmd(cmd);
			controller.run(cmd);
		}
	}

	public Controller getControllerByCmd(String cmd) {
		if (cmd.startsWith("member ")) {
			return memberController;
		} 
		
		else if (cmd.startsWith("article ")) {
			return articleController;
		}
		return null;
	}
}