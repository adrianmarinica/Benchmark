package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06028")
public class BenchmarkTest06028 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = param;
		if (param.length() > 1) {
		    StringBuilder sbxyz67856 = new StringBuilder(param);
		    bar = sbxyz67856.replace(param.length()-"Z".length(), param.length(),"Z").toString();
		}
		
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}
}
