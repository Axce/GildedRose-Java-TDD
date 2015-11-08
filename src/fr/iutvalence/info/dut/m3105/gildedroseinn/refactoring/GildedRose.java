package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.List;

public class GildedRose
{

	private static final String	AGED_BRIE	= "Aged Brie";

	/*
	 * The code below is intended to help writing test fixtures
	 * 
	 * items = new ArrayList<Item>(); 
	 * items.add(new Item("+5 Dexterity Vest", 10, 20)); 
	 * items.add(new Item("Aged Brie", 2, 0)); 
	 * items.add(new Item("Elixir of the Mongoose", 5, 7)); 
	 * items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80)); 
	 * items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)); 
	 * items.add(new Item("Conjured Mana Cake", 3, 6));
	 */

	public static void passADay(List<Item> items)
	{
		for (int indexInItemList = 0; indexInItemList < items.size(); indexInItemList++)
		{
			if (items.get(indexInItemList).getName() != "Sulfuras, Hand of Ragnaros")
				updateItem(items.get(indexInItemList));
		}
	}

	public static void updateItem(Item item)
	{	
		if (item.getName() == AGED_BRIE)
		{
			updateAgedBrieQuality(item);
		}
		else
		{
			updateDefaultItemQuality(item);
		}
		
		decreaseItemSellIn(item, 1);
	}

	
	/*
	 * DIFFERENT QUALITY UPDATES - BEGIN
	 */
	
	private static void updateDefaultItemQuality(Item item)
	{
		if(item.getSellIn() <= 0)
			decreaseItemQuality(item, 1);
		decreaseItemQuality(item, 1);
	}

	private static void updateAgedBrieQuality(Item item)
	{	
		if(item.getSellIn() <= 0)
			increaseItemQuality(item, 1);
		increaseItemQuality(item, 1);
	}
	
	/*
	 * DIFFERENT QUALITY UPDATES - END
	 */

	private static void decreaseItemQuality(Item item, int decreaseAmount)
	{
		item.setQuality(item.getQuality() - decreaseAmount);
		setItemQualityToNullIfNegative(item);
	}
	
	private static void increaseItemQuality(Item item, int increaseAmount)
	{
		item.setQuality(item.getQuality() + increaseAmount);
		setItemQualityTo50IfGreater(item);
	}

	private static void setItemQualityToNullIfNegative(Item item)
	{
		if (item.getQuality() < 0)
			item.setQuality(0);
	}
	
	private static void setItemQualityTo50IfGreater(Item item)
	{
		if (item.getQuality() > 50)
			item.setQuality(50);
	}

	private static void decreaseItemSellIn(Item item, int decreaseAmount)
	{
		item.setSellIn(item.getSellIn() - decreaseAmount);
	}

	
}
