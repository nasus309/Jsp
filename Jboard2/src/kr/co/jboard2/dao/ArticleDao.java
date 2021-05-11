package kr.co.jboard2.dao;

public class ArticleDao {
	
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {};
	
	private static ArticleDao getInstance() {
		return instance;
	}
	
	
	public void insertArticle() throws Exception {}
	public void selectArticle() throws Exception  {}
	public void selectArticles() throws Exception  {}
	public void updateArticle() throws Exception  {}
	public void deleteArticle() throws Exception  {}
}
