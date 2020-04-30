package com.company.Events;

import com.company.Teams.Group;

import java.io.*;
import java.util.ArrayList;

public class DataExtractor {

    private static DataExtractor instance = null;
    private ArrayList<String[]> AllClasses = new ArrayList<>();
    private ArrayList<String[]> Campaign = new ArrayList<>();
    private ArrayList<String> Map = new ArrayList<>();

    private DataExtractor() {
        getClassesData();
        getCampaignData();
        if(fileExists("Map.csv"))getMapData();
    }

    public int getClassInfo(String class_name, String attr) {
        int col = 0;
        for (int i = 0; i < AllClasses.get(0).length; i++)
            if (AllClasses.get(0)[i].equals(attr)) {

                col = i;
            }
        for (String[] allClass : AllClasses) {
            if (allClass[0].equals(class_name)) {
                return Integer.parseInt(allClass[col]);
            }
        }
        return -1;
    }

    public String getCompanionInfo(int poz, String attr) {

        if (attr.equals("Name")) return Campaign.get(poz + 1)[0];
        if (attr.equals("Race")) return Campaign.get(poz + 1)[1];
        return "";
    }

    public ArrayList<String> getMapInfo() {
        return Map;
    }

    public int getCompanionCount() {
        return Campaign.size() - 1;
    }

    private void getClassesData() {
        String csvFile = "Classes.csv";
        String line = "";
        String cvsSplitBy = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] class_type = line.split(cvsSplitBy);

                AllClasses.add(class_type);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getCampaignData() {
        String csvFile = "Campaign.csv";
        String line = "";
        String cvsSplitBy = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {


            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] member = line.split(cvsSplitBy);

                Campaign.add(member);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getMapData() {
        String csvFile = "Map.csv";
        String line = "";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                Map.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
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
                }
                else if (place[i][j] == null) map[i].append('.');
                else if (place[i][j].getClass().getSimpleName().equals("Mob")) map[i].append('M');
                else if (place[i][j].getClass().getSimpleName().equals("Campaign")) map[i].append('C');
            }
            map[i].append('\n');
        }
        map[place.length - 1].setCharAt(place[0].length - 1, 'T');
        try {
            FileWriter writer = new FileWriter("Map.csv");
            for (int i = 0; i < place.length; i++)
                writer.write(String.valueOf(map[i]));
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean fileExists(String file) {
        File tmpDir = new File(file);
        return tmpDir.exists();
    }

    public static DataExtractor getInstance() {
        if (instance == null) {
            instance = new DataExtractor();
        }
        return instance;
    }

}
