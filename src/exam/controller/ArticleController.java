package exam.controller;

import java.util.List;

import exam.container.Container;
import exam.dto.Article;
import exam.dto.Member;
import exam.service.ArticleService;
import exam.service.MemberService;

public class ArticleController extends Controller{

	private ArticleService articleService;
	private MemberService memberService;

	public ArticleController() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void run(String cmd) {
		if (cmd.equals("article add")) {
			add(cmd);
		} else if (cmd.equals("article list")) {
			list(cmd);
		}

	}

	private void list(String cmd) {
		System.out.println("== 게시물 리스트 ==");
		List<Article> articles = articleService.getForPrintArticles();

		System.out.println("번호 / 작성자 / 제목");

		for (Article article : articles) {
			Member member = memberService.getMemberById(article.memberId);
			System.out.printf("%d / %s / %s\n", article.id, member.name, article.title);
		}
	}

	private void add(String cmd) {
		System.out.println("== 게시물 등록 ==");
		
		if(Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}

		String title;
		String body;

		System.out.printf("제목: ");
		title = Container.sc.nextLine().trim();

		System.out.printf("내용: ");
		body = Container.sc.nextLine().trim();

		int id = articleService.add(Container.session.loginedMemberId, title, body);
		System.out.println(id + "번 게시물이 생성되었습니다.");
	}

}
