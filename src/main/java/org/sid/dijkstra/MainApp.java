package org.sid.dijkstra;

import java.util.*;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/BuvKtCh0SKk
     */
    public static void main(String[] args) {

        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");
        Node<String> nodeG = new Node<>("G");

        addAdjacentNode(nodeA, nodeB);
        addAdjacentNode(nodeA, nodeC);
        addAdjacentNode(nodeB, nodeD);
        addAdjacentNode(nodeC, nodeD);

        addAdjacentNode(nodeE, nodeF);
        printConnectionsRecursive(List.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG));

    }

    private static void addAdjacentNode(Node<String> first, Node<String> second) {
        first.addAdjacentNode(second, 1);
        second.addAdjacentNode(first, 1);
    }

    private static void printConnections(List<Node<String>> nodes) {
        Set<Node<String>> visited = new HashSet<>();
        List<Node<String>> unvisited = new LinkedList<>();
        List<Integer> finalList = new ArrayList<>();
        for ( Node<String> node : nodes) {
            int connected = 0;
            if (!visited.contains(node)) {
                unvisited.add(node);
                while (!unvisited.isEmpty()) {
                    var next = unvisited.remove(0);
                    if ( !visited.contains( next)){
                        connected++;
                        for ( var adj : next.getAdjacentNodes()) {
                            if ( !visited.contains(adj)) {
                                unvisited.add(adj);
                            }
                        }
                        visited.add(next);
                    }
                }
            }

            if ( connected != 0) {
                finalList.add(connected);
            }

        }
        System.out.println(finalList);
    }
    private static void printConnectionsRecursive(List<Node<String>> nodes) {
        Set<Node<String>> visited = new HashSet<>();
        List<Integer> finalList = new ArrayList<>();
        for (Node<String> node : nodes) {
            if (!visited.contains(node)) {
                int connected = traverseGraphRecursive(node, visited);
                finalList.add(connected);
            }
        }
        System.out.println(finalList);
    }

    private static int traverseGraphRecursive(Node<String> node, Set<Node<String>> visited) {
        visited.add(node);
        int connected = 1;
        for (var adj : node.getAdjacentNodes()) {
            if (!visited.contains(adj)) {
                connected += traverseGraphRecursive(adj, visited);
            }
        }
        return connected;
    }
}