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

        // TODO, still mutating input
        item.sellIn--;

        if (isAgedBrie(item)) {
            return new NewItemStats(item.sellIn, updateAgedBrieQuality(item.sellIn, item.quality));
        }

        if (isBackstagePass(item)) {
            return new NewItemStats(item.sellIn, updateBackstagePassQuality(item.sellIn, item.quality));
        }

        if (isConjured(item)) {
            return new NewItemStats(item.sellIn, updateNormalItemQuality(item.sellIn, item.quality, 2));
        }

        return new NewItemStats(item.sellIn, updateNormalItemQuality(item.sellIn, item.quality, 1));
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

    private int updateAgedBrieQuality(int sellIn, int quality) {
        if (sellIn < 0) {
            return addQuality(addQuality(quality));
        }

        return addQuality(quality);
    }

    private int updateBackstagePassQuality(int sellIn, int quality) {
        if (sellIn < 0) {
            return MIN_QUALITY;
        }
        if (sellIn <= 5) {
            return addQuality(addQuality(addQuality(quality)));
        }
        if (sellIn <= 10) {
            return addQuality(addQuality(quality));
        }
        return addQuality(quality);
    }

    private int updateNormalItemQuality(int sellIn, int quality, int times) {
        int newQuality = reduceQuality(quality);
        if (sellIn < 0) {
            newQuality = reduceQuality(newQuality);
        }
        if (times > 1)
            return updateNormalItemQuality(sellIn, newQuality, times - 1);

        return newQuality;
    }

    private int reduceQuality(int quality) {
        return quality > MIN_QUALITY ? quality-1: quality;
    }

    private int addQuality(int quality) {
        return quality < MAX_QUALITY ? quality + 1: quality;
    }

}
