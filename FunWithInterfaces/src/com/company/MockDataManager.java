package com.company;

public class MockDataManager implements IDataManager {

    @Override
    public void createObject(Object obj) {
        System.out.println("Fake Object data.....");
    }

    @Override
    public Object getObject(int id) {
        return "Fake Object data with id " + id;
    }
}
