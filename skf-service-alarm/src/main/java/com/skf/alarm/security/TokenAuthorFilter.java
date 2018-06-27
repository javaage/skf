package com.skf.alarm.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.skf.alarm.service.UserService;

@Service
public class TokenAuthorFilter extends OncePerRequestFilter {
	@Autowired
	private UserService userService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestPath = request.getRequestURI();
		if (!requestPath.contains("login")) {
			if (checkToken(request)) {
				filterChain.doFilter(request, response);
			} else {
				response.sendError(403);
			}
		}else{
			filterChain.doFilter(request, response);
		}
	}

	private boolean checkToken(HttpServletRequest request) throws UnsupportedEncodingException {
		if(request.getHeader("Access-Control-Request-Headers")!=null&&!request.getHeader("Access-Control-Request-Headers").equals("")){
			return true;
		}
		String token = request.getHeader("Token");
		String username = request.getHeader("username");
		if(token==null||token.equals("")){
			return false;
		}
		String usercode = new String(Base64.decodeBase64(token.getBytes("UTF-8")), "UTF-8");
		if(!userService.checkToken(username, usercode)){
			return false;
		}else{
			List<String> oemList = userService.getUsrOemList(usercode);
			List<String> cstmList = userService.getUsrCstmList(usercode);
			int userRoleId = userService.getUserRoleId(usercode);
			request.setAttribute("userCode", usercode);
			request.setAttribute("oemCodeList", oemList);
			request.setAttribute("cstmCodeList", cstmList);
			request.setAttribute("userRoleId", userRoleId);
			return true;
		}
	}

}
