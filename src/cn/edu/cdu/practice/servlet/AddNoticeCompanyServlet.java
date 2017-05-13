package cn.edu.cdu.practice.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.cdu.practice.model.NoticeCompany;
import cn.edu.cdu.practice.service.NoticeService;
import cn.edu.cdu.practice.service.impl.NoticeServiceImpl;
import cn.edu.cdu.practice.utils.Log4jUtils;
import cn.edu.cdu.practice.utils.ValidateUtils;

/**
 * Servlet implementation class AddNoticeCompanyServlet
 */
@WebServlet("/SystemsManagement/AddNoticeCompanyServlet")
public class AddNoticeCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddNoticeCompanyServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(title+" "+content);
		if (ValidateUtils.validate(title) || ValidateUtils.validate(content)) {
			System.out.println("有可疑参数");
			request.getRequestDispatcher("/404.html").forward(request, response);
			return ;
		}
		NoticeService noticeService = new NoticeServiceImpl();
		NoticeCompany noticeCompany = new NoticeCompany();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		if (userName == null) {
			userName = "sayHello";
		}
		noticeCompany.setCompanyUsername(userName);
		noticeCompany.setTitle(title);
		noticeCompany.setContent(content);
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
		noticeCompany.setReleaseDate(sqlDate);
		try {
			noticeService.provideAnnouncement(noticeCompany);
			request.getRequestDispatcher("/SystemsManagement/ShowNoticeListServlet").forward(request, response);
		} catch(Exception e) {
			Log4jUtils.info(e.getMessage());
			request.getRequestDispatcher("/404.html").forward(request, response);
		}
	}

}