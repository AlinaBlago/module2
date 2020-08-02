import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Parser {
    public static void parse(List<String> list) throws IOException {

        int countOfCity = Integer.parseInt(list.get(0));
        list.remove(0);

        int currentStrIndex = 0;

        List<Vertex> cities = new ArrayList<Vertex>();
        List<TemporaryConnection> tempConnections = new ArrayList<TemporaryConnection>();


        for (int i = 0 ; i < countOfCity ;i++){

            Vertex currentCity = new Vertex(list.get(currentStrIndex));
            currentStrIndex++;

            int countOfEdges = Integer.parseInt(list.get(currentStrIndex));
            currentStrIndex++;

            Edge[] cityEdges = new Edge[countOfEdges];

            for(int currentEdge = 0 ; currentEdge < countOfEdges ; currentEdge++ ){
                String[] currentEdgesInString = list.get(currentStrIndex).split(" ");
                TemporaryConnection tmpConn = new TemporaryConnection(i ,
                        Integer.parseInt(currentEdgesInString[0]) - 1 ,
                        Integer.parseInt(currentEdgesInString[1]));

                tempConnections.add(tmpConn);
                currentStrIndex++;
            }

            cities.add(currentCity);
        }

        Map<Integer, List<TemporaryConnection>> tempConnectionsPerStartIndex = tempConnections.stream()
                .collect(groupingBy(TemporaryConnection::getStartIndexVertex));

        for (Map.Entry<Integer, List<TemporaryConnection>> entry : tempConnectionsPerStartIndex.entrySet()) {
            int currentStartIndex = entry.getKey();
            List<TemporaryConnection> tmpConns = entry.getValue();
            Edge[] currentCityEdges = new Edge[tmpConns.size()];

            for (int i = 0 ; i < tmpConns.size() ; i++){
                currentCityEdges[i] = new Edge(cities.get(tmpConns.get(i).endIndexVertex) , tmpConns.get(i).weight);
            }

            cities.get(currentStartIndex).adjacencies = currentCityEdges;
        }

        int countOfConnections = Integer.parseInt(list.get(currentStrIndex));
        currentStrIndex++;

        String result = "Result: ";
        for (int i = 0 ; i < countOfConnections; i++){
            String[] cityFromCityTo = list.get(currentStrIndex).split(" ");
            currentStrIndex++;


            Vertex cityFrom = cities.stream()
                    .filter(city -> city.name.equals(cityFromCityTo[0]))
                    .findAny()
                    .orElse(null);

            Vertex cityTo = cities.stream()
                    .filter(city -> city.name.equals(cityFromCityTo[1]))
                    .findAny()
                    .orElse(null);


            LevelThreeTask.computePaths(cityFrom);

            result += cityTo.minDistance + "\n";


        }

        File f = new File("output.txt");
        if(!f.exists()){
            f.createNewFile();
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }

        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeChars(result);
        dos.close();
        fos.close();

    }
}
