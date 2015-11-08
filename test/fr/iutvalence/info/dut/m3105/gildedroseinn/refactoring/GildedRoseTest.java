package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest
{
	
	private static final String	AGED_BRIE	= "Aged Brie";
	private static final int	DUMMY_SELL_IN	= 20;
	private static final int	DUMMY_QUALITY	= 10;
	private static final String	DUMMY_NAME	= "a";
	
	ArrayList<Item> dummyItemList;

	@Before
	public void before()
	{
		dummyItemList = new ArrayList<Item>(); 
		dummyItemList.add(new Item(DUMMY_NAME, DUMMY_SELL_IN, DUMMY_QUALITY)); 
		dummyItemList.add(new Item(DUMMY_NAME, DUMMY_SELL_IN, DUMMY_QUALITY)); 
		dummyItemList.add(new Item(DUMMY_NAME, DUMMY_SELL_IN, DUMMY_QUALITY)); 
		dummyItemList.add(new Item(DUMMY_NAME, DUMMY_SELL_IN, DUMMY_QUALITY)); 
		dummyItemList.add(new Item(DUMMY_NAME, DUMMY_SELL_IN, DUMMY_QUALITY)); 

	}
	
	@Test
	public void itemListItemsQualityDecreaseByOneEachDayWith()
	{
		for(int day = 1; day < 6; day ++)
		{
			GildedRose.passADay(dummyItemList);
			
			for(Item dummyItem : dummyItemList)
			{
				assertEquals(DUMMY_QUALITY - day, dummyItem.getQuality());
				assertEquals(DUMMY_NAME, dummyItem.getName());
				assertEquals(DUMMY_SELL_IN - day, dummyItem.getSellIn());
			}
		}
	}

	@Test
	public void qualityLowerTwiceAsFastWhenSellInIsPassed()
	{
		for(Item dummyItem : dummyItemList)
		{
			dummyItem.setSellIn(0);
		}
		
		for(int day = 1; day < 6; day ++)
		{
			GildedRose.passADay(dummyItemList);
			
			for(Item dummyItem : dummyItemList)
			{
				assertEquals(DUMMY_QUALITY - 2 * day, dummyItem.getQuality());
				assertEquals(DUMMY_NAME, dummyItem.getName());
				assertEquals(-day, dummyItem.getSellIn());
			}
		}
	}
	
	@Test
	public void qualityNeverNegative()
	{
		for(Item dummyItem : dummyItemList)
		{
			dummyItem.setSellIn(0);
		}
		
		for(int day = 0; day < 10; day ++)
		{
			GildedRose.passADay(dummyItemList);
			
			for(Item dummyItem : dummyItemList)
			{
				assertEquals(dummyItem.getQuality() < 0, false);
			}
		}
	}
	
	@Test
	public void AgedBrieIncreasesInQualityAsOlderItGetsForPositiveSellin()
	{
		for(Item dummyItem : dummyItemList)
		{
			dummyItem.setName(AGED_BRIE);
		}

		for(int day = 1; day < 6; day ++)
		{
			GildedRose.passADay(dummyItemList);
			
			for(Item dummyItem : dummyItemList)
			{
				assertEquals(DUMMY_QUALITY + day, dummyItem.getQuality());
				assertEquals(AGED_BRIE, dummyItem.getName());
				assertEquals(DUMMY_SELL_IN - day, dummyItem.getSellIn());
			}
		}
	}
	
	@Test
	public void AgedBrieIncreasesInQualityTwiceAsFastWhenSellInIsPassed()
	{
		for(Item dummyItem : dummyItemList)
		{
			dummyItem.setName(AGED_BRIE);
			dummyItem.setSellIn(0);
		}

		for(int day = 1; day < 6; day ++)
		{
			GildedRose.passADay(dummyItemList);
			
			for(Item dummyItem : dummyItemList)
			{
				assertEquals(DUMMY_QUALITY + 2 * day, dummyItem.getQuality());
				assertEquals(AGED_BRIE, dummyItem.getName());
				assertEquals(DUMMY_SELL_IN - day, dummyItem.getSellIn());
			}
		}

	}
}
