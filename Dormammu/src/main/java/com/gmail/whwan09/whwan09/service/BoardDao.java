package com.gmail.whwan09.service;

import java.util.ArrayList;

import com.gmail.whwan09.entities.Board;

public interface BoardDao {
//	public int selectCount( BoardPaging boardpaging );
	public int selectCountAll();
	public Board selectOne( int b_seq );
	public ArrayList<Board> selectAll();
//	public ArrayList<Board> selectPageList( BoardPaging boardpaging );
	public int insertRow(Board board);
	public int insertReply(Board board);
	public int updateRow(Board board);
	public int deleteRow( int b_seq );
	public int updateHit( int b_seq );
}
