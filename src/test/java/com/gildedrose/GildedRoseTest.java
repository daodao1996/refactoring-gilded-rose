package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.gildedrose.items.AgedBire;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Sulfuras;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRoseTest {
    ItemFactory factory = new ItemFactory();

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(Arrays.asList(items));
        app.update_quality();
        assertEquals("foo", app.items.get(0).name);
        assertThat(app.items.get(0).quality, is(4));
        assertThat(app.items.get(0).sellIn, is(0));
    }

  @Test
  public void when_name_is_Aged_Brie() {
    List<Item> items = Arrays.asList(
            factory.getItem("Aged Brie",2, 0),
            factory.getItem("Aged Brie",3, 30),
            factory.getItem("Aged Brie",-1, 30),
            factory.getItem("Aged Brie",-1, 60),
            factory.getItem("Aged Brie",-1, -2),
            factory.getItem("Aged Brie",2, -2)
    );
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    List<Integer> result = gildedRose.items.stream().map(item -> item.quality).collect(Collectors.toList());

    assertThat(result, is(Arrays.asList(1, 31, 32, 60, 0, -1)));
  }

  @Test
  public void when_name_is_5_Dexterity_Vest() {
    List<Item> items = Arrays.asList(
            factory.getItem("+5 Dexterity Vest", 10, 20),
            factory.getItem("+5 Dexterity Vest", -2, 20),
            factory.getItem("+5 Dexterity Vest", -2, 60),
            factory.getItem("+5 Dexterity Vest", -2, -1),
            factory.getItem("+5 Dexterity Vest", 10, -1)
    );
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    List<Integer> result = gildedRose.items.stream().map(item -> item.quality).collect(Collectors.toList());

    assertThat(result, is(Arrays.asList(19, 18, 58, -1, -1)));
  }

  @Test
  public void when_name_is_Elixir_of_the_Mongoose() {
    List<Item> items = Arrays.asList(
            factory.getItem("Elixir of the Mongoose", 10, 20),
            factory.getItem("Elixir of the Mongoose", -2, 20),
            factory.getItem("Elixir of the Mongoose", -2, 60),
            factory.getItem("Elixir of the Mongoose", -2, -1),
            factory.getItem("Elixir of the Mongoose", 10, -1),
            factory.getItem("Elixir of the Mongoose", -1, 1)
    );
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    List<Integer> result = gildedRose.items.stream().map(item -> item.quality).collect(Collectors.toList());

    assertThat(result, is(Arrays.asList(19, 18, 58, -1, -1, 0)));
  }

  @Test
  public void when_name_is_Sulfuras_Hand_of_Ragnaros() {
    List<Item> items = Arrays.asList(
            factory.getItem("Sulfuras, Hand of Ragnaros", 10, 20),
            factory.getItem("Sulfuras, Hand of Ragnaros", -2, 20),
            factory.getItem("Sulfuras, Hand of Ragnaros", -2, 60),
            factory.getItem("Sulfuras, Hand of Ragnaros", -2, -1),
            factory.getItem("Sulfuras, Hand of Ragnaros", 0, 80),
            factory.getItem("Sulfuras, Hand of Ragnaros", -1, 80),
            factory.getItem("Sulfuras, Hand of Ragnaros", 10, -2)
    );

    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    List<Integer> result = gildedRose.items.stream().map(item -> item.quality).collect(Collectors.toList());

    assertThat(result, is(Arrays.asList(20, 20, 60, -1, 80, 80, -2)));
  }

  @Test
  public void when_name_is_Backstage_passes_to_a_TAFKAL80ETC_concert() {
    List<Item> items = Arrays.asList(
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 20, 40),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 20, 60),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 9, 60),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 9, 49),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 3, 60),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 3, 48),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", -1, -2),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", -1, 2),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 11, -1),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 10, -1),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 13, -1),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 9, 48),
            factory.getItem("Backstage passes to a TAFKAL80ETC concert", 3, 47)
    );

    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    List<Integer> result = gildedRose.items.stream().map(item -> item.quality).collect(Collectors.toList());

    assertThat(result, is(Arrays.asList(41, 60, 60, 50, 60, 50, 0, 0, 0, 1, 0, 50, 50)));
  }

  @Test
  public void when_name_is_Conjured_Mana_Cake() {
    List<Item> items = Arrays.asList(
            factory.getItem("Conjured Mana Cake", 10, 20),
            factory.getItem("Conjured Mana Cake", -2, 20),
            factory.getItem("Conjured Mana Cake", -2, 60),
            factory.getItem("Conjured Mana Cake", -2, -1),
            factory.getItem("Conjured Mana Cake", 10, -2)
    );
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.update_quality();
    List<Integer> result = gildedRose.items.stream().map(item -> item.quality).collect(Collectors.toList());

    assertThat(result, is(Arrays.asList(19, 18, 58, -1, -2)));
  }

}
