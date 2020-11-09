package exam.service;

import java.util.List;

import exam.container.Container;
import exam.dao.ArticleDao;
import exam.dto.Article;
import exam.dto.Board;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int add(int boardId, int memberId,  String title, String body) {
		return articleDao.add(boardId, memberId, title, body);
	}

	public List<Article> getForPrintArticles() {
		return articleDao.getForPrintArticles();
	}

	public int makeBoard(int memberId, String board) {
		return articleDao.makeBoard(memberId, board);
	}

	public Board getBoardById(int id) {
		return articleDao.getBoardById(id);
	}


}
