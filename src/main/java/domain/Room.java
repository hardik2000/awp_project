/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author HARDIK
 */
public class Room{
    private String type;
    private String id;
    private String price;
    private String capacity;
    private String available_rooms;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAvailable_rooms() {
        return available_rooms;
    }

    public void setAvailable_rooms(String available_rooms) {
        this.available_rooms = available_rooms;
    }
    
}
