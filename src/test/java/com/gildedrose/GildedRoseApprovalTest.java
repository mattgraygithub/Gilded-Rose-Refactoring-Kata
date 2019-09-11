package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseApprovalTest {

    @Test
    public void updateQuality() {

        String[] names = generateNames();
        Integer[] sellIns = generateSellIns();
        Integer[] qualities = generateQualities();

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

    private String[] generateNames() {
        List<String> namesList = new ArrayList<String>() {{
            add("Aged Brie");
            add("Backstage passes to a TAFKAL80ETC concert");
            add("Sulfuras, Hand of Ragnaros");
        }};

        StringBuilder name = new StringBuilder("Item");
        for (int i = 0; i < 97; i++) {
            name.append(i);
            namesList.add(name.toString());
            name = new StringBuilder("Item");
        }

        String[] names = new String[namesList.size()];
        names = namesList.toArray(names);
        return names;
    }

    private Integer[] generateSellIns() {
        List<Integer> sellInsList = new ArrayList<>();
        for (int i = -50; i < 50; i++) {
            sellInsList.add(i);
        }

        Integer[] sellIns = new Integer[sellInsList.size()];
        sellIns = sellInsList.toArray(sellIns);
        return sellIns;
    }

    private Integer[] generateQualities() {
        List<Integer> qualitiesList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            qualitiesList.add(i);
        }

        Integer[] qualities = new Integer[qualitiesList.size()];
        qualities = qualitiesList.toArray(qualities);
        return qualities;
    }
}
