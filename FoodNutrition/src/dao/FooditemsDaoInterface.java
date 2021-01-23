package dao;


import java.util.List;

import model.FoodItem;

public interface FooditemsDaoInterface {
	void insertFooditem(FoodItem Fooditem);
	FoodItem selectFooditem(int FooditemId);
	List<FoodItem> selectFooditem(String FooditemName);
    List<FoodItem> selectAllFooditems();
    void deleteFooditem(int id);
	void updateFooditem(FoodItem Fooditem);

}
