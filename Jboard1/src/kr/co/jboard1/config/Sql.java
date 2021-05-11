package kr.co.jboard1.config;

public class Sql {
	
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM `JBOARD_ARTICLE` WHERE `parent`=0;";
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `JBOARD_ARTICLE` WHERE `parent`=0;";
	
	public static final String SELECT_ARTICLE  = "SELECT * FROM `JBOARD_ARTICLE` AS a "
												+ "LEFT JOIN `JBOARD_FILE` AS b "
												+ "ON a.seq = b.parent "
												+ "WHERE a.seq=?;";
	
	public static final String SELECT_ARTICLES  = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=0 "
												+ "ORDER BY `seq` DESC "
												+ "LIMIT ?, 10;"; // LIMIT : (index,개수) index부터 몇개?
	
	public static final String SELECT_COMMENTS = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=? "
												+ "ORDER BY `seq` ASC;";
	
	
	
	
	public static final String INSERT_ARTICLE = "INSERT INTO `JBOARD_ARTICLE` SET "
												+ "`title`=?, "
												+ "`content`=?, "
												+ "`uid`=?, "
												+ "`regip`=?, "
												+ "`rdate`=NOW();";
	
	public static final String INSERT_COMMENT = "INSERT INTO `JBOARD_ARTICLE` SET "
												+ "`parent`=?,"
												+ "`content`=?,"
												+ "`uid`=?,"
												+ "`regip`=?,"
												+ "`rdate`=NOW();";
										
										
	public static final String UPDATE_ARTICLE_HIT = "UPDATE `JBOARD_ARTICLE` SET `hit` = `hit` + 1 WHERE `seq` = ?;";

	public static final String UPDATE_ARTICLE_COMMENT_INC = "UPDATE `JBOARD_ARTICLE` SET `comment` = `comment` + 1 WHERE `seq` = ?";
	public static final String UPDATE_ARTICLE_COMMENT_DEC = "UPDATE `JBOARD_ARTICLE` SET `comment` = `comment` - 1 WHERE `seq` = ?";
	
	public static final String DELETE_COMMENT = "DELETE FROM `JBOARD_ARTICLE` WHERE `seq`= ?;";
	public static final String DELETE_ARTICLE = "DELETE FROM `JBOARD_ARTICLE` WHERE `seq`= ?;";
}
