package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test void
    should_lower_quality_sellIn() {
        Item[] items = new Item[] { new Item("Bread", 20, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        boolean sellInChecker = items[0].sellIn<20;
        assertTrue(sellInChecker);
    }

}
