package com.gildedrose;

import com.gildedrose.items.AgedBire;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Sulfuras;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println(generateText());
    }

    public static String generateText() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        ItemFactory factory = new ItemFactory();

        printStream.println("OMGHAI!");

        Item[] items = new Item[] {
                factory.getItem("+5 Dexterity Vest", 10, 20), //
                factory.getItem("Aged Brie", 2, 0), //
                factory.getItem("Elixir of the Mongoose", 5, 7), //
                factory.getItem("Sulfuras, Hand of Ragnaros", 0, 80), //
                factory.getItem("Sulfuras, Hand of Ragnaros", -1, 80),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert",15, 20),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert",10, 49),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                factory.getItem("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                factory.getItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(Arrays.asList(items));

        int days = 3;

        for (int i = 0; i < days; i++) {
            printStream.println("-------- day " + i + " --------");
            printStream.println("name, sellIn, quality");
            for (Item item : items) {
                printStream.println(item);
            }
            printStream.println();
            app.update_quality();
        }

        return outputStream.toString();
    }

}
