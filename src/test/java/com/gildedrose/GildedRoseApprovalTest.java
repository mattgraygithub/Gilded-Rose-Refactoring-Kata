package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseApprovalTest {

    @Test
    public void updateQuality() {

        List<String> namesList = new ArrayList<String>() {{
            add("Aged Brie");
            add("Backstage passes to a TAFKAL80ETC concert");
            add("Sulfuras, Hand of Ragnaros");
        }};

        List<Integer> sellInsList = new ArrayList<>();
        List<Integer> qualitiesList = new ArrayList<>();

        StringBuilder name = new StringBuilder("Item");

        int sellIn = 50;

        for (int i = 0; i < 100; i++) {
            name.append(i);
            namesList.add(name.toString());

            sellInsList.add(sellIn);
            sellIn --;

            qualitiesList.add(i);
            name = new StringBuilder("Item");
        }

        String[] names = new String[namesList.size()];
        names = namesList.toArray(names);

        Integer[] sellIns = new Integer[sellInsList.size()];
        sellIns = sellInsList.toArray(sellIns);

        Integer[] qualities = new Integer[qualitiesList.size()];
        qualities = qualitiesList.toArray(qualities);

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
