package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01621")
public class BenchmarkTest01621 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		String bar;
		
		// Simple ? condition that assigns param to bar on false condition
		int i = 106;
		
		bar = (7*42) - i > 200 ? "This should never happen" : param;
		
		
		
		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			// throw new ServletException(e); - for now, it's ok if this provider not on the platform
		} catch (javax.crypto.NoSuchPaddingException e) {
			System.out.println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) Test Case");
			throw new ServletException(e);
		}

		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) executed");
	}
}
