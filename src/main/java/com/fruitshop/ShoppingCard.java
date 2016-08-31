package com.fruitshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCard {

	private DiscountedPrice BuyOneGetOne = (a,b)->(a!=null?(a%2==0? a/2*b : (a-1)/2*b+b):0.0);

	private DiscountedPrice BuyThreeOnPriceOfTwo = (a,b)->(a!=null?(a%3==0? a/3*(2*b) : (a-(a%3))/3*(2*b)+(a%3)*b):0.0);

	public Double chekoutFruitPrice(List<FruitItem> fruitItemList, boolean isDiscount) {
		Map<FruitItem, Long> fruitsCount = new HashMap<>();
		if(fruitItemList !=null){
			fruitsCount = fruitItemList.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()));
		}	
		return !isDiscount? calculateTotalFruitPrice(fruitsCount):calculateTotalDiscountedPrice(fruitsCount);
	}

	private Double calculateTotalFruitPrice (Map<FruitItem, Long> fruitsCount){
		Double  totalCost = 0.0D;

		Map<FruitItem, Double> fruitsTotalCostMap =
				fruitsCount.entrySet().stream()
				.collect(Collectors.toMap(
						e -> e.getKey(),
						e -> e.getValue()*e.getKey().getPrice()
						));

		Set<Entry<FruitItem, Double>> entrySet = fruitsTotalCostMap.entrySet();

		for (Entry<FruitItem, Double> entry : entrySet) {
			totalCost = totalCost+ entry.getValue();
		}
		System.out.println(totalCost);
		return totalCost;

	}

	private Double calculateTotalDiscountedPrice(Map<FruitItem, Long> fruitsCount){

		return BuyOneGetOne.calculateDiscountPrice(fruitsCount.get(FruitItem.Apple), FruitItem.Apple.getPrice())
				+ BuyThreeOnPriceOfTwo.calculateDiscountPrice(fruitsCount.get(FruitItem.Orange), FruitItem.Orange.getPrice());

	}
}


