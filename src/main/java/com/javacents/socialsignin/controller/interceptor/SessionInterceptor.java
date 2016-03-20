package com.javacents.socialsignin.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.javacents.socialsignin.controller.AccountController;
import com.javacents.socialsignin.model.User;

/**
 * Interceptor to check whether user is logged in or not
 * 
 * @author Isah
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User loggedUser = (User) request.getSession().getAttribute(AccountController.LOGGED_USER);
		if (loggedUser == null) {
			response.sendRedirect("/account/login");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
