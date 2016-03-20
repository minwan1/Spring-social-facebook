package com.javacents.socialsignin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	public static final String LOGGED_USER = "loggedUser";

	@RequestMapping(value = { "/", "/account/login" }, method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping(value = "/account/logout", method = RequestMethod.GET)
	public String logoutGet(HttpServletRequest req) {
		req.getSession().removeAttribute(LOGGED_USER);
		return "redirect:/";
	}

	@RequestMapping(value = "/account/settings", method = RequestMethod.GET)
	public String settings(HttpServletRequest req) {
		return "settings";
	}
}
