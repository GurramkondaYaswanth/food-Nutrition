package dao;

import java.sql.SQLException;

import javax.transaction.SystemException;

import model.Admin;



interface SigninDaoInterface {
	 boolean Adminlogin(Admin admin) throws SQLException, SystemException;
//	 boolean Employeelogin(Employee employee) throws SQLException;
	 
}
