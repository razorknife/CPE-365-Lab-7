/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

/**
 *
 * CREATE TABLE rooms (roomid VARCHAR2(3), roomname VARCHAR2(256),
 * beds INT, bedtype VARCHAR2(256), maxoccupancy INT,
 * baseprice INT, decor VARCHAR2(256), PRIMARY KEY(roomid), UNIQUE(roomname));
 *
 * @author Louis
 */
public class Room {
   public String roomid;
   public String roomname;
   public int beds;
   public String bedtype;
   public int maxoccupancy;
   public int baseprice;
   public String decor;
}
