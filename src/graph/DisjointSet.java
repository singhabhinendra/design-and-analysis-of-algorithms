package graph;
import java.util.HashMap;


    public class DisjointSet {

        public class Node {
            int val;
            Node parent;
            int rank;

            public Node(int val, Node parent, int rank) {
                this.val = val;
                this.parent = parent;
                this.rank = rank;
            }

            public Node() {

            }
        }

        HashMap<Integer, Node> map = new HashMap<>();

        public void creat(int v) {
            Node nn = new Node();
            nn.val = v;
            nn.rank = 0;
            nn.parent = nn;
            map.put(v, nn);
        }

        public int find(int v) {
            Node nn = map.get(v);
            return find(nn).val;
        }

        public Node find(Node nn) {

            if (nn.parent == nn) {
                return nn;
            }

            Node n = find(nn.parent);
            nn.parent = n; // Path Compression
            return n;
        }

        public void union(int v1, int v2) {
            Node n1 = map.get(v1);
            Node n2 = map.get(v2);
            Node re1 = find(n1);
            Node re2 = find(n2);

            if (re1.rank == re2.rank) {
                re1.parent = re2;
                re2.rank = re2.rank + 1;
            } else if (re1.rank > re2.rank) {
                re2.parent = re1;
            } else {
                re1.parent = re2;
            }

        }

    }
