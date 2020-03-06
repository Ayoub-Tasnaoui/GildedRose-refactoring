package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class AgedBrieItem implements StockBehavior {

    // take the item as attribute
    private final Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    // the item don't have a behavior,since they re items but we can use functionalities provided by interface to change the sellIn and Quality
    @Override
    public void resolvePassedDaySellIn() {
        this.item.sellIn--;
    }

    @Override
    public void resolvePassedDayQuality() {
        if (this.item.quality < 50) {
            this.item.quality = this.item.quality + 1;
        }
        if (this.item.quality < 50  && this.item.sellIn < 0) {
            this.item.quality = this.item.quality + 1;
        }


    }

    @Override
    public void resolveDay(){
        this.resolvePassedDaySellIn();
        this.resolvePassedDayQuality();
    }
}
