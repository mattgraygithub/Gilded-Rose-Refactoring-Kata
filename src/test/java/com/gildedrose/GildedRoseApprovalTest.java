package com.gildedrose;

import org.junit.Test;

import org.approvaltests.combinations.CombinationApprovals;

public class GildedRoseApprovalTest {

    @Test
    public void updateQuality() {

        String[] names = new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        Integer[] sellIns = new Integer[]{-10, -1, 0, 1, 3, 6, 11};
        Integer[] qualities = new Integer[]{0, 1, 30, 49, 50};

        CombinationApprovals.verifyAllCombinations(
                this::doUpdateQuality,
                names,
                sellIns,
                qualities);
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
