package graph;

import java.util.*;

public class Prims {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Prims(int v) {
        this.map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Prims pm = new Prims(n);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            pm.AddEdge(v1, v2, cost);
        }
        pm.Prim();
        sc.close();
    }

    public void AddEdge(int v1, int v2, int cost) {

        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public void Prim() {
        int ans = 0;
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair p1, PrimsPair p2) {
                return p1.cost - p2.cost;
            }

        });
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new PrimsPair(1, 1, 0));
        while (!pq.isEmpty()) {
            PrimsPair pp = pq.remove();

            if (visited.contains(pp.vtx)) {
                continue;
            }

            visited.add(pp.vtx);

            System.out.println(pp);
            ans += pp.cost;

            for (int nbrs : map.get(pp.vtx).keySet()) {
                if (!visited.contains(nbrs)) {
                    PrimsPair np = new PrimsPair(nbrs, pp.vtx, map.get(pp.vtx).get(nbrs));
                    pq.add(np);
                }

            }

        }
        System.out.println(ans);

    }

    public class PrimsPair {

        int vtx;
        int acqvtx;
        int cost;

        public PrimsPair(int vtx, int acqvtx, int cost) {
            this.vtx = vtx;
            this.acqvtx = acqvtx;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.vtx + "  " + this.acqvtx + "  " + this.cost;
        }

    }

}

