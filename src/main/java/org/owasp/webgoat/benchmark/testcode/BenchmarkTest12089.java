package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12089")
public class BenchmarkTest12089 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		StringBuilder sbxyz77378 = new StringBuilder(param);
		String bar = sbxyz77378.append("_SafeStuff").toString();

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
