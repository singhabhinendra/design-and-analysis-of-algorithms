package graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra {
    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Dijkstra(int v) {
        // TODO Auto-generated constructor stub
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());

        }
    }

    public static void main(String[] args) {
        Dijkstra pa = new Dijkstra(7);
        pa.addEdge(1, 2, 2);
        pa.addEdge(2, 3, 3);
        pa.addEdge(1, 4, 10);
        pa.addEdge(4, 5, 8);
        pa.addEdge(3, 4, 1);
        pa.addEdge(5, 6, 5);
        pa.addEdge(5, 7, 6);
        pa.addEdge(6, 7, 4);
        pa.Dijkstraa();
    }

    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public void Dijkstraa() {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<DijkstraPair> pq = new PriorityQueue<>(new Comparator<DijkstraPair>() {

            @Override
            public int compare(DijkstraPair o1, DijkstraPair o2) {
                // TODO Auto-generated method stub
                return o1.cost - o2.cost;
            }
        });

        DijkstraPair dp = new DijkstraPair(1, "1", 0);
        pq.add(dp);
        while (!pq.isEmpty()) {
            DijkstraPair rp = pq.remove();

            if (visited.contains(rp.vtx)) {
                continue;
            }

            visited.add(rp.vtx);

            System.out.println(rp);
            for (int nbrs : map.get(rp.vtx).keySet()) {
                if (!visited.contains(nbrs)) {
                    DijkstraPair np = new DijkstraPair(nbrs, rp.path + nbrs, rp.cost + map.get(rp.vtx).get(nbrs));
                    pq.add(np);
                }
            }
        }
    }
    private class DijkstraPair {
        int vtx;
        String path;
        int cost;

        public DijkstraPair(int vtx, String path, int cost) {
            // TODO Auto-generated constructor stub
            this.path = path;
            this.cost = cost;
            this.vtx = vtx;
        }

        @Override
        public String toString() {
            return this.vtx + "  " + this.path + "  " + this.cost;
        }

    }

}
