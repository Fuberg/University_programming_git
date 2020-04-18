package ru.billing.stocklist;

import java.util.ArrayList;
import java.util.HashMap;
import ru.billing.exceptions.ItemAlreadyExistsException;

public class ItemCatalog {

    private HashMap<Integer,GenericItem> catalog = new HashMap<Integer,GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();


    public void addItem(GenericItem item) throws ItemAlreadyExistsException{
        for (GenericItem i : ALCatalog){
            if (i == item){
                throw new ItemAlreadyExistsException();
            }
        }

        catalog.put(item.getID(), item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList

    }

    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id){
        //Если нет такого ID, возвращаем пустое значение
        if(!catalog.containsKey(id)) {
            return null;
        } else{
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : ALCatalog){
            if(i.getID()==id) return i;
        }
        return null;
    }



}
