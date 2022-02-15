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

            if (isSulfuras(item)) {
                continue;
            }

            item.sellIn--;

            if (isAgedBrie(item)) {
                updateAgedBrieQuality(item);
                continue;
            }

            if (isBackstagePass(item)) {
                updateBackstagePassQuality(item);
                continue;
            }

            if (isConjured(item)) {
                updateNormalItemQuality(item);
            }

            updateNormalItemQuality(item);
        }
    }

    private boolean isConjured(Item item) {
        return item.name.contains("Conjured");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
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
