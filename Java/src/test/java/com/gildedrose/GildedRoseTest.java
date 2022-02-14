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
        assertEquals(28, items[0].quality);
    }

    @Test void
    should_increase_quality_x2_given_backstage_pass_with_less_than_10_days_to_sell(){
        Item[] items = new Item[]{
            new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                10,
                30
            )
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, items[0].quality);
    }



}
