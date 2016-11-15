package com.gmail.whwan09.DBpool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBpoolConnectTestMain {

	public static void main(String[] args) {
		DBConnectionManager db = DBConnectionManager.getInstance();
		Connection cn = null;
		PreparedStatement ps = null; //ì¿¼ë¦¬ë¥? ?˜ì§??Š” ë¬¸ì¥ 
		ResultSet rs =null;
		System.out.println("DB test start...");
		
		String sql = "SELECT count(*) FROM member"; //* ?¼?•Œ?Š” desc?ˆœ?„œ??ë¡? 1,2,3,... ?œ„??ê°™ì´ ì§?? •?•˜ë©? select 1, 2, 3 ?´? ‡ê²? ?œ?‹¤(rs.execute?—?„œ ì¶œë ¥?‹œ)
		try {
			cn = db.getConnection(); //ë§¤ë‹ˆ? ¸?‘ ?—°ê²°í•´?„œ cn?´ ê°?ì§?ê³? ?ˆ?‹¤
			ps = (PreparedStatement) cn.prepareStatement( sql ); //ëª…ë ¹?–´(ì¿¼ë¦¬)ë¥? ?˜ì§??Š” ê²?
			rs = ps.executeQuery(); //ê²°ê³¼ê°’ì„ ê°?ì§?ê³? ?ˆ?‹¤ ?—?Ÿ¬ê°? ?‚˜ë©? ìºì¹˜ë¬¸ìœ¼ë¡? ë¹ ì?ê²? ?œ?‹¤DB? „?š© ë¹ˆì´?¼ê³? ?ƒê°í•˜ë©? ?‰½?‹¤ executeQuery ?Š” select?—?„œ ?‚¬?š© select?Š” ë¬´ì¡°ê±? resultset?œ¼ë¡? ë°›ìŠµ?‹ˆ?‹¤.
//			while (rs.next()){
//				System.out.print(" --> "+rs.getString(1)+" "+rs.getString(2)+rs.getInt("age")); //number -> string ê°??Š¥ varchar -> int ë¶ˆê??Š¥
//			}
			if ( rs.next() ) {  //ê²°ê³¼ê°’ì´ ?—¬? ¤ê°œë©´ while ë¬¸ìœ¼ë¡? ì§œëŠ”ê²? ê·¸ëŸ¬ë¯?ë¡? ê²°ê³¼ê°’ì´ ëª‡ê°œ?¸ì§? ?™•?‹¤?ˆ ?•Œ?•„?•¼ ?•œ?‹¤ insert,delete,update?Š” ê²°ê³¼ê°? ?“¤?–´ê°”ë‹¤ ?•ˆ?“¤?–´ê°”ë‹¤ ?‘˜ì¤‘í•˜?‚˜
				System.out.println("count : " + rs.getInt(1) );
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("db error : "+e.getMessage());
		}
	}

}