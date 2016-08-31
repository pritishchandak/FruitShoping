/**
 * 
 */
package com.fruitshop;

/**
 * @author Pritish
 *
 */
public enum FruitItem {

	Apple(0.60),
	Orange(0.25);

	private Double price;

	FruitItem(Double price){
		this.price=price;
	}

	public Double getPrice(){
		return this.price;
	}

}
