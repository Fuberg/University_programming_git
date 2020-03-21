package ru.billing.stocklist;

public class GenericItem {

    public enum Category { FOOD, PRINT, DRESS, GENERAL }

    private int ID;
    private String name;
    private float price;
    private Category category = Category.GENERAL;
    private static int currentID = 0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f ",ID,name,price);
        System.out.printf(", Category: "+ category + "\n");
    }

//    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericItem other = (GenericItem) obj;
        if (ID != other.ID)
            return false;
        if (name != other.name)
            return false;
        if (price != other.price)
            return false;
        if (category != other.category)
            return false;
        return true;
    }

//    @Override
    public Object clone() {
        GenericItem other = new GenericItem();
        other.ID = this.ID;
        other.name = this.name;
        other.price = this.price;
        other.category = this.category;
        return other;
    }

//    @Override
    public String toString() {
        return this.ID+" {" +
                "name=" + name +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    // Лаба 3

    public GenericItem (String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ID = currentID;
        currentID++;
    }

    public GenericItem (String name, float price, GenericItem analog) {
        this.name = name;
        this.price = price;
        this.category = Category.GENERAL;
        this.ID = currentID;
        currentID++;
    }

    public GenericItem () {
        this.name = "Default name";
        this.price = 0.00f;
        this.ID = currentID;
        this.category = Category.GENERAL;
        currentID++;
    }

}
