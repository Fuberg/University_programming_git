package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {

    private Date dateOfIncome;  // дата производства
    private short expires;      // срок годности

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f ",this.getID(),this.getName(),this.getPrice());
        System.out.printf(", Category: "+ this.getCategory() + " , Date of income: " + dateOfIncome + " , Expires: " + expires + "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FoodItem other = (FoodItem) obj;
        if (this.getID() != other.getID())
            return false;
        if (this.getName() != other.getName())
            return false;
        if (this.getPrice() != other.getPrice())
            return false;
        if (this.getCategory() != other.getCategory())
            return false;
        if (dateOfIncome != other.dateOfIncome)
            return false;
        if (expires != other.expires)
            return false;
        return true;
    }

    @Override
    public Object clone() {
        FoodItem other = new FoodItem(this.getName(), this.getPrice(), null, this.dateOfIncome, this.expires);
//        other.ID = this.ID;
//        other.price = this.price;
//        other.name = this.name;
//        other.category = this.category;
//        other.dateOfIncome = this.dateOfIncome;
//        other.expires = this.expires;
        return other;
    }

    @Override
    public String toString() {
        return this.getID()+" {" +
                "name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", category=" + this.getCategory() +
                ", dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                '}';
    }

    // Лаба 3



    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this.setName(name);
        this.setPrice(price);
        this.setCategory(Category.DRESS);
        this.setID(this.getCurrentID());
        this.dateOfIncome = date;
        this.expires = expires;
        this.setCurrentID(this.getCurrentID() + 1);
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name){
        this(name, 0.00f, null, null, (short) 0);
    }

}
