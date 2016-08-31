/**
 * 
 */
package com.fruitshop;

/**
 * @author Pritish
 *
 */
public enum FruitItem {
	
	Apple(10.00),
	Orange(20.00);
	
	private Double price;
	
	FruitItem(Double price){
		this.price=price;
	}
	
	public Double getPrice(){
		return this.price;
	}

}
