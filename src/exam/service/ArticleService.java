package exam.service;

import java.util.List;

import exam.container.Container;
import exam.dao.ArticleDao;
import exam.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int add(int memberId, String title, String body) {
		return articleDao.add(memberId, title, body);
	}

	public List<Article> getForPrintArticles() {
		return articleDao.getForPrintArticles();
	}


}
