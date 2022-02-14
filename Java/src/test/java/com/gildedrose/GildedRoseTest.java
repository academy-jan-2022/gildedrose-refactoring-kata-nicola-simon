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
    should_increase_quality_x2_given_backstage_pass_with_less_than_11_days_to_sell(){
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

    @Test void
    should_increase_quality_x3_given_backstage_pass_with_less_than_6_days_to_sell(){
        Item[] items = new Item[]{
            new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                5,
                30
            )
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33, items[0].quality);
    }

    @Test void
    should_drop_quality_of_backstage_pass_to_0_when_sell_by_date_passed(){
        Item[] items = new Item[]{
            new Item(
                "Backstage passes to a TAFKAL80ETC concert",
                0,
                30
            )
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test void
    should_add_to_quality_when_aged_brie_beyond_sell_by_date(){
        Item[] items = new Item[]{
            new Item(
                "Aged Brie",
                0,
                30
            )
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, items[0].quality);
    }

    @Test void
    should_not_add_to_quality_when_quality_is_50(){
        Item[] items = new Item[]{
            new Item(
                "Aged Brie",
                0,
                50
            )
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }


}
