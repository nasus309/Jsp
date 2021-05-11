package kr.co.jboard1.config;

public class Sql {

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
	
	public static final String SELECT_TERMS = "SELECT * FROM `JBOARD_TERMS`;";
		
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM `JBOARD_ARTICLE` WHERE `parent`=0;"; 
	//parent=0 : 원글에 대해서만 count를 구한다. 아니면 번호가 댓글까지 포함해서 이상해짐! 
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `JBOARD_ARTICLE` WHERE `parent`=0;";
	
	//public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` AS a "
												+ "LEFT JOIN `JBOARD_FILE` AS b "
												+ "ON a.seq = b.parent "
												+ "WHERE a.seq=?;";
										
	public static final String SELECT_ARTICLES  = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=0 " // 댓글을 제외한 원글만 가져온다.
												+ "ORDER BY `seq` DESC "
												+ "LIMIT ?, 10;"; // LIMIT : (index,개수) index부터 몇개?
									
	public static final String SELECT_COMMNETS ="SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid=b.uid "
												+ "WHERE `parent`=? "
												+ "ORDER BY `seq` ASC;";
	
	public static final String INSERT_ARTICLES = "INSERT INTO `JBOARD_ARTICLE` SET"
												+ "`title`=?,"
												+ "`content`=?, "
												+ "`file`=?, " //파일 정보때문에 추가?
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
	
	public static final String DELETE_COMMNET = "DELETE FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	
}
