package prolab;

public class GraphEdge {

    private GraphVertex start;
    private GraphVertex end;

    public GraphEdge(GraphVertex start, GraphVertex end) {
        this.start = start;
        this.end = end;
    }

    public GraphVertex getStart() {
        return start;
    }

    public GraphVertex getEnd() {
        return end;
    }
}
