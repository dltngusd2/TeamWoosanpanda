package com.woosan.root.alternativeController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class alternativeController {
	@GetMapping("kakaologin")
	public String kakaoLogin(String code) {
	  return "kakaologin";
	}
	@PostMapping("loginAction")
	public String loginAction(String code, HttpServletRequest req) {
		String kakaoid=req.getParameter("kakaoemail");
		req.setAttribute("kakaoid", req.getParameter("kakaoemail"));
		req.setAttribute("kakaoemail", req.getParameter("kakaoemail"));
		
		return "redirect:home";
	}
	@GetMapping("googleLogin")
	public String googleLogin() {
		return "googleLogin";
	}
	@GetMapping("naverLogin")
	public String naverLogin() {
		return "naverLogin";
	}
	@GetMapping("kakaomap")
	public String kakaoMap() {
		return "kakaomap";
	}
	
	@GetMapping("header")
	public String headerTest() {
		return "header";
	}

}
