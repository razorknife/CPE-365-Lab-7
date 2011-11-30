/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Louis
 */
public class DBConnection {
   private static Connection conn;

   public static Connection getConnection() {
      try {
         Class.forName("oracle.jdbc.OracleDriver");
      }
      catch (ClassNotFoundException e) {
      }

      if (conn == null) {
         try {
            Scanner s = new Scanner("ServerSettings.txt");
            String con = s.nextLine();
            String user = s.nextLine();
            String pass = s.nextLine();

            conn = DriverManager.getConnection(con, user, pass);
            checkTables();
         }
         catch (Exception e) {
         }

      }
      return conn;
   }

   public static void checkTables() {
      try {
         DatabaseMetaData dbm = conn.getMetaData();
         Statement s = conn.createStatement();
         ResultSet rs = dbm.getTables(null, null, "rooms", null);
         if (rs.next()) {
            System.out.println("Table exists");
         }
         else {
            ResultSet ctr = s.executeQuery("CREATE TABLE rooms (roomid VARCHAR2(3), roomname VARCHAR2(256), beds INT, bedtype VARCHAR2(256), maxoccupancy INT, baseprice INT, decor VARCHAR2(256), PRIMARY KEY(roomid), UNIQUE(roomname));");
         }

         rs = dbm.getTables(null, null, "reservations", null);
         if (rs.next()) {
            System.out.println("Table exists");
         }
         else {
            ResultSet ctr = s.executeQuery("CREATE TABLE reservations (code INT, room VARCHAR2(3) references rooms(roomid), checkin DATE, checkout DATE, rate REAL, lastname VARCHAR2(256), firstname VARCHAR2(256), adults INT, kids INT, PRIMARY KEY(code), UNIQUE(room, checkin));");
         }
      }
      catch (Exception e) {
      }

   }
}
