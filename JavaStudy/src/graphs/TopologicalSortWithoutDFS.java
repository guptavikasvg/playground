package graphs;

import org.junit.Test;

import java.util.*;

/**
 * Exercise 22.4-5 in Cormen
 */
public class TopologicalSortWithoutDFS {

    /**
     * Returns a list of nodes topologically sorted
     * @param adjacencyList
     * @return
     */
    public static List<String> tSort(Map<String, List<String>> adjacencyList) {
        // Algorithm: Repeatedly find nodes with in-degrees 0, output them
        // remove their outgoing edges

        // First compute the in-degrees
        Map<String, Integer> inDegrees = new HashMap<>();
        for (Map.Entry<String, List<String>> edges : adjacencyList.entrySet()) {
            String node = edges.getKey();
            List<String> neighbors = edges.getValue();

            inDegrees.putIfAbsent(node, 0);
            for (String neighbor : neighbors) {
                inDegrees.putIfAbsent(neighbor, 0);
                inDegrees.put(neighbor, inDegrees.get(neighbor) + 1);
            }
        }

        // Make a Queue
        Queue<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> entry: inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<String> sortedNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            String node = queue.remove();
            sortedNodes.add(node);

            //remove edges
            List<String> neighbors = adjacencyList.get(node);

            if (neighbors == null || neighbors.isEmpty()) continue;
            for (String neighbor : neighbors) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
                if (inDegrees.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sortedNodes;
    }

    @Test
    public void test1() {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("1", Arrays.asList(new String[]{"2", "3"}));
        adjacencyList.put("3", Arrays.asList(new String[]{"2", "4"}));
        adjacencyList.put("4", Arrays.asList(new String[]{"5", "6"}));

        System.out.println(tSort(adjacencyList));
    }

    @Test
    public void test2() {
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("1", Arrays.asList(new String[]{"2"}));
        adjacencyList.put("2", Arrays.asList(new String[]{"3"}));
        adjacencyList.put("3", Arrays.asList(new String[]{"1"}));

        System.out.println(tSort(adjacencyList));
    }

    @Test
    public void test3() {
        Map<String, List<String>> adjacencyList = new HashMap<>();

        System.out.println(tSort(adjacencyList));
    }
}
