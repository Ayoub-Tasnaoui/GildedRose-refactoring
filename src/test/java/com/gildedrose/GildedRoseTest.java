package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
		assertEquals(-1, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);

	}

	@Test
	void oneDayPassedNormalItemTes() {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 1, 4) };
		GildedRose app = new GildedRose(items);
		assertEquals("+5 Dexterity Vest, 1, 4", app.items[0].toString());
		app.updateQuality();
		assertEquals("+5 Dexterity Vest, 0, 3", app.items[0].toString());
		app.updateQuality();
		assertEquals("+5 Dexterity Vest, -1, 1", app.items[0].toString());
		app.updateQuality();
		assertEquals("+5 Dexterity Vest, -2, 0", app.items[0].toString());
		app.updateQuality();
		assertEquals("+5 Dexterity Vest, -3, 0", app.items[0].toString());

	}

	@Test
	void oneDayPassedOnAgedBrieTest() {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
		GildedRose app = new GildedRose(items);
		assertEquals("Aged Brie, 2, 0", app.items[0].toString());
		app.updateQuality();
		assertEquals("Aged Brie, 1, 1", app.items[0].toString());
		app.updateQuality();
		assertEquals("Aged Brie, 0, 2", app.items[0].toString());
		app.updateQuality();
		assertEquals("Aged Brie, -1, 4", app.items[0].toString());
		app.updateQuality();
		assertEquals("Aged Brie, -2, 6", app.items[0].toString());
	}

	@Test
	void oneDayPassedOnBackStageTest() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40),
				new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30),
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49) };
		GildedRose app = new GildedRose(items);
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 1, 49", app.items[3].toString());
		app.updateQuality();

		assertEquals("Backstage passes to a TAFKAL80ETC concert, 11, 21", app.items[0].toString());
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 10, 41", app.items[1].toString());
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 5, 32", app.items[2].toString());
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 0, 50", app.items[3].toString());
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 10, 22", app.items[0].toString());
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 9, 43", app.items[1].toString());
		assertEquals("Backstage passes to a TAFKAL80ETC concert, 4, 35", app.items[2].toString());
		assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[3].toString());
	}

	@Test
	public void oneDayPassedSulfurasTest() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80), };
		GildedRose app = new GildedRose(items);
		assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", app.items[0].toString());
		assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", app.items[1].toString());
		app.updateQuality();
		assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", app.items[0].toString());
		assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", app.items[1].toString());
		app.updateQuality();
		assertEquals("Sulfuras, Hand of Ragnaros, 0, 80", app.items[0].toString());
		assertEquals("Sulfuras, Hand of Ragnaros, -1, 80", app.items[1].toString());
	
	}

}
