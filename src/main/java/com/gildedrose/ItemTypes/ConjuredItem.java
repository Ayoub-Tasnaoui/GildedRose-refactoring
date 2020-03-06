package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class ConjuredItem implements StockBehavior {

    private final Item item;

    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void resolvePassedDaySellIn() {
        this.item.sellIn--;
    }

    @Override
    public void resolvePassedDayQuality() {
        if(this.item.sellIn >= 0){
            if (this.item.quality>1){
                this.item.quality = this.item.quality - 2;
            }else if (this.item.quality == 1){
                this.item.quality = 0;
            }
        }else{
            if (this.item.quality>3){
                this.item.quality = this.item.quality - 4;
            }else if (this.item.quality < 3 ){
                this.item.quality = 0;
            }
        }


    }

    @Override
    public void resolveDay(){
        this.resolvePassedDaySellIn();
        this.resolvePassedDayQuality();
    }
}
