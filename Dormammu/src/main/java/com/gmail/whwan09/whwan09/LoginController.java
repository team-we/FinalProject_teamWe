package com.gmail.whwan09;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmail.whwan09.entities.Member;
import com.gmail.whwan09.service.MemberDao;

@Controller
public class LoginController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "login/insert_login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "main";
	}
	@RequestMapping(value = "/loginup", method = RequestMethod.POST)
	public String loginup(@ModelAttribute("member") Member member, HttpSession session){
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		Member data = dao.selectLogin(member);
		if(data == null){
			return "login/insert_login";
		} else {
			session.setAttribute("sessionid",data.getId());
			session.setAttribute("sessionpass",data.getPassword());
			session.setAttribute("sessionname",data.getName());
			return "redirect:/home";
		}
	}

}
