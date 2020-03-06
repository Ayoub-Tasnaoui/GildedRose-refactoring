package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class SulfurasItem implements StockBehavior {

    private final Item item;

    public SulfurasItem(Item item) {
        this.item = item;
    }

    @Override
    public void resolvePassedDaySellIn() {
        // nothing to do
    	
    }

    @Override
    public void resolvePassedDayQuality() {
        //nothing to do its indeed legendary
    }

    @Override
    public void resolveDay(){
        //nothing to do
    }
}
