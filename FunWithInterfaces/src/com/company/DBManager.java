package com.company;

public class DBManager implements IDataManager {

    @Override
    public void createObject(Object obj) {
        System.out.println("Object created...");
    }

    @Override
    public Object getObject(int id) {
        return "Object #" + id;
    }

    /**
     *
     */
    public void setupConnection() {
        //specific to DBManager
        //Not visible in Main
    }

}
