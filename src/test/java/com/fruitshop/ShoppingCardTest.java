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
	public void checkoutFruitPriceShouldReturnZeroWhenListisEmptyAndNoDiscount() {
		Double actualValue= shopFruitItem.chekoutFruitPrice(new ArrayList<FruitItem>(),false);
		assertEquals(0.0D, actualValue,0.0);
	}

	@Test
	public void checkoutFruitPriceShouldReturnZeroWhenListisNullAndNoDiscount() {
		Double actualValue= shopFruitItem.chekoutFruitPrice(null,false);
		assertEquals(0.0D, actualValue,0.0);
	}
	@Test
	public void checkoutFruitPriceShouldReturnZeroWhenListisEmptyAndWithDiscount() {
		Double actualValue= shopFruitItem.chekoutFruitPrice(new ArrayList<FruitItem>(),true);
		assertEquals(0.0D, actualValue,0.0);
	}

	@Test
	public void checkoutFruitPriceShouldReturnZeroWhenListisNullAndWithDiscount() {
		Double actualValue= shopFruitItem.chekoutFruitPrice(null,true);
		assertEquals(0.0D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPrice(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Apple,FruitItem.Apple, FruitItem.Orange,FruitItem.Apple);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,false);
		assertEquals(2.05D, actualValue,0.0);
	}

	@Test
	public void shouldReturnDiscountPriceWhenWithEvenNumberApple(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Apple,FruitItem.Apple, FruitItem.Apple, FruitItem.Apple);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,true);
		assertEquals(1.2D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPriceWithDiscountWhenWithOddNumberApple(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Apple,FruitItem.Apple, FruitItem.Apple);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,true);
		assertEquals(1.2D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPriceWithDiscountWhenWithOneOrange(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Orange);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,true);
		assertEquals(0.25D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPriceWithDiscountWhenWithTwoOrange(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Orange,FruitItem.Orange);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,true);
		assertEquals(0.5D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPriceWithDiscountWhenWithThreeOrange(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Orange,FruitItem.Orange,FruitItem.Orange);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,true);
		assertEquals(0.5D, actualValue,0.0);
	}

	@Test
	public void shouldReturnInPutFruitPriceWithDiscount(){
		List<FruitItem> appleList = Arrays.asList(FruitItem.Apple,FruitItem.Apple, FruitItem.Apple,FruitItem.Orange,FruitItem.Orange,FruitItem.Orange,FruitItem.Orange);
		Double actualValue= shopFruitItem.chekoutFruitPrice(appleList,true);
		assertEquals(1.95D, actualValue,0.0);
	}
}
