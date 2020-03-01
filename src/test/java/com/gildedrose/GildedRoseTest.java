package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_sell_in_minus_1_when_all_method_updateSellIn() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_sellIn();
        assertThat(gildedRose.items[0].sell_in, is(9));
        assertThat(gildedRose.items[1].sell_in, is(1));
        assertThat(gildedRose.items[2].sell_in, is(4));
        assertThat(gildedRose.items[3].sell_in, is(-1));
        assertThat(gildedRose.items[4].sell_in, is(4));
        assertThat(gildedRose.items[5].sell_in, is(2));
    }

}
