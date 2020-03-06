package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class NormalItem implements StockBehavior {


    private final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public void resolvePassedDaySellIn() {
        this.item.sellIn--;
    }

    @Override
    public void resolvePassedDayQuality() {
        if (this.item.quality>0){
            this.item.quality--;
        }
        if(this.item.sellIn <0  && this.item.quality>0){
            this.item.quality--;
        }
    }

    @Override
    public void resolveDay(){
        this.resolvePassedDaySellIn();
        this.resolvePassedDayQuality();
    }
}
