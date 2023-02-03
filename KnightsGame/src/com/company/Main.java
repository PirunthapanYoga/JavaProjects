package com.company;
import java.io.IOException;
import java.util.*;
public class Main {

        //All vertics are assigned from 0 to square of board size .
        //Path printing assigned with
        public static int n, v;

        // graph class with add vertices and print vertices
        static class Graph {

            int v;
            LinkedList<Integer> adjList[];

            Graph(int v) {
                this.v = v;

                adjList = new LinkedList[v];

                for (int i = 0; i < v; i++) {
                    adjList[i] = new LinkedList<>();
                }
            }

            private void addEdge(int src, int dest) {
                adjList[src].add(dest);
            }

            private void printGraph() {
                for (int i = 0; i < v; i++) {
                    System.out.println("Adjacency list of vertex " + (i+1));
                    System.out.print("head");
                    for (Integer pCrawl : adjList[i]) {
                        System.out.print(" -> " + (pCrawl+1));
                    }
                    System.out.println("\n");
                }
            }

        }

        //assign vertix of graph node (adjecency list)
        static void assignVertex(Graph graph, int[][] array, int x, int y) {

            if ((y + 2) < n) {
                if ((x - 1) >= 0) {
                    graph.addEdge(array[x][y], array[x - 1][y + 2]);
                }
                if ((x + 1) < n) {
                    graph.addEdge(array[x][y], array[x + 1][y + 2]);
                }
            }

            if ((x - 2) >= 0) {
                if ((y - 1) >= 0) {
                    graph.addEdge(array[x][y], array[x - 2][y - 1]);
                }
                if (y + 1 < n) {
                    graph.addEdge(array[x][y], array[x - 2][y + 1]);
                }
            }

            if ((x + 2) < n) {
                if ((y - 1) >= 0) {
                    graph.addEdge(array[x][y], array[x + 2][y - 1]);
                }
                if ((y + 1) < n) {
                    graph.addEdge(array[x][y], array[x + 2][y + 1]);
                }
            }

            if ((y - 2) >= 0) {
                if ((x - 1) >= 0) {
                    graph.addEdge(array[x][y], array[x - 1][y - 2]);
                }
                if ((x + 1) < n) {
                    graph.addEdge(array[x][y], array[x + 1][y - 2]);
                }
            }

        }

        //assign array for create adjecency list
        static void assignArray(int[][] array) {
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = c;
                    c = c + 1;
                }
            }
        }

        //assign all node vertices
        static void assignAllVertex(Graph graph, int[][] array) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    assignVertex(graph, array, i, j);
                }
            }
        }

        //assign the state table
        static void assignState(boolean[] state) {
            for (boolean x : state) {
                x = false;
            }
        }

        //call for assgnment methods
        static void assignAll(Graph graph, int[][] array, boolean[] state) {
            assignArray(array);
            assignAllVertex(graph, array);
            assignState(state);
        }

        //deepfirst recursive calling method to find path
        static void deepFirst(int i, Graph graph, boolean[] state) {

            Stack s = new Stack();
            int count = 1;
            state[i] = true;
            s.push(i);
            recursiveDFS(count, i, state, s, graph);
        }

        //deepfirst recursive method
        static void recursiveDFS(int count, int i, boolean[] state, Stack s, Graph graph) {
            Iterator<Integer> nextVal = graph.adjList[i].listIterator();            //assignemt of iterator
            Integer next = nextVal.next();                                          //variable of iterator

            for (int x = 0; x < graph.adjList[i].size(); x++) {                     //loop for all directied nodes

                if (count == v) {                                                   //termination on maximum number of moves

                    break;

                } else {

                    if (!state[next]) {                                                                     //check state is false
                        s.push(next);                                                                       //push current node in stak
                        state[next] = true;                                                                 //set state true
                        recursiveDFS(count + 1, next, state.clone(), (Stack) s.clone(), graph);             // recurse next adjecency node with all clone
                        s.pop();                                                                            //remove current node from stack for call next element recursive
                        state[next] = false;                                                                //set state to false

                        if (nextVal.hasNext()) {                                                            //at end node iterator will thorw error so preventation of error
                            next = nextVal.next();
                        }

                    } else {

                        if (nextVal.hasNext()) {
                            next = nextVal.next();                                                          //at end node iterator will thorw error so preventation os error
                        }

                    }
                }
            }

            if (!s.isEmpty()) {
                if (count == v) {                                                   // print only if all moves done otherwise skip
                    printStack(s);
                }
            }
        }

        // Print stack
        static void printStack(Stack s) {              //print a stack need two stacks
            Stack s2 = new Stack();

            while (!s.isEmpty()) {
                s2.push(s.pop());
            }
            while (!s2.isEmpty()) {
                System.out.print(((int) s2.pop() + 1) + "\t");
            }
            System.out.println();
        }

        //main method
        public static void main(String[] args) throws IOException {
            System.out.println("This will print all possible path of knight from selected point");
            System.out.println("larger bordes take much time to execute");
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the boord row size :");
            n = Integer.parseInt(input.nextLine());

            System.out.print("Enter the starting point  : ");
            int x = Integer.parseInt(input.nextLine()) - 1;

            v = n * n;
            Graph graph = new Graph(v);
            int[][] array = new int[n][n];
            boolean[] state = new boolean[v];
            assignAll(graph, array, state);
            graph.printGraph();
            deepFirst(x, graph, state);

        }
    }
