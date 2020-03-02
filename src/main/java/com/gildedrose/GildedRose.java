package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class GildedRose {
  Item[] items;
  List<String> reduceQuality = Arrays.asList("+5 Dexterity Vest", "Elixir of the Mongoose", "Conjured Mana Cake");

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void update_quality() {
    Stream<Item> itemsStream = Arrays.stream(items);
    itemsStream.forEach(item -> {
      if (needUpdateQuality(item)) {
        switch (item.name){
          case "Aged Brie":
            if(item.quality < 50){
              item.quality += 1;
            }
            if(item.sell_in < 0 && item.quality < 50){
              item.quality += 1;
            }
            break;
          case "Backstage passes to a TAFKAL80ETC concert":
            if(item.quality < 50){
              if(item.sell_in >= 11)
                item.quality += 1;
              if(item.sell_in >= 6 && item.sell_in < 11)
                item.quality += 2;
              if(item.sell_in < 6)
                item.quality += 3;
            }
            if(item.sell_in < 0){
              item.quality = 0;
            }
            break;
          default:
            if(item.quality > 0){
              item.quality -= 1;
            }
            if(item.sell_in < 0 && item.quality > 0){
              item.quality -= 1;
            }
        }
      }
    });
  }

  private boolean needUpdateQuality(Item item) {
    return !item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  public void update_sellIn() {
    Stream<Item> itemsStream = Arrays.stream(items);
    itemsStream.forEach(item -> {
      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sell_in = item.sell_in - 1;
      }
    });
  }
}
