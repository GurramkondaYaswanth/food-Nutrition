package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String adminCheck = "admin";
		
		if(!isNullOrEmpty(Admin)) {
		if(Admin.equalsIgnoreCase(adminCheck)) {
			
			Admin admin = new Admin();
			admin.setEmail(email);
			admin.setPassword(password);
			
//			Employee emp = new Employee();
//			emp.setEmail(email);
//			emp.setPassword(password);
			SigninDao signinDao = new SigninDao();
			boolean validateAdmin = false;
			try {
				validateAdmin = signinDao.Adminlogin(admin);
				System.out.println("validateAdmin"+validateAdmin);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(validateAdmin) {
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
				rd.forward(request, response);
			}else
			{
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
				rd.forward(request, response);
			}
			
		}
		}else {
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
			
		}

		
//		User user = new User(password, password, null);
//		user.setEmail(email);
//		user.setPassword(password);
//		UserDao userdao = new UserDao();
//		
//		boolean validateUser = userdao.loginUser(user);
//		if(validateUser) {
//			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
//			rd.forward(request, response);
//		}else
//		{
//			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
//			rd.forward(request, response);
//		}
	}

	private boolean isNullOrEmpty(String doctor) {
		// TODO Auto-generated method stub
		return false;
	}

}
