package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends Item {
  public Sulfuras(int sell_in, int quality) {
    super("Sulfuras, Hand of Ragnaros", sell_in, quality);
  }

  @Override
  protected void updateSellIn() {
  }

  @Override
  protected void updateQualityAfterExpire() {
  }

  @Override
  protected void updateQuality() {
  }
}
