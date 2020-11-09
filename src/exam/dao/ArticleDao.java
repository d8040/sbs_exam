package exam.dao;

import java.util.ArrayList;
import java.util.List;

import exam.dto.Article;
import exam.dto.Board;

public class ArticleDao {

	private List<Board> boards;
	private List<Article> articles;
	private int lastId;
	private int boardLastId;

	public ArticleDao() {

		boards = new ArrayList<>();
		articles = new ArrayList<>();
		lastId = 0;
		boardLastId = 0;
	}

	public int add(int boardId, int memberId, String title, String body) {
		Article article = new Article();
		article.id = lastId + 1;
		article.title = title;
		article.body = body;
		article.memberId = memberId;
		article.boardId = boardId;

		articles.add(article);

		lastId = article.id;

		return article.id;
	}

	public List<Article> getForPrintArticles() {
		return articles;
	}

	public int makeBoard(int memberId, String name) {
		Board board = new Board();
		board.boardId = boardLastId + 1;
		board.name = name;
		
		boards.add(board);

		boardLastId = board.boardId;

		return board.boardId;
	}

	public Board getBoardById(int id) {
		for(Board board : boards) {
			if(board.boardId == id) {
				return board;
			}
		}
		return null;
	}

}
