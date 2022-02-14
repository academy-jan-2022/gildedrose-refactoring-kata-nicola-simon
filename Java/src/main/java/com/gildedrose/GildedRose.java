package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                || item.name.equals("Sulfuras, Hand of Ragnaros")) {
                addQuality(item);
            }
            else {
                reduceQuality(item);
            }
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn < 11) {
                addQuality(item);
            }
             if (item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn < 0) {
                item.quality = 0;
            }
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;
            }
            if (!item.name.equals("Sulfuras, Hand of Ragnaros") && item.sellIn < 0) {
                reduceQuality(item);
            }
            if (item.name.equals("Aged Brie") && item.sellIn < 0) {
                addQuality(item);
            }


        }
    }

    private void reduceQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void addQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
