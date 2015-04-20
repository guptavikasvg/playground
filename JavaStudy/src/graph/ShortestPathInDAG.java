package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * DP algorithm. Linear algorithm
 */
public class ShortestPathInDAG {
    int src; //index of the initial node
    int nodeCount; //total number of nodes
    ArrayList<List<Integer[]>> adjacencyList; //Integer[0] is nodeNum, Integer[1] is weight

    class Path {
        int parentIndex;
        int shortestPathLen;
    }

    /**
     * @return - shortestPathLength for every node and parent of that path
     */
    public Path[] computeShortestPath( )
    {
        Path[] shortestPath = new Path[nodeCount];
        initialize(shortestPath); //set all path lengths to 0 AND parents.

        int[] nodeOrdering = topologicalSort(adjacencyList);

        for (int nodeNum : nodeOrdering) {
            //for each edge from node
            List<Integer[]> edges = adjacencyList.get(nodeNum);
            //update the edge
            for (Integer[] dst: edges) {
                update(shortestPath, nodeNum, dst[0], dst[1]);
            }
        }

        return shortestPath;
    }

    //TODO
    private int[] topologicalSort(ArrayList<List<Integer[]>> adjacencyList) {
        return null;
    }

    private void initialize(Path[] shortestPath) {
        for (Path path : shortestPath) {
            path.parentIndex = -1;
            path.shortestPathLen = Integer.MAX_VALUE;
        }
        shortestPath[src].shortestPathLen = 0;
        shortestPath[src].parentIndex = -1;
    }

    private void update(Path[] shortestPath, int src, int dst, int edgeWeight) {
        Path path = shortestPath[dst];
        int oldShortestPathLen = path.shortestPathLen;
        int newShortestPathLen = shortestPath[src].shortestPathLen + edgeWeight;

        if (newShortestPathLen < oldShortestPathLen) {
            //update the path and parent of dst
            shortestPath[dst].parentIndex = src;
            shortestPath[dst].shortestPathLen = newShortestPathLen;
        }
    }
}