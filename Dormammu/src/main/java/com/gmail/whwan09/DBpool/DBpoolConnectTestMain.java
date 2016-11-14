package com.gmail.whwan09.DBpool;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBpoolConnectTestMain {

	public static void main(String[] args) {
		DBConnectionManager db = DBConnectionManager.getInstance();
		Connection cn = null;
		PreparedStatement ps = null; //쿼리�? ?���??�� 문장 
		ResultSet rs =null;
		System.out.println("DB test start...");
		
		String sql = "SELECT count(*) FROM member"; //* ?��?��?�� desc?��?��??�? 1,2,3,... ?��??같이 �??��?���? select 1, 2, 3 ?��?���? ?��?��(rs.execute?��?�� 출력?��)
		try {
			cn = db.getConnection(); //매니?��?�� ?��결해?�� cn?�� �?�?�? ?��?��
			ps = (PreparedStatement) cn.prepareStatement( sql ); //명령?��(쿼리)�? ?���??�� �?
			rs = ps.executeQuery(); //결과값을 �?�?�? ?��?�� ?��?���? ?���? 캐치문으�? 빠�?�? ?��?��DB?��?�� 빈이?���? ?��각하�? ?��?�� executeQuery ?�� select?��?�� ?��?�� select?�� 무조�? resultset?���? 받습?��?��.
//			while (rs.next()){
//				System.out.print(" --> "+rs.getString(1)+" "+rs.getString(2)+rs.getInt("age")); //number -> string �??�� varchar -> int 불�??��
//			}
			if ( rs.next() ) {  //결과값이 ?��?��개면 while 문으�? 짜는�? 그러�?�? 결과값이 몇개?���? ?��?��?�� ?��?��?�� ?��?�� insert,delete,update?�� 결과�? ?��?��갔다 ?��?��?��갔다 ?��중하?��
				System.out.println("count : " + rs.getInt(1) );
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("db error : "+e.getMessage());
		}
	}

}