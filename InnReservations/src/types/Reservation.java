/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.util.*;

/**
 * CREATE TABLE reservations (code INT, 
 * room VARCHAR2(3) references rooms(roomid), checkin DATE, 
 * checkout DATE, rate REAL, lastname VARCHAR2(256), 
 * firstname VARCHAR2(256), adults INT, kids INT, 
 * PRIMARY KEY(code), UNIQUE(room, checkin));
 *
 * @author Louis
 */
public class Reservation {
   public int code;
   public String room;
   public Date checkin;
   public Date checkout;
   public double rate;
   public String lastname;
   public String firstname;
   public int adults;
   public int kids;
}
