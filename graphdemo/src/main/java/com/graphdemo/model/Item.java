package com.graphdemo.model;

public class Item {

    private String name;
    private int value;
    private ItemType itemType;

    public Item(String name, int value, ItemType itemType) {
        this.name = name;
        this.value = value;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
