package dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;


import model.FoodItem;
import utility.HibernateConnectionManager;

public class FoodItemsDao implements FooditemsDaoInterface{
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	@Override
	public void insertFooditem(FoodItem Fooditem) {
		// TODO Auto-generated method stub
		 long rowCount = 0 ; 
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		  Criteria criteria = session.createCriteria(FoodItem.class);
//          criteria.setProjection(Projections.rowCount());
//          List food = criteria.list();
//          if (food!=null) {
//        	   rowCount =  (long) food.get(0);
//              System.out.println("Total rows:" + rowCount);
//          }
//          
//        
//		int fooditemid = (int) rowCount;  
		
		Criteria criteria = session
			    .createCriteria(FoodItem.class)
			    .setProjection(Projections.max("FoodItemId"));
			Integer maxValue = (Integer)criteria.uniqueResult();
		
		Fooditem.setFoodItemId(maxValue+1);  
		System.out.println("maxValue in Id:" + maxValue);
		session.save(Fooditem);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public FoodItem selectFooditem(int FooditemId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		FoodItem Fooditem = session.get(FoodItem.class, FooditemId);
		session.close();
		return Fooditem;	
	}

	@Override
	public List<FoodItem> selectAllFooditems() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FoodItem> query = builder.createQuery(FoodItem.class);
		Root<FoodItem> root = query.from(FoodItem.class);
		query.select(root);
		Query<FoodItem> q = session.createQuery(query);
		List<FoodItem> listFooditem = q.getResultList();
		session.close();
		return listFooditem;
	}

	@Override
	public void deleteFooditem(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		FoodItem Fooditem = session.get(FoodItem.class, id);
		session.delete(Fooditem);
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateFooditem(FoodItem Fooditem) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(Fooditem);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<FoodItem> selectFooditem(String FooditemName) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.openSession();
//		String hql = "FROM fooditem where email ='"+FooditemName+"'";
		Query query = session.createQuery("FROM FoodItem where FoodItemTitle ='Basil'");
		List<FoodItem>  Fooditem =  query.list();
//		FoodItem FI = new FoodItem();
		System.out.println(Fooditem.size());
		System.out.println(Fooditem.get(0).getFoodItemTitle());
		System.out.println(Fooditem.get(0).getFoodItemId());
//     	FI.setFoodItemId(Fooditem.get(0).getFoodItemId());
//     	FI.setFoodItemTitle(FooditemName);
//     	FI.setFoodItemDescription(Fooditem.get(0).getFoodItemDescription());
////		FoodItem FI1 = session.get(FoodItem.class, FooditemName);
//     	System.out.println(FI.getFoodItemTitle()+"FI");
		session.close();
		return Fooditem;
		
	}


}
