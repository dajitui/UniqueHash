package com.example.demo;

import com.alibaba.fastjson.JSON;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author M
 */
public class HashTest {

    private static TreeMap<Integer, Node> nodes = new TreeMap<>();

    public static void addNode(Node node) {
        nodes.put(node.hashCode(), node);
    }

    public static void delNode(Node node) {
        nodes.remove(node.hashCode());
    }

    public static void put(Obj obj) {
        int key = obj.hashCode();
        Node node = nodes.get(key);
        if (node != null) {
            node.putObj(obj);
        }

        SortedMap<Integer, Node> sortedMap = nodes.tailMap(obj.hashCode());
        int nodeHashCode = sortedMap.isEmpty() ? nodes.firstKey() : sortedMap.firstKey();
        nodes.get(nodeHashCode).putObj(obj);
    }

    public static Obj get(Obj obj) {
        int key = obj.hashCode();
        Node node = nodes.get(key);
        if (node != null) {
            node.getObj(obj);
        }

        SortedMap<Integer, Node> sortedMap = nodes.tailMap(obj.hashCode());
        int nodeHashCode = sortedMap.isEmpty() ? nodes.firstKey() : sortedMap.firstKey();
        return nodes.get(nodeHashCode).getObj(obj);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addNode(new Node(String.valueOf(i)));
        }
        put(new Obj("-1"));
        put(new Obj("2"));
        put(new Obj("3"));
        put(new Obj("6"));
        put(new Obj("7"));
        put(new Obj("8"));

        System.out.println("------------------------");
        System.out.println(get(new Obj("-1")));
        System.out.println(get(new Obj("2")));
        System.out.println(get(new Obj("3")));
        System.out.println(get(new Obj("6")));
        System.out.println(get(new Obj("7")));
        System.out.println(get(new Obj("8")));
        System.out.println(JSON.toJSON(nodes));
        //delNode(new Node(String.valueOf(0)));
//        delNode(new Node(String.valueOf(1)));
//        delNode(new Node(String.valueOf(2)));
//        delNode(new Node(String.valueOf(3)));
        addNode(new Node(String.valueOf(5)));
        System.out.println(JSON.toJSON(nodes));
        System.out.println("------------------------");
        System.out.println(get(new Obj("-1")));
        System.out.println(get(new Obj("2")));
        System.out.println(get(new Obj("3")));
        System.out.println(get(new Obj("6")));
        System.out.println(get(new Obj("7")));
        System.out.println(get(new Obj("8")));

    }

}
