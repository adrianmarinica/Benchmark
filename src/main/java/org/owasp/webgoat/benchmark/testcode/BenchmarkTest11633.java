package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11633")
public class BenchmarkTest11633 extends HttpServlet {
	
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
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map69598 = new java.util.HashMap<String,Object>();
		map69598.put("keyA-69598", "a Value"); // put some stuff in the collection
		map69598.put("keyB-69598", param.toString()); // put it in a collection
		map69598.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map69598.get("keyB-69598"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
