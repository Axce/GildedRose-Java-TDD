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
			assertEquals("Backstage passes to a TAFKAL80ETC concert", dummyItem.getName());
			assertEquals(15, dummyItem.getSellIn());
			assertEquals(20, dummyItem.getQuality());
	}

	@Test
	public void gettersShouldReturnNewValueOfParameters()
	{
			dummyItem.setName("Jambon");
			assertEquals("Jambon", dummyItem.getName());
			
			dummyItem.setSellIn(4);
			assertEquals(4, dummyItem.getSellIn());
			
			dummyItem.setQuality(8);
			assertEquals(8, dummyItem.getQuality());
	}
	
}
