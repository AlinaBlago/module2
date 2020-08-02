public class TemporaryConnection{
    public int startIndexVertex;
    public int endIndexVertex;
    public int weight;

    public TemporaryConnection(int startIndexVertex , int endIndexVertex , int weight){
        this.startIndexVertex = startIndexVertex;
        this.endIndexVertex = endIndexVertex;
        this.weight = weight;
    }

    public int getStartIndexVertex(){
        return this.startIndexVertex;
    }
}