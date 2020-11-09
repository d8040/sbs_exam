package exam.controller;

import java.util.List;

import exam.container.Container;
import exam.dto.Article;
import exam.dto.Board;
import exam.dto.Member;
import exam.service.ArticleService;
import exam.service.MemberService;

public class ArticleController extends Controller {

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
		} else if (cmd.equals("article makeBoard")) {
			makeBoard(cmd);
		} else if (cmd.startsWith("article selectBoard")) {
			selectBoard(cmd);
		}

	}

	private void selectBoard(String cmd) {
		System.out.println("== 게시판 이동 ==");
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}

		int inputId = Integer.parseInt(cmd.split(" ")[2]);

		Board board = articleService.getBoardById(inputId);

		if (board == null) {
			System.out.println("게시판이 존재하지 않습니다.");
			return;
		}
		Container.session.selectedBoardId = board.boardId;

		System.out.printf("%s 게시판으로 이동되었습니다.\n", board.name);
	}

	private void makeBoard(String cmd) {
		System.out.println("== 게시판 생성 ==");
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}

		System.out.printf("게시판 이름: ");
		String name = Container.sc.nextLine();

		int boardId = articleService.makeBoard(Container.session.loginedMemberId, name);
		System.out.printf("%s(%d번) 게시판이 생성되었습니다.\n", name, boardId);
	}

	private void list(String cmd) {
		int boardId = Container.session.selectedBoardId;
		List<Article> articles = articleService.getForPrintArticles(boardId);
		Board board = articleService.getBoardById();
		System.out.printf("== %s 게시판 리스트 ==\n", board.name);
		System.out.println("게시판 / 번호 / 작성자 / 제목");

		for (Article article : articles) {
			if (Container.session.selectedBoardId == article.boardId) {
				Member member = memberService.getMemberById(article.memberId);
				System.out.printf("%s, %d / %s / %s\n", board.name, article.id, member.name, article.title);
			}
		}
	}

	private void add(String cmd) {
		System.out.println("== 게시물 등록 ==");

		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해 주세요.");
			return;
		}

		String title;
		String body;

		System.out.printf("제목: ");
		title = Container.sc.nextLine().trim();

		System.out.printf("내용: ");
		body = Container.sc.nextLine().trim();

		int id = articleService.add(Container.session.selectedBoardId, Container.session.loginedMemberId, title, body);
		System.out.println(id + "번 게시물이 생성되었습니다.");
	}

}
