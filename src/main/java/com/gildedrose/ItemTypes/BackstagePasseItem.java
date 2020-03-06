package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class BackstagePasseItem implements StockBehavior {

    private final Item item;

    public BackstagePasseItem(Item item) {
        this.item = item;
    }

    @Override
    public void resolvePassedDaySellIn() {
        this.item.sellIn--;
    }

    @Override
    public void resolvePassedDayQuality() {
        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        } else {
            if (this.item.quality < 50) {
                this.item.quality = this.item.quality + 1;
            }
            if (this.item.quality < 50 && this.item.sellIn < 10) {
                this.item.quality = this.item.quality + 1;
            }
            if (this.item.quality < 50 && this.item.sellIn < 5) {
                this.item.quality = this.item.quality + 1;
            }
        }

    }

    @Override
    public void resolveDay() {
        this.resolvePassedDaySellIn();
        this.resolvePassedDayQuality();
    }
}
