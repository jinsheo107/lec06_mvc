package com.gn.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("board_title");
		Board option = new Board();
		option.setBoard_title(title);
		
		// 현재 페이지 넘버 받아오기
		String nowPage = request.getParameter("nowPage");
		if(nowPage != null) {
			option.setNowPage(Integer.parseInt(nowPage));
		}
		// 전체 목록 개수 조회해서 페이징 바 구성
		option.setTotalData(new BoardService().selectBoardCount(option));
		
		List<Board> list = new BoardService().selectBoardList(option);
//		list = request.getParameter("resultList");
		// 데이터 보내기
		request.setAttribute("paging", option);
		request.setAttribute("resultList", list);
		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}