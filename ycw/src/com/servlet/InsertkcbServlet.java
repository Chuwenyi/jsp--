package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.ManageJDBC;

public class InsertkcbServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertkcbServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("gb2312"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String kch=request.getParameter("kch");
		String kcm=request.getParameter("kcm");
		int kxxq=Integer.parseInt(request.getParameter("kxxq"));
		int xf=Integer.parseInt(request.getParameter("xf"));
		int xs=Integer.parseInt(request.getParameter("xs"));
		String sql="insert into kcb ( kch,kcm,kxxq,xf,xs ) values('"+kch+"','"+kcm+"',"+kxxq+","+xf+","+xs+")";
		ManageJDBC manageJDBC=new ManageJDBC();
		manageJDBC.createconnection();
		int num=manageJDBC.exc_update(sql);
		if(num>0)
			out.print("����ɹ�");
		else
			out.print("����ʧ��");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
