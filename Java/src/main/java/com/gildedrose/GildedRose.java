package com.gildedrose;

class GildedRose {
    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
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
                continue;
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePassQuality(item);
                continue;
            }

            if (item.name.contains("Conjured")) {
                updateNormalItemQuality(item);
            }

            updateNormalItemQuality(item);
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

        if (item.sellIn <= 10) {
            item.quality = addQuality(item.quality);
        }

        if (item.sellIn <= 5) {
            item.quality = addQuality(item.quality);
        }

        if (item.sellIn < 0) {
            item.quality = MIN_QUALITY;
        }
    }

    private void updateNormalItemQuality(Item item) {
        item.quality = reduceQuality(item.quality);

        if (item.sellIn < 0) {
            item.quality = reduceQuality(item.quality);
        }
    }

    private int reduceQuality(int quality) {
        return quality > MIN_QUALITY ? quality-1: quality;
    }

    private int addQuality(int quality) {
        return quality < MAX_QUALITY ? quality + 1: quality;
    }

}
