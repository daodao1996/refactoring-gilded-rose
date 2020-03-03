package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBire extends Item {
  public AgedBire(int sell_in, int quality) {
    super("Aged Brie", sell_in, quality);
  }

  @Override
  protected boolean isAgedBrie() {
    return true;
  }
}
