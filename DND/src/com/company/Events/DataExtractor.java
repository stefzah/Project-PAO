package com.company.Events;

import com.company.Teams.Group;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DataExtractor {

    private static DataExtractor instance = null;

    private ArrayList<String[]> Campaign = new ArrayList<>();
    private String[] Map;
    Connection con;
    Statement dbStmt;

    private DataExtractor() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schema", "root", "localpc");
            dbStmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public int getClassInfo(String class_name, String attr) {

        try {
            ResultSet dbRs = null;
            dbRs = dbStmt.executeQuery("select " + attr + " from classes where Class = " + "'" + class_name + "'");
            dbRs.next();
            return dbRs.getInt(attr);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public String getCompanionInfo(int poz, String attr) {

        try {
            ResultSet dbRs = null;
            dbRs = dbStmt.executeQuery("SELECT * FROM campaign ORDER BY Class LIMIT " + poz + ",1");
            dbRs.next();
            return dbRs.getString(attr);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }

    public void addCompanion(String Name, String Class){
        try {
            dbStmt.execute("INSERT INTO campaign(Name, Class) " +
                    "VALUES ('"+Name+"','"+Class+"')");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void deleteCompanion(int poz){
        try {

            dbStmt.execute("DELETE FROM campaign ORDER BY Class LIMIT 1");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteAllCompanions(){
        try {
            dbStmt.execute("DELETE FROM campaign");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




    public ArrayList<String> getMapInfo() {
        getMapData();
        ArrayList<String> AMap = new ArrayList<>();
        Collections.addAll(AMap, Map);
        return AMap;
    }

    public int getCompanionCount() {
        try {
            ResultSet dbRs = null;
            dbRs = dbStmt.executeQuery("SELECT COUNT(*) FROM campaign");
            dbRs.next();
            return dbRs.getInt("COUNT(*)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    private void getMapData() {
        try {
            ResultSet dbRs = null;
            dbRs = dbStmt.executeQuery("SELECT * FROM map");
            dbRs.next();
            Map = dbRs.getString("Map").split("\\r?\\n");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void loadMapData(Group[][] place) {
        StringBuilder[] map = new StringBuilder[place.length];
        System.out.println(place.length);
        for (int i = 0; i < place.length; i++) {
            map[i] = new StringBuilder();
            for (int j = 0; j < place[i].length; j++) {
                if (place[i][j] == null && (i == 0 || j == 0 || i == place.length - 1 || j == place[i].length - 1)) {
                    map[i].append("#");
                } else if (place[i][j] == null) map[i].append('.');
                else if (place[i][j].getClass().getSimpleName().equals("Mob")) map[i].append('M');
                else if (place[i][j].getClass().getSimpleName().equals("Campaign")) map[i].append('C');
            }
            map[i].append('\n');
        }
        map[place.length - 1].setCharAt(place[0].length - 1, 'T');
        StringBuilder db_map = new StringBuilder();
        for (int i = 0; i < place.length; i++)
            db_map.append(map[i]);

        try {
            dbStmt.execute("UPDATE map set Map = '" + db_map.toString() + "'  where idmap = 1;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public static DataExtractor getInstance() {
        if (instance == null) {
            instance = new DataExtractor();
        }
        return instance;
    }

    public static void main(String[] args) {
        DataExtractor DE = new DataExtractor();
        System.out.println(DE.getClassInfo("Goblin", "Max_hp"));
        System.out.println(DE.getCompanionInfo(0, "Class"));
        System.out.println(DE.getCompanionCount());
       // DE.addCompanion("Augustinian","Warrior");
        DE.deleteCompanion(0);
    }

}
