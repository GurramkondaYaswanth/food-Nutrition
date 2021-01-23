package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;

import dao.SigninDao;
import model.Admin;




/**
 * Servlet implementation class LoginViewController
 */
@WebServlet("/login")
public class LoginViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); //get email from jsp page
		String password = request.getParameter("password"); //get password from jsp page 
		String Admin = request.getParameter("radio");
		System.out.println("Admin "+Admin+email);
		String adminCheck = "admin";
		
		if(!Admin.isEmpty()) {
		if(Admin.equalsIgnoreCase(adminCheck)) {
			
			Admin admin = new Admin();
			admin.setEmail(email);
			admin.setPassword(password);
			

			SigninDao signinDao = new SigninDao();
			boolean validateAdmin = false;
			try {
				validateAdmin = signinDao.Adminlogin(admin);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("validateAdmin "+validateAdmin);
			if(validateAdmin) {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/FooditemsView.jsp");
				rd.forward(request, response);
			}else
			{
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
				rd.forward(request, response);
			}
			
		}else {
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/FooditemsView.jsp");
			rd.forward(request, response);
		}
		}else {
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/FooditemsView.jsp");
			rd.forward(request, response);
			
		}

	}




}
