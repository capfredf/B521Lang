package org.yahw;

import javafx.util.Pair;

import java.util.ArrayList;

public class Env {
    private ArrayList<Pair<String, Value>> storage;
    public Env() {
        storage = new ArrayList<Pair<String, Value>>();
    }

    public Env(ArrayList<Pair<String, Value>> s) {
        storage = s;
    }
    public Env extend(String var, Value val) {
        ArrayList<Pair<String, Value>> newStorage = (ArrayList<Pair<String, Value>>) storage.clone();
        Pair<String, Value> p = new Pair<String, Value>(var, val);
        newStorage.add(p);
        Env newEnv = new Env(newStorage);
        return newEnv;
    }

    public Value lookUp(String var) {
        for (Pair<String, Value> temp : storage) {
            if (temp.getKey() == var) {
                return temp.getValue();
            }
        }
        throw new IllegalArgumentException(String.format("identifier %s is not bound", var));
    }
}
