package graph;
public class Main{
    public static void main(String[] args) {

        GraphUsingHashMap gh=new GraphUsingHashMap(7);
        gh.addEdge(1,2,20);
        gh.addEdge(1,4,59);
        gh.addEdge(2,3,12);
        gh.addEdge(2,1,10);
        gh.addEdge(3,4,56);
        gh.addEdge(3,2,76);
        gh.addEdge(4,1,89);
        gh.addEdge(4,3,33);
        gh.addEdge(4,5,30);
        gh.addEdge(5,4,30);
        gh.addEdge(5,4,23);
        gh.addEdge(5,6,23);
        gh.addEdge(5,7,34);
        gh.addEdge(6,5,33);
        gh.addEdge(6,7,90);
        gh.addEdge(7,5,89);
        gh.addEdge(7,6,73);
        gh.display();
        System.out.println("bfs");
        gh.bfs(1);
        System.out.println("bft");
        gh.bft(2);
        System.out.println("dfs");
        gh.dfs(2);
        System.out.print("dft");
        gh.dft(3);
        gh.findAllComponents();
    }

}
