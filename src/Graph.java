
//Here we are implementing graph data structure with the help of an array of linked list.


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Graph {
    private LinkedList<Integer>[] adj;
    public Graph(int v){
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]= new LinkedList<>();
        }
    }
    public void addEdge(int src,int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }
    public int bfs(int src,int dest){
        int[] parent=new int[adj.length];
        boolean[] vis= new boolean[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        parent[src]=-1;
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==dest) break;
            for(int nebh : adj[cur]){
                if(!vis[nebh]){
                    q.add(nebh);
                    parent[nebh]=cur;
                }
            }
        }
        int cur=dest;
        int dist=0;
        while (parent[cur]!=-1){
            System.out.print(cur+" -> ");
            cur=parent[cur];
            dist++;
        }
        return dist;
    }
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges :");

        int v=sc.nextInt();
        int e=sc.nextInt();
        Graph graph = new Graph(v);
        System.out.println("Input " +e+" edges :");
        for(int i=0;i<e;i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(src, dest);
        }
        graph.bfs(1,5);
    }
}
