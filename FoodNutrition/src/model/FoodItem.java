package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class FoodItem {
	
	@Id
private int FoodItemId;

private String FoodItemTitle;
	
private String FoodItemDescription;

public int getFoodItemId() {
	return FoodItemId;
}

public void setFoodItemId(int foodItemId) {
	FoodItemId = foodItemId;
}

public String getFoodItemTitle() {
	return FoodItemTitle;
}

public void setFoodItemTitle(String foodItemTitle) {
	FoodItemTitle = foodItemTitle;
}

public String getFoodItemDescription() {
	return FoodItemDescription;
}

public void setFoodItemDescription(String foodItemDescription) {
	FoodItemDescription = foodItemDescription;
}



}
