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
            NewItemStats newStats = getNewStats(item);
            item.sellIn = newStats.getSellIn();
            item.quality = newStats.getQuality();
        }
    }

    private NewItemStats getNewStats(Item item) {
        if (isSulfuras(item)) {
            return new NewItemStats(item.sellIn, item.quality);
        }

        item.sellIn--;

        if (isAgedBrie(item)) {
            return new NewItemStats(item.sellIn, updateAgedBrieQuality(item));
        }

        if (isBackstagePass(item)) {
            return new NewItemStats(item.sellIn, updateBackstagePassQuality(item));
        }

        if (isConjured(item)) {
            // TODO, still mutating input
            item.quality = updateNormalItemQuality(item);
            item.quality = updateNormalItemQuality(item);
            return new NewItemStats(item.sellIn, item.quality);
        }

        return new NewItemStats(item.sellIn, updateNormalItemQuality(item));
    }

    private static class NewItemStats {
        private final int sellIn;
        private final int quality;

        public NewItemStats(int sellIn, int quality) {
            this.sellIn = sellIn;
            this.quality = quality;
        }

        public int getQuality() {
            return quality;
        }

        public int getSellIn() {
            return sellIn;
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
