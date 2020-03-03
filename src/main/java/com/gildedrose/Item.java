package com.gildedrose;

public class Item {

  public String name;

  public int sell_in;

  public int quality;

  public Item(String name, int sell_in, int quality) {
    this.name = name;
    this.sell_in = sell_in;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sell_in + ", " + this.quality;
  }

  void updateQualityAndSellIn() {
    updateQuality();

    updateSellIn();

    if (isExpire()) {
      updateQualityAfterExpire();
    }
  }

  protected void updateQualityAfterExpire() {
    if (!isBackstage()) {
      if (quality > 0) {
        if (!isSulfuras()) {
          quality = quality - 1;
        }
      }
    } else {
      quality = 0;
    }
  }

  private boolean isExpire() {
    return sell_in < 0;
  }

  private void updateSellIn() {
    if (!isSulfuras()) {
      sell_in = sell_in - 1;
    }
  }

  protected void updateQuality() {
    if (isBackstage()) {
      if (quality < 50) {
        quality = quality + 1;

        if (isBackstage()) {
          if (sell_in < 11) {
            if (quality < 50) {
              quality = quality + 1;
            }
          }

          if (sell_in < 6) {
            if (quality < 50) {
              quality = quality + 1;
            }
          }
        }
      }
    } else {
      if (quality > 0) {
        if (!isSulfuras()) {
          quality = quality - 1;
        }
      }
    }
  }

  private boolean isSulfuras() {
    return name.equals("Sulfuras, Hand of Ragnaros");
  }

  private boolean isBackstage() {
    return name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  protected boolean isAgedBrie() {
    return false;
  }
}
