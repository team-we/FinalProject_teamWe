package com.gmail.whwan09;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gmail.whwan09.entities.Member;
import com.gmail.whwan09.service.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private Member member;
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(Locale locale, Model model) {
		
		return "main";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "main";
	}
		
	@RequestMapping(value = "/memberInsert", method = RequestMethod.GET)
	public String memberInsert(Locale locale, Model model) {
		return "member/member_insert";
	}
	
	@RequestMapping(value = "/idconfirm", method = RequestMethod.POST)
	@ResponseBody
	public int idconfirm(@RequestParam String id ) {
		int count = 0;
		int find = 0;
		try {
			MemberDao dao = sqlSession.getMapper(MemberDao.class);
			count = dao.selectCount(id);
		} catch (Exception e) {
		}
		if ( count > 0){
			find = 1;
		} else {
			find = 0;
		}
		return find;
	}
	
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView memberInsert(@ModelAttribute("member") Member member ) {
		ModelAndView mav = new ModelAndView("member/member_result");
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		String msg = "";
		int result = dao.insertRow(member);
		if(result == 1){
			msg="회원가입이 완료 되었습니다";
		} else {
			msg="회원 가입 실패 입니다";
		}
		
		mav.addObject("result", "ok" );
		mav.addObject("msg",msg);
		return mav;
	}
	@RequestMapping(value = "/aerobic", method = RequestMethod.GET)
	public String aerobic(Locale locale, Model model) {
		
		return "training/aerobic";
	}
	@RequestMapping(value = "/weight", method = RequestMethod.GET)
	public String weight(Locale locale, Model model) {
		
		return "training/weight";
	}
	@RequestMapping(value = "/burpee", method = RequestMethod.GET)
	public String burpee(Locale locale, Model model) {
		return "training/burpee";
	}
	@RequestMapping(value = "/mountainclimber", method = RequestMethod.GET)
	public String mountainclimber(Locale locale, Model model) {
		
		return "training/mountainclimber";
	}
	
	@RequestMapping(value = "/jumpingjack", method = RequestMethod.GET)
	public String jumpingjack(Locale locale, Model model) {
		
		return "training/jumpingjack";
	}
	@RequestMapping(value = "/running", method = RequestMethod.GET)
	public String running(Locale locale, Model model) {
		
		return "training/running";
	}
	@RequestMapping(value = "/cycle", method = RequestMethod.GET)
	public String cycle(Locale locale, Model model) {
		
		return "training/cycle";
	}
	@RequestMapping(value = "/skipping", method = RequestMethod.GET)
	public String skipping(Locale locale, Model model) {
		
		return "training/skipping";
	}

	
}
