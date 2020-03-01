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
        app.update_sellIn();
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

    @Test
    public void when_name_is_Aged_Brie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0),
                new Item("Aged Brie", 3, 30),
                new Item("Aged Brie", -1, 30),
                new Item("Aged Brie", -1, 60),
                new Item("Aged Brie", -1, -2),
                new Item("Aged Brie", 2, -2),
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_quality();

        assertThat(gildedRose.items[0].quality, is(1));
        assertThat(gildedRose.items[1].quality, is(31));
        assertThat(gildedRose.items[2].quality, is(32));
        assertThat(gildedRose.items[3].quality, is(60));
        assertThat(gildedRose.items[4].quality, is(0));
        assertThat(gildedRose.items[5].quality, is(-1));
    }

    @Test
    public void when_name_is_5_Dexterity_Vest() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("+5 Dexterity Vest", -2, 20),
                new Item("+5 Dexterity Vest", -2, 60),
                new Item("+5 Dexterity Vest", -2, -1),
                new Item("+5 Dexterity Vest", 10, -1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_quality();

        assertThat(gildedRose.items[0].quality, is(19));
        assertThat(gildedRose.items[1].quality, is(18));
        assertThat(gildedRose.items[2].quality, is(58));
        assertThat(gildedRose.items[3].quality, is(-1));
        assertThat(gildedRose.items[4].quality, is(-1));
    }

    @Test
    public void when_name_is_Elixir_of_the_Mongoose() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", 10, 20),
                new Item("Elixir of the Mongoose", -2, 20),
                new Item("Elixir of the Mongoose", -2, 60),
                new Item("Elixir of the Mongoose", -2, -1),
                new Item("Elixir of the Mongoose", 10, -1)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_quality();

        assertThat(gildedRose.items[0].quality, is(19));
        assertThat(gildedRose.items[1].quality, is(18));
        assertThat(gildedRose.items[2].quality, is(58));
        assertThat(gildedRose.items[3].quality, is(-1));
        assertThat(gildedRose.items[4].quality, is(-1));
    }

    @Test
    public void when_name_is_Sulfuras_Hand_of_Ragnaros() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 10, 20),
                new Item("Sulfuras, Hand of Ragnaros", -2, 20),
                new Item("Sulfuras, Hand of Ragnaros", -2, 60),
                new Item("Sulfuras, Hand of Ragnaros", -2, -1),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Sulfuras, Hand of Ragnaros", 10, -2)
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_quality();

        assertThat(gildedRose.items[0].quality, is(20));
        assertThat(gildedRose.items[1].quality, is(20));
        assertThat(gildedRose.items[2].quality, is(60));
        assertThat(gildedRose.items[3].quality, is(-1));
        assertThat(gildedRose.items[4].quality, is(80));
        assertThat(gildedRose.items[5].quality, is(80));
        assertThat(gildedRose.items[6].quality, is(-2));
    }

    @Test
    public void when_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 60),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 60),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 60),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, -2),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 2),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, -1),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, -1),
                new Item("Backstage passes to a TAFKAL80ETC concert", 13, -1),
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_quality();

        assertThat(gildedRose.items[0].quality, is(41));
        assertThat(gildedRose.items[1].quality, is(60));
        assertThat(gildedRose.items[2].quality, is(60));
        assertThat(gildedRose.items[3].quality, is(42));
        assertThat(gildedRose.items[4].quality, is(60));
        assertThat(gildedRose.items[5].quality, is(43));
        assertThat(gildedRose.items[6].quality, is(0));
        assertThat(gildedRose.items[7].quality, is(0));
        assertThat(gildedRose.items[8].quality, is(0));
        assertThat(gildedRose.items[9].quality, is(1));
        assertThat(gildedRose.items[10].quality, is(0));
    }

    @Test
    public void when_name_is_Conjured_Mana_Cake() {
        Item[] items = new Item[] {
                new Item("Conjured Mana Cake", 10, 20),
                new Item("Conjured Mana Cake", -2, 20),
                new Item("Conjured Mana Cake", -2, 60),
                new Item("Conjured Mana Cake", -2, -1),
                new Item("Conjured Mana Cake", 10, -2)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.update_quality();

        assertThat(gildedRose.items[0].quality, is(19));
        assertThat(gildedRose.items[1].quality, is(18));
        assertThat(gildedRose.items[2].quality, is(58));
        assertThat(gildedRose.items[3].quality, is(-1));
        assertThat(gildedRose.items[4].quality, is(-2));
    }
}
