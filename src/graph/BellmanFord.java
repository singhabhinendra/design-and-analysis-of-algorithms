package graph;
import java.util.*;
public class BellmanFord {
        HashMap<Integer, HashMap<Integer, Integer>> map;

        public BellmanFord(int v) {
            // TODO Auto-generated constructor stub
            this.map = new HashMap<>();
            for (int i = 1; i <= v; i++) {
                map.put(i, new HashMap<>());

            }
        }

        public void addEdge(int v1, int v2, int cost) {

            map.get(v1).put(v2, cost);

        }

        public class EdgePair {

            int e1;
            int e2;
            int cost;

            public EdgePair(int e1, int e2, int cost) {
                // TODO Auto-generated constructor stub
                this.cost = cost;
                this.e1 = e1;
                this.e2 = e2;
            }

            @Override
            public String toString() {
                return e1 + " - " + e2 + "  " + cost;
            }

        }

        public ArrayList<EdgePair> getalledge() {
            ArrayList<EdgePair> list = new ArrayList<>();

            for (int e1 : map.keySet()) {
                for (int e2 : map.get(e1).keySet()) {

                    EdgePair eg = new EdgePair(e1, e2, map.get(e1).get(e2));
                    list.add(eg);

                }

            }
            return list;
        }

        public void Bellmanford() {
            int v = map.size();
            int[] dsu = new int[v + 1];
            for (int i = 2; i <= v; i++) {
                dsu[i] = 1000000;
            }
            ArrayList<EdgePair> list = getalledge();
            for (int i = 1; i <= v; i++) {
                for (EdgePair eg : list) {
                    int e1 = eg.e1;
                    int e2 = eg.e2;
                    int oldcost = dsu[e2];
                    int newcost = dsu[e1] + eg.cost;
                    if(i==v && newcost<oldcost) {
                        System.out.println("Negative Weight Cycle ");
                        return;
                    }
                    if (oldcost > newcost) {
                        dsu[e2] = newcost;
                    }

                }
            }
            for (int i = 1; i < dsu.length; i++) {
                System.out.print(dsu[i] + " ");
            }

        }
        public static void main(String[] args) {
            BellmanFord bfd = new BellmanFord(5);
            bfd.addEdge(1, 2, 8);
            //bfd.addEdge(2, 5, -2);
            bfd.addEdge(2, 5, 2);
            bfd.addEdge(5, 2, 1);
            bfd.addEdge(4, 5, 4);
            bfd.addEdge(3, 4, -3);
            bfd.addEdge(1, 3, 4);
            bfd.addEdge(1, 4, 5);
            bfd.Bellmanford();
        }
}
