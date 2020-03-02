package com.gildedrose;

import java.util.List;

class GildedRose {
  List<Item> items;

  public GildedRose(List<Item> items) {
    this.items = items;
  }

  public void update_quality() {
    items.forEach(item -> {
      if (needUpdateQuality(item)) {
        switch (item.name) {
          case "Aged Brie":
            if (lessThanMax(item)) {
              item.quality += 1;
            }
            if (item.sell_in < 0 && lessThanMax(item)) {
              item.quality += 1;
            }
            break;
          case "Backstage passes to a TAFKAL80ETC concert":
            if (lessThanMax(item)){
              item.quality += 1;
            }
            if (item.sell_in < 11 && lessThanMax(item)){
              item.quality += 1;
            }
            if (item.sell_in < 6 && lessThanMax(item)){
              item.quality += 1;
            }
            if (item.sell_in < 0) {
              item.quality = 0;
            }
            break;
          default:
            if (greaterThanMin(item)) {
              item.quality -= 1;
            }
            if (item.sell_in < 0 && greaterThanMin(item)) {
              item.quality -= 1;
            }
        }
      }
    });
  }

  private boolean greaterThanMin(Item item) {
    return item.quality > 0;
  }

  private boolean lessThanMax(Item item) {
    return item.quality < 50;
  }

  private boolean needUpdateQuality(Item item) {
    return !item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  public void update_sellIn() {
    items.forEach(item -> {
      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sell_in = item.sell_in - 1;
      }
    });
  }
}
