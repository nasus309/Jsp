package kr.co.farmstory2.config;

public class Sql {
	
	public static final String SELECT_COUNT_USER = "SELECT COUNT(`uid`) FROM `JBOARD_USER` WHERE `uid`=?;";
	public static final String SELECT_COUNT_NICK = "SELECT COUNT(`nick`) FROM `JBOARD_USER` WHERE `nick`=?;";
	public static final String SELECT_COUNT_HP = "SELECT COUNT(`hp`) FROM `JBOARD_USER` WHERE `hp`=?;";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(`email`) FROM `JBOARD_USER` WHERE `email`=?;";
	
	public static final String SELECT_TERMS = "SELECT * FROM `JBOARD_TERMS`;";

	public static final String SELECT_USER  = "SELECT * FROM `JBOARD_USER` WHERE `uid`=? AND `pass`=SHA2(?,224);";
	public static final String INSERT_USER ="INSERT INTO `JBOARD_USER` SET "
											   +"`uid`=?,"
											   + "`pass`=SHA2(?,224),"
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
	
	public static final String SELECT_ARTICLE_NOTICE = "SELECT * FROM `JBOARD_ARTICLE` WHERE `cate`='notice' ORDER BY `seq` DESC LIMIT 3;";
	public static final String SELECT_ARTICLE_QNA = "SELECT * FROM `JBOARD_ARTICLE` WHERE `cate`='qna' ORDER BY `seq` DESC LIMIT 3;";
	public static final String SELECT_ARTICLE_FAQ = "SELECT * FROM `JBOARD_ARTICLE` WHERE `cate`='faq' ORDER BY `seq` DESC LIMIT 3;";
	
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM `JBOARD_ARTICLE` WHERE `parent`=0 AND `cate`=?;"; 
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `JBOARD_ARTICLE` WHERE `parent`=0;";
	
	//public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` AS a "
												+ "LEFT JOIN `JBOARD_FILE` AS b "
												+ "ON a.seq = b.parent "
												+ "WHERE a.seq=?;";
										
	public static final String SELECT_ARTICLES   = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
													+ "JOIN `JBOARD_USER` AS b "
													+ "ON a.uid = b.uid "
													+ "WHERE `parent`=0 AND `cate`=? " // 댓글을 제외한 원글만 가져온다.
													+ "ORDER BY `seq` DESC "
													+ "LIMIT ?, 10;"; // LIMIT : (index,개수) index부터 몇개?

									
	public static final String SELECT_COMMNETS ="SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid=b.uid "
												+ "WHERE `parent`=? "
												+ "ORDER BY `seq` ASC;";
	
	public static final String SELECT_FILE = "SELECT * FROM `JBOARD_FILE` WHERE `seq`=?;";
	
	public static final String INSERT_ARTICLE = "INSERT INTO `JBOARD_ARTICLE` SET"
												+ "`cate`=?,"   //cate추가!
												+ "`title`=?,"
												+ "`content`=?, "
												+ "`file` =?,"
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
	
	public static final String UPDATE_FILE_DOWNLOAD = "UPDATE `JBOARD_FILE` SET `download` = `download` + 1 WHERE `seq`=?;";
	
	public static final String UPDATE_ARTICLE = "UPDATE `JBOARD_ARTICLE` SET "
												+ "`title`=?,"
												+ "`content`=? "
												//+ "`file`=? "
												+ "WHERE `seq`=? AND `parent` = 0;";
	
	public static final String DELETE_COMMENT = "DELETE FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	public static final String DELETE_ARTICLE = "DELETE FROM `JBOARD_ARTICLE` WHERE `seq`=? OR `parent`=?;";
	
}
