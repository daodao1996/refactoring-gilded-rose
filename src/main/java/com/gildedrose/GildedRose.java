package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Stream;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void update_quality() {
    Stream<Item> itemsStream = Arrays.stream(items);
    itemsStream.forEach(item -> {
      if (needUpdateQuality(item)) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (item.quality > 0) {
            item.quality = item.quality - 1;
          }
        } else {
          if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (item.sell_in < 11) {
                if (item.quality < 50) {
                  item.quality = item.quality + 1;
                }
              }

              if (item.sell_in < 6) {
                if (item.quality < 50) {
                  item.quality = item.quality + 1;
                }
              }
            }
          }
        }

        if (item.sell_in < 0) {
          if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (item.quality > 0) {
                item.quality = item.quality - 1;
              }
            } else {
              item.quality = item.quality - item.quality;
            }
          } else {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
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
