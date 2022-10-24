package com.luxoft;

import java.util.ArrayList;
import java.util.List;

public class Footprint {
    Node root;

    private static final int THRESHOLD = 3;

    public static Footprint create(int... data) {
        Footprint footprint = new Footprint();
        Node currNode = null;
        for (int i = data.length - 1; i >= 0; i--) {
            currNode = new Node(data[i], currNode);
        }
        footprint.root = currNode;
        return footprint;
    }

    public boolean isClosest(int... fragments) {
        for (Node node : findStartingPoint(fragments[0])) {
            Node currNode = node;
            int index = 0;
            while (currNode != null) {
                int diff = calculateDiff(fragments[index++], currNode.data);
                // fail condition
                if (!isLowerThanThreshold(diff)) {
                    break;
                }
                // success condition
                if (index == fragments.length) {
                    printPath(node, index);
                    return true;
                }
                currNode = currNode.next;
            }
        }
        return false;
    }

    private List<Node> findStartingPoint(int fragment) {
        List<Node> nodes = new ArrayList<>();
        Node currNode = root;
        while (currNode != null) {
            int diff = calculateDiff(fragment, currNode.data);
            if (isLowerThanThreshold(diff)) {
                nodes.add(currNode);
            }
            currNode = currNode.next;
        }
        return nodes;
    }

    private void printPath(Node node, int index) {
        Node temp = node;
        System.out.print("Path : ");
        for (int i = 0; i < index; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private boolean isLowerThanThreshold(int diff) {
        return diff < THRESHOLD;
    }

    private int calculateDiff(int p1, int p2) {
        return Math.abs(p1 - p2);
    }
}
