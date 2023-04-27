package com.example.olioprojekti;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;


    private Storage() {
    }

    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemonById(int id) {
        for (Lutemon lutemon: lutemons) {
            if (lutemon.getLutemonId() == id) { return lutemons.remove(lutemons.indexOf(lutemon)); }
        }
        return null;
    }


}
