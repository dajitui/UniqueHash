package com.example.demo;

/**
 * @author M
 */
public class Obj {
    String key;
    Obj(String key) {
        this.key = key;
    }
    @Override
    public int hashCode() {
        return key.hashCode();
    }
    @Override
    public String toString() {
        return "Obj{" +
                "key='" + key + '\'' +
                '}';
    }
}
