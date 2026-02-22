package prolab;

import java.util.ArrayList;

public class GraphVertex<T> {
    private T data;
    private ArrayList<GraphEdge> edges;

    public GraphVertex(T data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public T getData() {
        return this.data;
    }

    public ArrayList<GraphEdge> getEdges() {
        return this.edges;
    }

    public void addEdgeV(GraphVertex endVertex){
        this.edges.add(new GraphEdge(this,endVertex));
    }

    public void removeEdge(GraphVertex endVertex) {
        for(int i = 0; i < edges.size(); i++){
            GraphEdge edge = edges.get(i);
            if (edge.getEnd().equals(endVertex)){
                edges.remove(i);
                break;
            }
        }
    }

    public void print() {
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().data + " -->  ";
            }

            message += this.edges.get(i).getEnd().data;

            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }
}





