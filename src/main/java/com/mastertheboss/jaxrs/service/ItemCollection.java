package com.mastertheboss.jaxrs.service;
import com.mastertheboss.jaxrs.model.Item;
import java.util.HashMap;
import java.util.Map;

public  class  ItemCollection {
   private final Map<String,Item> itemMap = new HashMap<>();




   public Map<String, Item> getItemMap() {
      return this.itemMap;
   }
   public    Item getItem(String key) {
      return itemMap.get(key);
   }

   public void setItemToMap(Item item) {
      itemMap.put(item.getDescription(),item);
   }


}