package dao;

import java.sql.SQLException;

import model.Admin;



interface SignupDaoInterface {
//	int CustomerSignUp(Customer customer) throws SQLException;
	int AdminSignUp(Admin admin) throws SQLException;
}
