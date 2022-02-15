package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                || item.name.equals("Sulfuras, Hand of Ragnaros")) {

                if (item.name.equals("Aged Brie")) {
                    item.quality = addQuality(item.quality);

                    if ( item.sellIn < 0) {
                        item.quality = addQuality(item.quality);
                    }
                }
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality =addQuality(item.quality);

                    if (item.sellIn < 11) {
                          item.quality =addQuality(item.quality);
                    }

                    if (item.sellIn < 6) {
                          item.quality =addQuality(item.quality);
                    }

                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                }
            }
            else {
                item.quality =reduceQuality(item.quality);
                if (item.sellIn < 0) {
                    item.quality = reduceQuality(item.quality);
                }
            }

        }
    }

    private int reduceQuality(int quality) {
        return quality > 0 ? quality-1: quality;
    }

    private int addQuality(int quality) {
        return quality < 50 ? quality + 1: quality;
    }
}
