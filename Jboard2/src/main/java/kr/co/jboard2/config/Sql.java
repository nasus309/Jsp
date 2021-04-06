package kr.co.jboard2.config;

public class Sql {

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
	
	public static final String SELECT_TERMS = "SELECT * FROM `JBOARD_TERMS`;";
		
	public static final String SELECT_COUNT_ARTICLE = "SELECT COUNT(*) FROM `JBOARD_ARTICLE` WHERE `parent`=0;"; 
	//parent=0 : ?õêÍ∏??óê ???ï¥?ÑúÎß? countÎ•? Íµ¨Ìïú?ã§. ?ïÑ?ãàÎ©? Î≤àÌò∏Í∞? ?åìÍ∏?ÍπåÏ? ?è¨?ï®?ï¥?Ñú ?ù¥?ÉÅ?ï¥Ïß?! 
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(`seq`) FROM `JBOARD_ARTICLE` WHERE `parent`=0;";
	
	//public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` WHERE `seq`=?;";
	public static final String SELECT_ARTICLE = "SELECT * FROM `JBOARD_ARTICLE` AS a "
												+ "LEFT JOIN `JBOARD_FILE` AS b "
												+ "ON a.seq = b.parent "
												+ "WHERE a.seq=?;";
										
	public static final String SELECT_ARTICLES  = "SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid = b.uid "
												+ "WHERE `parent`=0 " // ?åìÍ∏??ùÑ ?†ú?ô∏?ïú ?õêÍ∏?Îß? Í∞??†∏?ò®?ã§.
												+ "ORDER BY `seq` DESC "
												+ "LIMIT ?, 10;"; // LIMIT : (index,Í∞úÏàò) indexÎ∂??Ñ∞ Î™áÍ∞ú?
									
	public static final String SELECT_COMMNETS ="SELECT a.*, b.nick FROM `JBOARD_ARTICLE` AS a "
												+ "JOIN `JBOARD_USER` AS b "
												+ "ON a.uid=b.uid "
												+ "WHERE `parent`=? "
												+ "ORDER BY `seq` ASC;";
	
	public static final String INSERT_ARTICLES = "INSERT INTO `JBOARD_ARTICLE` SET"
												+ "`title`=?,"
												+ "`content`=?, "
												+ "`file`=?, " //?åå?ùº ?†ïÎ≥¥ÎïåÎ¨∏Ïóê Ï∂îÍ??
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
