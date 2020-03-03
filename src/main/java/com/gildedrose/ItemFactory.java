package com.gildedrose;

import com.gildedrose.items.AgedBire;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Sulfuras;

public class ItemFactory {

  public Item getItem(String itemName, int sellIn, int quality){
    if("Aged Brie".equals(itemName)){
      return new AgedBire(sellIn, quality);
    }
    if("Backstage passes to a TAFKAL80ETC concert".equals(itemName)){
      return new Backstage(sellIn, quality);
    }
    if("Sulfuras, Hand of Ragnaros".equals(itemName)){
      return new Sulfuras(sellIn, quality);
    }

    return new Item(itemName, sellIn, quality);
  }
}
