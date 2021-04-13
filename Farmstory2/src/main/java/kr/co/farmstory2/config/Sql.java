package kr.co.farmstory2.config;

public class Sql {
	
	public static final String SELECT_COUNT_USER = "SELECT COUNT(`uid`) FROM `JBOARD_USER` WHERE `uid`=?;";
	
	public static final String SELECT_TERMS = "SELECT * FROM `JBOARD_TERMS`;";

	public static final String SELECT_USER  = "SELECT * FROM `JBOARD_USER` WHERE `uid`=? AND `pass`=PASSWORD(?);";
	public static final String INSERT_USER ="INSERT INTO `JBOARD_USER` SET "
											   +"`uid`=?,"
											   + "`pass`=PASSWORD(?),"
											   + "`name`=?,"
											   + "`nick`=?,"
											   + "`email`=?,"
											   + "`hp`=?,"
											   + "`zip`=?,"
											   + "`addr1`=?,"
											   + "`addr2`=?,"
											   + "`regip`=?,"
											   + "`rdate`=NOW();";
	
		
	public static final String SELECT_ARTICLE_LATEST = "(SELECT * FROM `JBOARD_ARTICLE` WHERE `cate`='grow' ORDER BY `seq` DESC LIMIT 5) UNION "
													 + "(SELECT * FROM `JBOARD_ARTICLE` WHERE `cate`='school' ORDER BY `seq` DESC LIMIT 5) UNION "
													 + "(SELECT * FROM `JBOARD_ARTICLE` WHERE `cate`='story' ORDER BY `seq` DESC LIMIT 5);";
	
	
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM `JBOARD_ARTICLE` WHERE `parent`=0;"; 
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `JBOARD_ARTICLE` WHERE `parent`=0;";
	
	//public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` AS a "
												+ "LEFT JOIN `JBOARD_FILE` AS b "
												+ "ON a.seq = b.parent "
												+ "WHERE a.seq=?;";
										
	public static final String SELECT_ARTICLES  = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=0 AND `cate`=? " // 카테고리에 해당하는 글 가져오기
												+ "ORDER BY `seq` DESC;";

									
	public static final String SELECT_COMMNETS ="SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid=b.uid "
												+ "WHERE `parent`=? "
												+ "ORDER BY `seq` ASC;";
	
	public static final String SELECT_FILE = "";
	
	public static final String INSERT_ARTICLE = "INSERT INTO `JBOARD_ARTICLE` SET"
												+ "`cate`=?,"   //cate추가!
												+ "`title`=?,"
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
	
	
	public static final String INSERT_FILE = "INSERT INTO `JBOARD_FILE` SET "
											+ "`parent`=?,"
											+ "`oldName`=?,"
											+ "`newName`=?,"
											+ "`rdate`=NOW();";
												
	
	
	public static final String UPDATE_ARTICLE_HIT = "UPDATE `JBOARD_ARTICLE` SET `hit` = `hit` + 1 WHERE `seq` = ?;";
	
	public static final String UPDATE_ARTICLE_COMMENT_INC = "UPDATE `JBOARD_ARTICLE` SET `comment` = `comment` + 1 WHERE `seq` = ?;";
	public static final String UPDATE_ARTICLE_COMMENT_DEC = "UPDATE `JBOARD_ARTICLE` SET `comment` = `comment` - 1 WHERE `seq` = ?;";
	
	public static final String UPDATE_FILE_DOWNLOAD = "";
	
	public static final String DELETE_COMMNET = "DELETE FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	
}
