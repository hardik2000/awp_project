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
public class Record{
    private String username_booked;
    private String number_adults;
    private String number_children;
    private String date_booking;
    private String date_checkout;
    private String room_type;

    public Record(String username_booked, String number_adults, String number_children, String date_booking, String date_checkout, String room_type) {
        this.username_booked = username_booked;
        this.number_adults = number_adults;
        this.number_children = number_children;
        this.date_booking = date_booking;
        this.date_checkout = date_checkout;
        this.room_type = room_type;
    }
    
    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
    public String getUsername_booked() {
        return username_booked;
    }

    public void setUsername_booked(String username_booked) {
        this.username_booked = username_booked;
    }

    public String getNumber_adults() {
        return number_adults;
    }

    public void setNumber_adults(String number_adults) {
        this.number_adults = number_adults;
    }

    public String getNumber_children() {
        return number_children;
    }

    public void setNumber_children(String number_children) {
        this.number_children = number_children;
    }

    public String getDate_booking() {
        return date_booking;
    }

    public void setDate_booking(String date_booking) {
        this.date_booking = date_booking;
    }

    public String getDate_checkout() {
        return date_checkout;
    }

    public void setDate_checkout(String date_checkout) {
        this.date_checkout = date_checkout;
    }
    
}
