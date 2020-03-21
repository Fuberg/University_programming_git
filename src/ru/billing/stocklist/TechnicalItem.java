package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {

    private short warrantyTime;     // Гарантийный срок

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f ",this.getID(),this.getName(),this.getPrice());
        System.out.printf(", Category: "+ this.getCategory() + " , Warranty time: " + warrantyTime + "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TechnicalItem other = (TechnicalItem) obj;
        if (this.getID() != other.getID())
            return false;
        if (this.getName() != other.getName())
            return false;
        if (this.getPrice() != other.getPrice())
            return false;
        if (this.getCategory() != other.getCategory())
            return false;
        if (warrantyTime != other.warrantyTime)
            return false;
        return true;
    }

    @Override
    public Object clone() {
        TechnicalItem other = new TechnicalItem();
        other.setID(this.getID());
        other.setName(this.getName());
        other.setPrice(this.getPrice());
        other.setCategory(this.getCategory());
        other.warrantyTime = this.warrantyTime;
        return other;
    }

    @Override
    public String toString() {
        return this.getID()+" {" +
                "name=" + this.getName() +
                ", price=" + this.getPrice() +
                ", category=" + this.getCategory() +
                ", warrantyTime=" + warrantyTime +
                '}';
    }

}
