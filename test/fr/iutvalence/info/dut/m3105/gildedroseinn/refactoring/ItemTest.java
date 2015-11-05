package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
	Item dummyItem;
	
	@Before
	public void before()
	{
		dummyItem = (new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)); 	
	}
	
	@Test
	public void gettersShouldReturnConstructorParameters()
	{
			assertEquals(dummyItem.getName(),"Backstage passes to a TAFKAL80ETC concert");
			assertEquals(dummyItem.getSellIn(),15);
			assertEquals(dummyItem.getQuality(),20);
	}

	@Test
	public void gettersShouldReturnNewValueOfParameters()
	{
			dummyItem.setName("Jambon");
			assertEquals(dummyItem.getName(),"Jambon");
			
			dummyItem.setSellIn(4);
			assertEquals(dummyItem.getSellIn(),4);
			
			dummyItem.setQuality(8);
			assertEquals(dummyItem.getQuality(),8);
	}
	
}
