package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08656")
public class BenchmarkTest08656 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map67904 = new java.util.HashMap<String,Object>();
		map67904.put("keyA-67904", "a_Value"); // put some stuff in the collection
		map67904.put("keyB-67904", param.toString()); // put it in a collection
		map67904.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map67904.get("keyB-67904"); // get it back out
		bar = (String)map67904.get("keyA-67904"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
