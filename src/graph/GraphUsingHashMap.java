package graph;
import java.util.*;
public class GraphUsingHashMap {
    static HashMap<Integer, HashMap<Integer, Integer>> graph;
    public GraphUsingHashMap(int noOfVertices) {
        graph = new HashMap<>();
        for (int i = 1; i <=noOfVertices; i++) {
            graph.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int  v2,int w){
        if(!graph.containsKey(v1)&& !graph.containsKey(v2)) {
            graph.put(v1,new HashMap<Integer,Integer>());
            graph.put(v2,new HashMap<Integer,Integer>());
        }
        graph.get(v1).put(v2, w);
        graph.get(v2).put(v1, w);
    }
    public static boolean hashedge(int v1, int v2){
        return graph.get(v1).containsKey(v2);
    }
    public void removeEdge(int V1,int V2){
        if(graph.containsKey(V1)&&graph.containsKey(V2)&&hashedge(V1,V2)) {
            graph.get(V1).remove(V2);
            graph.get(V2).remove(V1);
        }
        System.out.println("Nodes are not available.So,You can't delete any node");
    }
    public static void removeVertex(int v){
        if(graph.containsKey(v)) {
            for (int i:graph.get(v).keySet()) {
                graph.get(i).remove(v);
            }
            graph.remove(v);
        }
    }
    public static int edgeCount(){
        int size=0;
        int count=0;
        for(int k :graph.keySet()) {
            count+=graph.get(k).size();
        }
        return count/2;
    }
//    Find the path between two nodes.
    public static boolean hashPath(int v1,int v2){
        HashSet<Integer> visited= new HashSet<Integer>();
        return hashPath(v1,v2,visited);
    }
    private static boolean hashPath(int v1, int v2, HashSet<Integer> visited){
        if(v1==v2) return true;
        visited.add(v1);
        for (int k:graph.get(v1).keySet()){
            if(!visited.contains(k)) {
                boolean a = hashPath(k, v2, visited);
                if (a) return true;
            }
        }
        visited.remove(v2);
        return false;
    }
//    print all paths of graph
    public void hashAllPath(int v1,int v2){
        HashSet<Integer> visited=new HashSet<Integer>();
        hashAllPath(v1,v2,visited,v1+"");
    }
    private void hashAllPath(int v1,int v2,HashSet<Integer> visited,String ans){
        if(v1==v2){
            System.out.println(ans);
            return;
        }
        visited.add(v1);
        for (int k:graph.get(v1).keySet()){
            if(!visited.contains(k)) {
                hashAllPath(k, v2, visited,ans+k);
            }
        }
        visited.remove(v1);
    }
    public void display(){
        for(int node : graph.keySet()) {
            System.out.println("Node" +node+ "is connected to : "+graph.get(node));
        }
    }
//    bfs for graph
    public void bfs(int v1){
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        q.add(v1);
        while(!q.isEmpty()){
            int u=q.poll();
            if (visited.contains(v1)) {
                continue;
            }
            System.out.println(u);
            visited.add(u);

            for (int k : graph.get(u).keySet()) {
                if(!visited.contains(k)) {
                    q.add(k);
                }
            }

        }

    }
    public void bft(int v1){
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        q.add(v1);
        while(!q.isEmpty()){
            int u=q.poll();
            if (visited.contains(v1)) {
                continue;
            }
            System.out.println(u);
            visited.add(u);

            for (int k : graph.get(u).keySet()) {
                if(!visited.contains(k)) {
                    bfs(k);
                }
            }
        }
    }
    public void findAllComponents(){
        int count=0;
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            if (visited.contains(u)) {
                continue;
            }
            System.out.println(u);
            visited.add(u);
            for (int k : graph.get(u).keySet()) {
                if(!visited.contains(k)) {
                    count++;
                    bfs(k);
                }
            }
        }
        System.out.println(count);
    }
    public boolean cycle(int v1){
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        q.add(v1);
        while(!q.isEmpty()){
            int u=q.poll();
            if (visited.contains(v1)) {
                continue;
            }
            System.out.println(u);
            visited.add(u);

            for (int k : graph.get(u).keySet()) {
                if(!visited.contains(k)) {
                    q.add(k);
                }
            }

        }
        return false;
    }

    public void dfs(int v){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack= new Stack<>();
        stack.push(v);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if (visited.contains(u)) {
                continue;
            }
            System.out.println(u);
            visited.add(u);
            for (int k : graph.get(u).keySet()) {
                if(!visited.contains(k)) {
                    stack.push(k);
                }
            }
        }
    }
    public void dft(int v){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack= new Stack<>();
        stack.push(v);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if (visited.contains(u)) {
                continue;
            }
            System.out.println(u);
            visited.add(u);
            int count=0;

            for (int k : graph.get(u).keySet()) {
                if(!visited.contains(k)) {
                  dfs(k);
                  count++;
                }
            }
            System.out.println("count = " + count);
        }
    }

//    Prim's Algorithm:
    public class Pair {
    int vtx;
    int parent;
    int cost;

    public Pair(int vtx, int parent, int cost) {
        this.vtx = vtx;
        this.parent = parent;
        this.cost = cost;
    }

    public void Prims() {
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();

        // Comparator for Pair to prioritize edges with lower weight
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair O1, Pair O2) -> Integer.compare(O1.cost, O2.cost));

        // Starting with vertex 1, weight 0 (assuming graph is connected and vertex 1 exists)
        Pair pp = new Pair(1, 1, 0); // (current vertex, connected vertex, weight of edge)
        pq.add(pp);

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();

            // If vertex already visited, skip it
            if (visited.contains(rv.vtx)) {
                continue;
            }

            // Add weight to MST cost
            ans += rv.cost;
            visited.add(rv.vtx);

            // Explore neighbors (assuming `graph` is represented as adjacency list)
//            for (int k : pq.get(rv.vtx).keySet()) {
//                Pair np = new Pair(k, rv.vtx, map.get(rv.vtx).get(k));
//                pq.add(np);
//            }
        }

        System.out.println("Minimum Spanning Tree cost: " + ans);
    }
    public class Pair1 {
        int vtx;
        String path;
        int cost;
    }
    public static void MST( ){            //minimum shortest distance using disakshtra algorithm

    }
}
}