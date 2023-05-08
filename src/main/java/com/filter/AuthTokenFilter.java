//package com.filter;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//import com.Entity.UserEntity;
//import com.Repository.UserSingUpRepository;
//import com.google.gson.Gson;
//
//
////@Component
//public class AuthTokenFilter implements Filter {
//
//	@Autowired
//	UserSingUpRepository userSingUpRepository;
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//
//		HttpServletRequest request = (HttpServletRequest) (req);
//		HttpServletResponse response = (HttpServletResponse) (resp);
//
//		System.out.println("AuthTokenFilter");
////		Enumeration<String> n = request.getHeaderNames();
////
////		while (n.hasMoreElements()) {
////			System.out.println("==> " + n.nextElement());
////		}
//
//		String url = request.getRequestURL().toString();
//		System.out.println(url);
//
//		String token = request.getHeader("token");
//		System.out.println(token);
//		System.out.println("Method => " + request.getMethod());
//		if (url.contains("/public/")) {
//			chain.doFilter(request, response);
//		} else if (request.getMethod().toString().equals("options")) {
//			System.out.println("PreFlight....");
//			chain.doFilter(request, response);
//		} else if (token == null || token.trim().length() != 16) {
//			if (request.getMethod().equals("options")) {
//				System.out.println("--------------");
//				chain.doFilter(request, response);
//
//			}
//			System.out.println("Token is Null");
//			String userJsonString = new Gson().toJson(token);
//
//			PrintWriter out = resp.getWriter();
//			resp.setContentType("application/json");
//			response.setStatus(HttpStatus.UNAUTHORIZED.value());
//			out.print(userJsonString);
//
//		} else {
//			UserEntity userExist = userSingUpRepository.findByToken(token).orElse(null);
//
//			if (userExist == null) {
//				String userJsonString = new Gson().toJson("Invalid Access");
//
//				PrintWriter out = resp.getWriter();
//				resp.setContentType("application/json");
//				response.setStatus(HttpStatus.UNAUTHORIZED.value());
//				out.print(userJsonString);
//
//			}
//
//			chain.doFilter(req, resp);
//		}
//	}
//
//}