package com.gildedrose.ItemTypes;

public interface StockBehavior {
    // the behavior of changing the SellIn or Quality by passing a day


    //deal with the update of SellIn behavior for an item
    void resolvePassedDaySellIn();

    //deal with the update of Quality behavior for an item
    void resolvePassedDayQuality();

    // called to update the item accoding to the day
    void resolveDay();
}
