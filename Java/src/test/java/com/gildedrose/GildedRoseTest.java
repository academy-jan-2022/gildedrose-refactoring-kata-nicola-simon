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
        boolean sellInChecker = items[0].sellIn == 19;
        assertTrue(sellInChecker);
    }

    @Test void
    should_lower_quality_twice_as_fast_given_sellin_equals_0(){
       Item[] items = new Item[]{
           new Item(
               "Bread",
               0,
               30
           )
       };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        boolean qualityChecker = items[0].sellIn == 18;
    }



}
