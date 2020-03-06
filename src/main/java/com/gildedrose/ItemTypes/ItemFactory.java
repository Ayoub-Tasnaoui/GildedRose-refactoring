package com.gildedrose.ItemTypes;

import com.gildedrose.Item;

public class ItemFactory {
    //all for the sake of the goblin not unleashing his one shot attack on me

    //use nstance of the new items that implements Stockbehavior as instance of the interface
    public StockBehavior createBehaviorByItem(Item item){

        String name = item.name;
        if (name.equals("Aged Brie")){
            return new AgedBrieItem(item);
        }else if (name.equals("Sulfuras, Hand of Ragnaros")){
            return new SulfurasItem(item);
        }else if (name.equals("Backstage passes to a TAFKAL80ETC concert")){
            return new BackstagePasseItem(item);
        } else if (name.equals("Conjured Mana Cake")){
            return new ConjuredItem(item);
        }
        return new NormalItem(item);
    }
}
