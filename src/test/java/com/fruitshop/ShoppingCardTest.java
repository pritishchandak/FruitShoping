package com.fruitshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCardTest {

	@InjectMocks
	ShoppingCard shopFruitItem;

	@Test
	public void checkoutFruitPriceShouldReturnZeroWhenListisEmpty() {
		Double actualValue= shopFruitItem.chekoutFruitPrice(new ArrayList<FruitItem>());
		assertEquals(0.0D, actualValue,0.0);
	}
	
	@Test
	public void checkoutFruitPriceShouldReturnZeroWhenListisNull() {
		Double actualValue= shopFruitItem.chekoutFruitPrice(null);
		assertEquals(0.0D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPrice(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Apple,FruitItem.Apple, FruitItem.Orange);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList);
		assertEquals(40.0D, actualValue,0.0);
	}

}
