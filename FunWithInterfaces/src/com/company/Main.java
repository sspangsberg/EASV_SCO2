package com.company;

public class Main {

    public static void main(String[] args) {
        IDataManager data = new DBManager();//new DBManager();
        System.out.println(data.getObject(4));
    }
}
