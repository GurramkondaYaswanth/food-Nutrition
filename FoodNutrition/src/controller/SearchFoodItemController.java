package controller;

import java.io.IOException;
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
 * Servlet implementation class SearchFoodItemController
 */
@WebServlet("/search")
public class SearchFoodItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFoodItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Search FoodItem");
//		String FoodItemName = request.getParameter("FoodItemWord");
//		System.out.println("Search FoodItem dopost"+FoodItemName);
		SearchFoodItem(request, response);
	}

	private void SearchFoodItem(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		// TODO Auto-generated method stub
		String FoodItemName = request.getParameter("FoodItemWord");
//		String FI = request.getAttribute("foodtitle");
		System.out.println("Search FoodItem"+FoodItemName);
		FoodItemsDao FIDao = new FoodItemsDao();
		List<FoodItem> Fooditemdetails = FIDao.selectFooditem(FoodItemName);
		System.out.println(Fooditemdetails.get(0).getFoodItemTitle());
		request.setAttribute("listFoodItems", Fooditemdetails);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/FooditemsView.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		String FoodItemName = request.getParameter("FoodItemWord");
//		System.out.println("Search FoodItem"+FoodItemName);
	}

}
