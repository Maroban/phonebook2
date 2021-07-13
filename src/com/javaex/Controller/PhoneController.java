package com.javaex.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;

@WebServlet("/pbc") // 이 주소가 있어야 연결이 된다.
public class PhoneController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 파라미터 action="값" 읽어오기.
		String action = request.getParameter("action");

		// if문 사용
		if ("list".equals(action)) {
			System.out.println("[리스트]");

			// 리스트
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> personList = phoneDao.getPersonList();

			// request.settAttribute()에 데이터를 넣기.
			request.setAttribute("pList", personList);

			// Controller와 list.jsp 포워드 하기.(원본)
			// RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			// rd.forward(request, response);

			// Controller와 list.jsp 포워드 하기.(메소드 사용)
			WebUtil.forward(request, response, "/WEB-INF/list.jsp");

		} else if ("wform".equals(action)) {
			System.out.println("[글쓰기 폼]");

			// Controller와 writeForm.jsp 포워드 하기.(원본)
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			// rd.forward(request, response);

			// Controller와 writeForm.jsp 포워드 하기.(메소드 사용)
			WebUtil.forward(request, response, "/WEB-INF/writeForm.jsp");

		} else if ("insert".equals(action)) {
			System.out.println("[저장]");

			// 파라미터 값 꺼내기(name, hp, company)
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			// Vo로 묶기
			PersonVo personVo = new PersonVo(name, hp, company);

			// 전화번호 등록 메소드 사용
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.insert(personVo);

			// 리다이렉트(원본)
			// response.sendRedirect("/phonebook2/pbc?action=list");

			// 리다이렉트(메소드 사용)
			WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");

		} else if ("uform".equals(action)) {

			// 파라미터 값 꺼내기(id)
			int personId = Integer.parseInt(request.getParameter("id"));

			// 한 사람 정보 부르는 메소드 사용
			PhoneDao phoneDao = new PhoneDao();
			PersonVo personVo = phoneDao.getPerson(personId);

			// request.settAttribute()에 데이터를 넣기.
			request.setAttribute("pVo", personVo);

			// Controller와 updateForm.jsp 포워드 하기.(원본)
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/WEB-INF/updateForm.jsp");
			// rd.forward(request, response);

			// Controller와 updateForm.jsp 포워드 하기.(메소드 사용)
			WebUtil.forward(request, response, "/WEB-INF/updateForm.jsp");

		} else if ("update".equals(action)) {

			// 파라미터 값 꺼내기(id, name, hp, company)
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");

			// Vo로 묶기
			PersonVo personVo = new PersonVo(id, name, hp, company);

			// 전화번호 수정 메소드 사용
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.update(personVo);

			// 리다이렉트(원본)
			// response.sendRedirect("/phonebook2/pbc?action=list");

			// 리다이렉트(메소드 사용)
			WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");

		} else if ("delete".equals(action)) {

			// 파라미터 값 꺼내기(id)
			int id = Integer.parseInt(request.getParameter("id"));

			// 전화번호 삭제 메소드 사용
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.delete(id);

			// 리다이렉트(메소드 사용)
			WebUtil.redirect(request, response, "/phonebook2/pbc?action=list");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
