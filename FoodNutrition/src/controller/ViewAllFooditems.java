package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FoodItemsDao;
import model.FoodItem;

/**
 * Servlet implementation class ViewAllFooditems
 */
@WebServlet("/allfooditems")
public class ViewAllFooditems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllFooditems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("View All Food items");
		System.out.println("Getting all Food items post");
		FoodItemsDao FIDao = new FoodItemsDao();
		List<FoodItem> listFoodItems = null;
		listFoodItems = FIDao.selectAllFooditems();
		for(FoodItem FoodItemslist:listFoodItems) {
			System.out.println(FoodItemslist.getFoodItemId());
			System.out.println(FoodItemslist.getFoodItemTitle());
		}
		request.setAttribute("listFoodItems", listFoodItems);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/FooditemsView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
