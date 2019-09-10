package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseShould {

    @Test
    public void decrease_sell_in_date_after_each_day() {

        GildedRose app = doUpdateQuality("An item", 15, 15);

        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void decrease_quality_by_one_each_day() {

        GildedRose app = doUpdateQuality("An item", 10, 12);

        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void decrease_quality_by_two_when_sell_by_date_has_passed() {

        GildedRose app = doUpdateQuality("An item", 0, 10);

        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void keep_decreasing_quality_by_two_when_sell_by_date_has_passed() {

        GildedRose app = doUpdateQuality("An item", 0, 10);
        app.updateQuality();

        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void not_decrease_quality_beyond_zero() {

        GildedRose app = doUpdateQuality("An item", 6, 0);

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void increase_quality_of_aged_brie_by_one_each_day() {

        GildedRose app = doUpdateQuality("Aged Brie", 15, 3);

        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void not_increase_quality_of_aged_brie_to_over_50() {

        GildedRose app = doUpdateQuality("Aged Brie", 15, 50);

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void increase_quality_of_aged_brie_by_2_when_sell_by_date_has_passed() {

        GildedRose app = doUpdateQuality("Aged Brie", 0, 30);

        assertEquals(32, app.items[0].quality);
    }

    @Test
    public void keep_increasing_quality_of_aged_brie_by_2_when_sell_by_date_has_passed() {

        GildedRose app = doUpdateQuality("Aged Brie", 0, 40);
        app.updateQuality();

        assertEquals(44, app.items[0].quality);
    }

    @Test
    public void keep_quality_of_sulfuras_at_80() {

        GildedRose app = doUpdateQuality("Sulfuras, Hand of Ragnaros", 20, 80);

        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void not_change_sell_in_of_sulfuras() {

        GildedRose app = doUpdateQuality("Sulfuras, Hand of Ragnaros",10, 80);

        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    public void increase_quality_of_backstage_passes_by_one_each_day() {

        GildedRose app = doUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 11, 5);

        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void increase_quality_of_backstage_passes_by_two_when_10_days_left() {

        GildedRose app = doUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 10, 10);

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void increase_quality_of_backstage_passes_by_two_when_6_days_left() {

        GildedRose app = doUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 6, 15);

        assertEquals(17, app.items[0].quality);
    }

    @Test
    public void increase_quality_of_backstage_passes_by_three_when_5_days_left() {

        GildedRose app = doUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 5, 12);

        assertEquals(15, app.items[0].quality);
    }

    @Test
    public void increase_quality_of_backstage_passes_by_three_when_1_day_left() {

        GildedRose app = doUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 1, 20);

        assertEquals(23, app.items[0].quality);
    }

    @Test
    public void drop_quality_of_backstage_passes_to_zero_on_day_of_concert() {

        GildedRose app = doUpdateQuality("Backstage passes to a TAFKAL80ETC concert", 0, 30);

        assertEquals(0, app.items[0].quality);
    }

    private GildedRose doUpdateQuality(String item, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(item, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }
}
