
package data;

import java.util.ArrayList;

import domain.Room;

public class Data_Room {
    
    ArrayList<Room> rooms = new ArrayList<Room>();
    
    public Data_Room(){
        rooms.add(new Room(101,"Budget Suite",5,500,"1RK",false));
        rooms.add(new Room(102,"Budget Suite",5,500,"1RK",false));
        rooms.add(new Room(103,"Budget Suite",5,500,"1RK",false));
        
        rooms.add(new Room(201,"Luxury Single Room",5,1000,"1BHK",false));
        rooms.add(new Room(202,"Luxury Single Room",5,1000,"1BHK",false));
        rooms.add(new Room(203,"Luxury Single Room",5,1000,"1BHK",false));
        
        rooms.add(new Room(301,"Luxury Double Suite",5,2000,"2BHK",false));
        rooms.add(new Room(302,"Luxury Double Suite",5,2000,"2BHK",false));
        rooms.add(new Room(303,"Luxury Double Suite",5,2000,"2BHK",false));
    }
}
