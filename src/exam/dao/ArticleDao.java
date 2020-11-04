package exam.dao;

import java.util.ArrayList;
import java.util.List;

import exam.dto.Article;

public class ArticleDao {

	private List<Article> articles;
	private int lastId;

	public ArticleDao() {
		articles = new ArrayList<>();
		lastId = 0;

		makeTestData();
	}

	private void makeTestData() {
		for(int i = 0; i < 10 ; i++) {
			add(1, "제목"+i, "내용"+i);
		}
	}

	public int add(int memberId, String title, String body) {
		Article article = new Article();
		article.id = lastId + 1;
		article.title = title;
		article.body = body;
		article.memberId = memberId;

		articles.add(article);
		
		lastId = article.id;

		return article.id;
	}

	public List<Article> getForPrintArticles() {
		return articles;
	}

}
