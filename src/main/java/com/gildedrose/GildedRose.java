package com.gildedrose;

import com.gildedrose.ItemTypes.StockBehavior;
import com.gildedrose.ItemTypes.ItemFactory;

class GildedRose {
    //sos goblin rage don't use List
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // use the factory to get instance of the StockBehavior 
    public StockBehavior itemBehavior(Item item){
        return new ItemFactory().createBehaviorByItem(item);
    }

    public void updateQuality() {
        // resolve day change depending on the instance so the behavior 
        for (Item item : items){
            itemBehavior(item).resolveDay();
        }
    }
}