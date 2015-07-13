import dataAccess.DataLayer;
import dtos.Node;

import java.io.File;
import java.sql.*;
import java.util.List;

public class Main {

    private DataLayer dataLayer;

    public static void main(String[] args) throws SQLException {
        new Main().start(args);
    }

    /**
     * Validate and process the input
     *
     * @param args - command line arguments to the JVM
     */
    private void start(String[] args) throws SQLException {
        if (args.length < 2) {
            printUsage("Number of arguments is less than 2.");
        }

        String operation = args[0];

        if (operation.equalsIgnoreCase("--load") || operation.equalsIgnoreCase("--find")) {
            init();
            if (operation.equalsIgnoreCase("--load")) {
                for (int i = 1; i < args.length; i++) {
                    process(getDirectoryFromPath(args[i]), 0);
                }
            } else {
                search(args[1]);
            }
            exit();
        } else {
            printUsage("Unknown argument " + args[0]);
        }
    }

    private void printUsage(String s) {
        System.out.println("Usage: java className -load/--find PATH1 PATH2 ..");
        System.exit(-1);
    }

    private File getDirectoryFromPath(String path) throws SQLException {
        //find all files/folder in path

        File f = new File(path);
        if (!f.isDirectory()) {
            throw new IllegalArgumentException(f + " is not a directory");
        }
        return f;
    }

    /**
     * This method does not handle links currently.
     */
    void process(File file, long parentId) throws SQLException {
        assert file != null;

        //insert the root
        if (parentId == 0) {
            parentId = dataLayer.insertNode(file.getName(), 0, false);
        }

        //base case of recursion
        if (file.isFile()) {
            dataLayer.insertNode(file.getName(), parentId, true);
        }

        if (file.isDirectory()) {
            long id = dataLayer.insertNode(file.getName(), parentId, false);

            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    process(f, id);
                }
            }
        }
    }

    private void search(String fileName) throws SQLException {
        Iterable<Node> nodes = findAllNodes(fileName);

        for (Node node : nodes) {
            printPathFromRoot(node);
        }
    }

    private void printPathFromRoot(Node node) throws SQLException {
        System.out.println(findParentPath(node).append('/').append(node.getName()).toString());
    }

    private StringBuilder findParentPath(Node node) throws SQLException {
        Node parent = dataLayer.findNodeFromId(node.getParentId());
        if (parent == null) return new StringBuilder(); //TODO what should the initial size of the StringBuilder
        return findParentPath(parent).append('/').append(node.getName());
    }

    //TODO - rename
    private List<Node> findAllNodes(String fileName) throws SQLException {
        return dataLayer.findNode(fileName);
    }

    private void init() throws SQLException{
        dataLayer = new DataLayer();
        dataLayer.initConnection();
    }

    private void exit() {
        dataLayer.closeConnection();
    }

}