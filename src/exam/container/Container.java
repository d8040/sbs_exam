package exam.container;

import java.util.Scanner;

import exam.dao.ArticleDao;
import exam.service.ArticleService;
import exam.service.MemberService;
import exam.session.Session;

public class Container {

	public static Scanner sc;
	public static Session session;
	public static ArticleDao articleDao;
	public static ArticleService articleService;
	public static MemberService memberService;

	static {
		sc = new Scanner(System.in);
		session = new Session();
		articleDao = new ArticleDao();
		articleService = new ArticleService();
		memberService = new MemberService();
	}

}
