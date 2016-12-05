package com.gmail.whwan09;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gmail.whwan09.entities.Board;
import com.gmail.whwan09.service.BoardDao;

@Controller
public class BoardController {
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/boardMain", method = RequestMethod.GET)
	public String boardMain(Locale locale, Model model) {
		
		return "board/freeboard_list";
	}
	
	@RequestMapping(value = "/boardInsertForm", method = RequestMethod.GET)
	public String boardInsertForm(Locale locale, Model model) {
		return "board/freeboard_insert";
	}
	@RequestMapping(value = "/boardInsert", method = RequestMethod.POST)
	public ModelAndView boardInsert(@RequestParam CommonsMultipartFile file ,@ModelAttribute("board") Board board, HttpServletRequest request){
//		String path = "D:/SPRING/itschoolspring/src/main/webapp/resources/uploadfolder/";
//		String path = "C:/Users/vejen/Desktop/Spring/itschoolspring/src/main/webapp/resources/uploadfolder/";
//		String filename=file.getOriginalFilename();  
	    
//		try{  
//			byte barr[]=file.getBytes();  
//			BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+filename));  
//			bout.write(barr);  
//			bout.flush();  
//			bout.close();  
//		}catch(Exception e){System.out.println(e);}  
		
		ModelAndView mav = new ModelAndView("board/board_result");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String b_ip = request.getRemoteAddr();
		
		SimpleDateFormat simple = 
		new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentdate = new Date ( );
		String b_date = simple.format ( currentdate );
//		if(filename.equals(""))
//			board.setB_attach("");
//		else
//			board.setB_attach(path+filename);
	 
		board.setB_ip(b_ip);
		board.setB_date(b_date);
		board.setB_step(0);
		board.setB_hit(0);
		String msg = "";
		int result = dao.insertRow(board);
		
		if (result > 0)
			msg = "Success! Inserted your article";
		else
			msg = "Failed! your article";
		mav.addObject("msg",msg);
		
		return mav;
	}
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boards_list(Locale locale, Model model) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<Board> boards = dao.selectAll();
		ModelAndView mav = new ModelAndView("board/freeboard_list");
		mav.addObject("boards",boards);
		return mav;
	}
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public @ResponseBody ModelAndView boardDetail(@RequestParam int b_seq) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.updateHit(b_seq);
		Board board = dao.selectOne(b_seq);
		ModelAndView mav = new ModelAndView("board/freeboard_detail");
		mav.addObject("board",board);
		return mav;
	}
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(@ModelAttribute("board") Board board, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("board/board_result");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String b_ip = request.getRemoteAddr();
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.KOREA);
		Date currentdate = new Date();
		String b_date = simple.format( currentdate );
		
		board.setB_ip(b_ip);
		board.setB_date(b_date);
		
		String msg = "";
		int result = dao.updateRow(board);
		if(result == 1){
			msg="success! Update your article";
		} else {
			msg="failed! your article";
		}
		mav.addObject("msg",msg);
		return mav;
	}

	@RequestMapping(value = "/boardTest", method = RequestMethod.GET)
	public String boardTest(Locale locale, Model model) {
		return "board/freeboard_insert_editor";
	}

}
