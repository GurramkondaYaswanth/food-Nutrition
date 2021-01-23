package dao;

import java.sql.SQLException;

import javax.persistence.EntityTransaction;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Admin;
import utility.HibernateConnectionManager;

public class SigninDao implements SigninDaoInterface{
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	@Override
	public boolean Adminlogin(Admin admin) throws SystemException  {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		System.out.println("adminlogin");
		try {
//			tx =  (Transaction) session.getTransaction();
//			( (EntityTransaction)tx).begin();
			Query query = session.createQuery("from Admin where email ='"+admin.getEmail()+"'"+"and password ='"+admin.getPassword()+"'");
			admin = (Admin) query.uniqueResult();
			System.out.println(admin.getEmail());
			tx.commit();
		}catch(Exception e) {
			if(tx!= null) {
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				}	
			}
			e.printStackTrace();
			return false;
				
		}
		finally {
			session.close();
		}
		return true;
	}


}
