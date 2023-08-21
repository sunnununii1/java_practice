package db.day2.board2.service;

import java.util.ArrayList;


public interface BoardService {

	boolean insertBoard(String title, String id);

	ArrayList<BoardVO> getBoardList();

}