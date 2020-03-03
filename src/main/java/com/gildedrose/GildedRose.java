package com.gildedrose;

import java.util.List;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void update_quality() {
        items.forEach(Item::updateQualityAndSellIn);
    }

}
