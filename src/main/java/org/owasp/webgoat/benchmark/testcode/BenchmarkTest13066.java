package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13066")
public class BenchmarkTest13066 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = new Test().doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map3761 = new java.util.HashMap<String,Object>();
		map3761.put("keyA-3761", "a Value"); // put some stuff in the collection
		map3761.put("keyB-3761", param.toString()); // put it in a collection
		map3761.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map3761.get("keyB-3761"); // get it back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
