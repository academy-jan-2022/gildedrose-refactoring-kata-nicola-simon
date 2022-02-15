package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {


            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            item.sellIn--;

            if (item.name.equals("Aged Brie")) {
                updateAgedBrieQuality(item);
            }

            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePassQuality(item);
            }

            else {
                updateNormalItemQuality(item);
            }

        }
    }

    private void updateAgedBrieQuality(Item item) {
        item.quality = addQuality(item.quality);

        if ( item.sellIn < 0) {
            item.quality = addQuality(item.quality);
        }
    }

    private void updateBackstagePassQuality(Item item) {
        item.quality = addQuality(item.quality);

        if (item.sellIn < 11) {
              item.quality = addQuality(item.quality);
        }

        if (item.sellIn < 6) {
              item.quality = addQuality(item.quality);
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateNormalItemQuality(Item item) {
        item.quality = reduceQuality(item.quality);

        if (item.sellIn < 0) {
            item.quality = reduceQuality(item.quality);

        }
    }

    private int reduceQuality(int quality) {
        return quality > 0 ? quality-1: quality;
    }

    private int addQuality(int quality) {
        return quality < 50 ? quality + 1: quality;
    }
}
