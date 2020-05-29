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
    private String discription;
    private String type;
    private int room_no;
    private int price;
    private int capacity;
    private boolean booked;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String id) {
        this.room_no = room_no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isBooked(){
        return booked;
    }
    
    public void setBooked(boolean booked){
        this.booked = booked;
    }
    
    public Room(int room_no,String type,int capacity,int price,String discription,boolean booked){
        this.booked = booked;
        this.room_no = room_no;
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.discription = discription;
    }
}