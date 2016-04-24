package com.company;

import java.util.ArrayList;

/**
 * Created by siddharthmolleti on 1/10/16.
 */
public class Graph {


    public GraphNode root;
    ArrayList<GraphNode> nodes;
    int[][] adjMatrix;
    boolean isDirected;
    int size;

    public static final int DEFAULT_SIZE = 5;

    public Graph(int data) {
        this(DEFAULT_SIZE, data);
    }

    public Graph(int size, int data) {
        this.root = new GraphNode(data);
        nodes = new ArrayList<GraphNode>();
        nodes.add(root);
        this.size = size;
        adjMatrix = new int[size][size];
    }



    private class GraphNode {

        public int data;
        public State state;

        public GraphNode(int d) {
            this.data = d;
            this.state = State.UnVisited;
        }
    }

    private enum State {
        UnVisited, Visited, Processed;
    }


}
