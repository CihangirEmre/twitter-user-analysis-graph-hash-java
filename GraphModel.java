package prolab;

import java.util.ArrayList;

public class GraphModel<T> {
    private ArrayList<GraphVertex> vertices;
    private boolean isDirected;

    public GraphModel(boolean isDirected) {
        this.vertices = new ArrayList<GraphVertex>();
        this.isDirected = isDirected;
    }

    public ArrayList<GraphVertex> getVertices() {
        return vertices;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public GraphVertex addVertex(GraphVertex vertex) {
        this.vertices.add(vertex);
        return vertex;
    }

    public void removeVertex(GraphVertex<T> vertex) {
        GraphVertex<T> vertexToRemove = getVertexbyValue(vertex.getData());
        if (vertexToRemove != null) {
            this.vertices.remove(vertexToRemove);
        }
    }


    public void addEdge(GraphVertex vertex1,GraphVertex vertex2){
        vertex1.addEdgeV(vertex2);
        if (!this.isDirected){
            vertex2.addEdgeV(vertex1);
        }
    }

    public void removeEdge(GraphVertex vertex1,GraphVertex vertex2){
        vertex1.removeEdge(vertex2);
        if (!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    public GraphVertex getVertexbyValue(T data){
        GraphVertex vertex = new GraphVertex(data);
        for(int i=0;i<vertices.size();i++){
            if (vertex.getData() == data){
                return vertex;
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < this.vertices.size(); i++) {
            GraphVertex vertex = this.vertices.get(i);
            vertex.print();
        }
    }

}
