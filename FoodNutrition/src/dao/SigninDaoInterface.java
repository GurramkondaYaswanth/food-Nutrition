package dao;

import java.sql.SQLException;

import model.Admin;



interface SigninDaoInterface {
	 boolean Adminlogin(Admin admin) throws SQLException;
//	 boolean Employeelogin(Employee employee) throws SQLException;
	 
}
