package com.gmail.whwan09.DBpool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBpoolConnectTestMain {

	public static void main(String[] args) {
		DBConnectionManager db = DBConnectionManager.getInstance();
		Connection cn = null;
		PreparedStatement ps = null; //μΏΌλ¦¬λ₯? ?μ§?? λ¬Έμ₯ 
		ResultSet rs =null;
		System.out.println("DB test start...");
		
		String sql = "SELECT count(*) FROM member"; //* ?Ό?? desc????λ‘? 1,2,3,... ???κ°μ΄ μ§?? ?λ©? select 1, 2, 3 ?΄? κ²? ??€(rs.execute?? μΆλ ₯?)
		try {
			cn = db.getConnection(); //λ§€λ? Έ? ?°κ²°ν΄? cn?΄ κ°?μ§?κ³? ??€
			ps = (PreparedStatement) cn.prepareStatement( sql ); //λͺλ Ή?΄(μΏΌλ¦¬)λ₯? ?μ§?? κ²?
			rs = ps.executeQuery(); //κ²°κ³Όκ°μ κ°?μ§?κ³? ??€ ??¬κ°? ?λ©? μΊμΉλ¬ΈμΌλ‘? λΉ μ?κ²? ??€DB? ?© λΉμ΄?Όκ³? ?κ°νλ©? ?½?€ executeQuery ? select?? ?¬?© select? λ¬΄μ‘°κ±? resultset?Όλ‘? λ°μ΅??€.
//			while (rs.next()){
//				System.out.print(" --> "+rs.getString(1)+" "+rs.getString(2)+rs.getInt("age")); //number -> string κ°??₯ varchar -> int λΆκ??₯
//			}
			if ( rs.next() ) {  //κ²°κ³Όκ°μ΄ ?¬? €κ°λ©΄ while λ¬ΈμΌλ‘? μ§λκ²? κ·Έλ¬λ―?λ‘? κ²°κ³Όκ°μ΄ λͺκ°?Έμ§? ??€? ???Ό ??€ insert,delete,update? κ²°κ³Όκ°? ?€?΄κ°λ€ ??€?΄κ°λ€ ?μ€ν?
				System.out.println("count : " + rs.getInt(1) );
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("db error : "+e.getMessage());
		}
	}

}