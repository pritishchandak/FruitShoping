package com.fruitshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCard {

	public Double chekoutFruitPrice(List<FruitItem> fruitItemList) {
		Map<FruitItem, Long> fruitsCount = new HashMap<>();
		if(fruitItemList !=null){
			fruitsCount = fruitItemList.stream().collect(Collectors.groupingBy(f -> f, Collectors.counting()));
		}	
		return calculateTotalFruitPrice(fruitsCount);
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
}


