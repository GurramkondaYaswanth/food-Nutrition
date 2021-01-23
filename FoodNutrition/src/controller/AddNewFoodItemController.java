package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FoodItemsDao;
import model.FoodItem;

/**
 * Servlet implementation class AddNewFoodItemController
 */
@WebServlet("/new")
public class AddNewFoodItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewFoodItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Getting into Add New FoodItem");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/FoodItemFormView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entering do post");
		String FoodItemTitle = request.getParameter("title");
		String FoodItemDescription = request.getParameter("message");
		
		System.out.println(FoodItemTitle);
		FoodItem FI = new FoodItem();
	//	blog.setBlogId(++i);
		FI.setFoodItemTitle(FoodItemTitle);
		FI.setFoodItemDescription(FoodItemDescription);
		
		FoodItemsDao FIDao = new FoodItemsDao();
		FIDao.insertFooditem(FI);
		response.sendRedirect("allfooditems");
		
	}

}
