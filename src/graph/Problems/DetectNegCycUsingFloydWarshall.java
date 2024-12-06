package graph.Problems;


import static graph.FloydWarshallAlgorithm.INF;

class DetectNegCycUsingFloydWarshall {
    public static void main(String[] args){

    /* Let us create the following weighted graph
                1
        (0)----------->(1)
        /|\               |
         |               |
      -1 |               | -1
         |                \|/
        (3)<-----------(2)*/

        int graph[][] = { {0, 1, INF, INF},
                {INF, 0, -1, INF},
                {INF, INF, 0, -1},
                {-1, INF, INF, 0}};

        if (negCyclefloydWarshall(graph))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
        static final int V=4;
        static final int INF = 99999;
    private static boolean negCyclefloydWarshall(int[][] graph) {
        /*dist[][] will be the output matrix that will finally have the shortest
         * distance between every pari of vertices.*/
        int dist[][]=new int[V][V],i,j,k;
        /*Initialize the Solution matrix same as input graph matrix.Or we can say the
         * Initial values of shortest distances are based on shortest paths considering
         * no intermediate vertex*/
        for(i=0;i<V;i++){
            for(j=0;j<V;j++){
                dist[i][j]=graph[i][j];
            }
        }
        /*Add all vertices  one by one to the set of intermediate vertices.
         * --> Before start of a literaion, we haveshortest distances between all pairs of
         * vertices such that the shortest distances consider only the vertices in set {0,1,2,k-1} as
         * intermediate vertices.
         * --> After the end ofa iteration,vertex no. k is added to the set of intermediate vertices and
         * the set becomes{0,1,2,k}*/
        for( k=0;k<V;k++){
//            Pick all vertices as source one by one
            for(i=0;i<V;i++){
//                Pick all vertices as destination for the
//                above picked source
                for(j=0;j<V;j++){
//                    If vertex k is on the shortest path from
//                    i to j, then update the value of dist[i][j]
                    if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }

                }
            }
        }
//        If distance of any vertex from itself
//        becomes negative, the there is a negative
//        weight cycle.
        for(i=0;i<V;i++){
            if(dist[i] [i]<0){
                return true;
            }
        }
        return false;
    }
}

