/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.*;
import types.*;

/**
 *
 * @author Louis
 */
public class DBQueries {
   public static boolean checkFull() {
      try {
         boolean ret = false;
         Connection c = DBConnection.getConnection();
         Statement s = c.createStatement();
         ResultSet rs = s.executeQuery("SELECT COUNT(*) FROM rooms");
         if (rs.getInt(1) != 0) {
            ret = true;
         }

         rs = s.executeQuery("SELECT COUNT(*) FROM reservations");
         if (rs.getInt(1) != 0) {
            ret = true;
         }

         return ret;
      }
      catch (Exception e) {
      }
      return false;
   }


   /* ADMIN Queries */
   public ArrayList<Room> admGetAllRoom() {
      ArrayList<Room> ret = new ArrayList<Room>();
      try {
         Connection c = DBConnection.getConnection();
         Statement s = c.createStatement();
         ResultSet rs = s.executeQuery("SELECT * FROM rooms;");
         while (rs.next()) {
            Room r = new Room();
            r.roomid = rs.getString(1);
            r.roomname = rs.getString(2);
            r.beds = rs.getInt(3);
            r.bedtype = rs.getString(4);
            r.maxoccupancy = rs.getInt(5);
            r.baseprice = rs.getInt(6);
            r.decor = rs.getString(7);
            ret.add(r);
         }
      }
      catch (Exception e) {
      }
      return ret;
   }

   public ArrayList<Reservation> admGetAllReservation() {
      ArrayList<Reservation> ret = new ArrayList<Reservation>();
      try {
         Connection c = DBConnection.getConnection();
         Statement s = c.createStatement();
         ResultSet rs = s.executeQuery("SELECT * FROM reservations;");
         while (rs.next()) {
            Reservation r = new Reservation();
            r.code = rs.getInt(1);
            r.room = rs.getString(2);
            r.checkin = rs.getDate(3);
            r.checkout = rs.getDate(4);
            r.rate = rs.getDouble(5);
            r.lastname = rs.getString(6);
            r.firstname = rs.getString(7);
            r.adults = rs.getInt(8);
            r.kids = rs.getInt(9);
            ret.add(r);
         }
      }
      catch (Exception e) {
      }
      return ret;
   }

   public void admClearTables() {
      try {
         Connection c = DBConnection.getConnection();
         Statement s = c.createStatement();
         s.execute("TRUNCATE TABLE rooms;");
         s.execute("TRUNCATE TABLE reservations;");
      }
      catch (Exception e) {
      }
   }

   public void admDropTables() {
      try {
         Connection c = DBConnection.getConnection();
         Statement s = c.createStatement();
         s.execute("DROP TABLE rooms;");
         s.execute("DROP TABLE reservations;");
      }
      catch (Exception e) {
      }
   }


   /* Owner Queries */



}
