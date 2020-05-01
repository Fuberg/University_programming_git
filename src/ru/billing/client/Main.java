package ru.billing.client;

import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.billing.stocklist.TechnicalItem;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.exceptions.CatalogLoadException;

import java.util.Date;
import java.lang.String;

public class Main {
    public static void main(String[] args){

        GenericItem first = new GenericItem();
        GenericItem second = new GenericItem();
        GenericItem third = new GenericItem();

//        first.ID = 1;
//        first.name = "table";
//        first.price = 10.15f;
//        first.category = GenericItem.Category.DRESS;
//        first.printAll();

//        second.ID = 2;
//        second.name = "Glass";
//        second.price = 15.23f;
//        second.category = GenericItem.Category.PRINT;
//        second.printAll();

//        third.ID = 3;
//        third.name = "Ship";
//        third.price = 48.50f;
//        second.category = GenericItem.Category.FOOD;
//        third.printAll();


        FoodItem meet = new FoodItem("Meet", 12.12f, (short) 12);
        FoodItem milk = new FoodItem("Milk", 5.25f, (short) 15);
        TechnicalItem iphone = new TechnicalItem();
        TechnicalItem samsung = new TechnicalItem();

//        meet.ID = 11;
//        meet.category = GenericItem.Category.FOOD;
//        meet.dateOfIncome = new Date(2020, 01, 01);

//        milk.ID = 12;
//        milk.category = GenericItem.Category.FOOD;
//        milk.dateOfIncome = new Date(2020, 01,20);

//        iphone.ID = 13;
//        iphone.name = "Iphone";
//        iphone.price = 500.30f;
//        iphone.category = GenericItem.Category.GENERAL;
//        iphone.warrantyTime = 2;

//        samsung.ID = 14;
//        samsung.name = "Samsung";
//        samsung.price = 500.30f;
//        samsung.category = GenericItem.Category.GENERAL;
//        samsung.warrantyTime = 2;

//        GenericItem[] objects_arr = new GenericItem[]{meet,milk,iphone,samsung};
//
//        for (int i = 0; i < 4; i++) {
//            objects_arr[i].printAll();
//        }
//
//        System.out.println("\n");
//
//        boolean eq_ans = iphone.equals(samsung);
//
//        System.out.println(eq_ans);
//
//
//        FoodItem copy_milk = (FoodItem) milk.clone();
//
//        copy_milk.printAll();
//
//        System.out.println(copy_milk.equals(milk));

//        System.out.println(samsung.toString());

        // Лаба 3

        String line = "Конфеты 'Маска';45;120";

        String[] item_fld = new String[3];

        int cont = 0;
        for (String pice : line.split(";")){
            item_fld[cont] = pice;
            cont++;
        }

        FoodItem mask_candy = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        mask_candy.printAll();

        // Лаба 4

        ItemCatalog cat = new ItemCatalog();

        try {
            cat.addItem(new GenericItem("Стол", 112.5f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Стул", 19.5f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Шкаф", 92.9f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Тумбочка", 183.15f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Шахматы", 43.45f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Ноутбук", 36.75f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Телефон", 98.5f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Карандаш", 33.35f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Фонарь", 332.53f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Лампочка", 1002.25f, GenericItem.Category.DRESS));
            cat.addItem(new GenericItem("Лампочка", 1002.25f, GenericItem.Category.DRESS));
        }catch (ItemAlreadyExistsException e){
            e.printStackTrace();
        }

        long begin = new Date().getTime();

        for(int i=0; i<100000;i++)
            cat.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin));
        begin = new Date().getTime();
        for(int i=0; i<100000;i++)
            cat.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));

        CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(cat);
        } catch (CatalogLoadException e){
            e.printStackTrace();
        }

        cat.printItems();

        // Лаба 5

    }
}
