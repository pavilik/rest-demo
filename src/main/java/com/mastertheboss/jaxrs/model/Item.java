package com.mastertheboss.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Item {
    private String description;
    private int price;


//	public Item(String description, int price) {
//		this.description = description;
//		this.price = price;
//	}

    public static class ItemBuilder {
        private Item newItem;

        public ItemBuilder() {
            newItem = new Item();
        }

        public ItemBuilder description(String description) {
            newItem.description = description;
            return this;
        }
		public ItemBuilder price(int price) {
			newItem.price = price;
			return this;
		}
		public Item buildItem(){
        	return newItem;
		}
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}