package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Admin;
import utility.HibernateConnectionManager;

public class SignupDao implements SignupDaoInterface{
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	@Override
	public int AdminSignUp(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction transaction =  session.beginTransaction();
		if(session.save(admin) != null) {
			transaction.commit();
			session.close();
			return 1;
		}else
			return 0;
	}

	
	


}
