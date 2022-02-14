package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMaster {
    /*OMGHAI!
        -------- day 0 --------
    name, sellIn, quality
+5 Dexterity Vest, 10, 20
    Aged Brie, 2, 0
    Elixir of the Mongoose, 5, 7
    Sulfuras, Hand of Ragnaros, 0, 80
    Sulfuras, Hand of Ragnaros, -1, 80
    Backstage passes to a TAFKAL80ETC concert, 15, 20
    Backstage passes to a TAFKAL80ETC concert, 10, 49
    Backstage passes to a TAFKAL80ETC concert, 5, 49
    Conjured Mana Cake, 3, 6

        -------- day 1 --------
    name, sellIn, quality
+5 Dexterity Vest, 9, 19
    Aged Brie, 1, 1
    Elixir of the Mongoose, 4, 6
    Sulfuras, Hand of Ragnaros, 0, 80
    Sulfuras, Hand of Ragnaros, -1, 80
    Backstage passes to a TAFKAL80ETC concert, 14, 21
    Backstage passes to a TAFKAL80ETC concert, 9, 50
    Backstage passes to a TAFKAL80ETC concert, 4, 50
    Conjured Mana Cake, 2, 5*/

    @Test void
    acceptance_criteria(){
        String expectedText= "-------- day 0 --------\n" +
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 10, 20\n" +
            "Aged Brie, 2, 0\n" +
            "Elixir of the Mongoose, 5, 7\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 15, 20\n" +
            "Backstage passes to a TAFKAL80ETC concert, 10, 49\n" +
            "Backstage passes to a TAFKAL80ETC concert, 5, 49\n" +
            "Conjured Mana Cake, 3, 6\n"+
            "-------- day 1 --------\n" +
            "name, sellIn, quality\n"+
            "+5 Dexterity Vest, 9, 19\n" +
            "Aged Brie, 1, 1\n" +
            "Elixir of the Mongoose, 4, 6\n" +
            "Sulfuras, Hand of Ragnaros, 0, 80\n" +
            "Sulfuras, Hand of Ragnaros, -1, 80\n" +
            "Backstage passes to a TAFKAL80ETC concert, 14, 21\n" +
            "Backstage passes to a TAFKAL80ETC concert, 9, 50\n" +
            "Backstage passes to a TAFKAL80ETC concert, 4, 50\n" +
            //"Conjured Mana Cake, 2, 4\n";
            "Conjured Mana Cake, 2, 5\n";

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        StringBuilder output = new StringBuilder();
        int days = 2;

        for (int i = 0; i< days; i++){
            output.append("-------- day " + i + " --------\n");
            output.append("name, sellIn, quality\n");
            for (Item item :
                items) {
                output.append(item+"\n");
            }
            app.updateQuality();
        }
        assertEquals(expectedText, output.toString());

    }
}
