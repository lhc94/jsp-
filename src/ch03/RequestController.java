package ch03;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestController
 */
@WebServlet("/ch03_servlet/request.do") //URL pattern
public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		String hobby=request.getParameter("hobby");
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("age", age);
		gender=gender.equals("m") ? "남" : "여";
		map.put("gender", gender);
		map.put("hobby", hobby);
		request.setAttribute("map", map);
		String page="/ch03/request_result.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);  // 출력 페이지로 포워딩
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
