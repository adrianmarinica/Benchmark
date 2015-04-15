package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09911")
public class BenchmarkTest09911 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map17362 = new java.util.HashMap<String,Object>();
		map17362.put("keyA-17362", "a_Value"); // put some stuff in the collection
		map17362.put("keyB-17362", param.toString()); // put it in a collection
		map17362.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map17362.get("keyB-17362"); // get it back out
		bar = (String)map17362.get("keyA-17362"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
