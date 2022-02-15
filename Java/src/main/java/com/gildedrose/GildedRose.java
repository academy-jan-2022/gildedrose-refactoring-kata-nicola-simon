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
                item.quality = updateAgedBrieQuality(item);
                continue;
            }

            if (isBackstagePass(item)) {
                item.quality = updateBackstagePassQuality(item);
                continue;
            }

            if (isConjured(item)) {
                item.quality = updateNormalItemQuality(item);
                item.quality = updateNormalItemQuality(item);
                continue;
            }

            item.quality =updateNormalItemQuality(item);
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

    private int updateAgedBrieQuality(Item item) {
        if ( item.sellIn < 0) {
            return addQuality(addQuality(item.quality));
        }

        return addQuality(item.quality);
    }

    private int updateBackstagePassQuality(Item item) {
        if (item.sellIn < 0) {
            return MIN_QUALITY;
        }
        if (item.sellIn <= 5) {
            return addQuality(addQuality(addQuality(item.quality)));
        }
        if (item.sellIn <= 10) {
            return addQuality(addQuality(item.quality));
        }
        return addQuality(item.quality);
    }

    private int updateNormalItemQuality(Item item) {

        if (item.sellIn < 0) {
            return reduceQuality(reduceQuality(item.quality));
        }
        return   reduceQuality(item.quality);

    }

    private int reduceQuality(int quality) {
        return quality > MIN_QUALITY ? quality-1: quality;
    }

    private int addQuality(int quality) {
        return quality < MAX_QUALITY ? quality + 1: quality;
    }

}
