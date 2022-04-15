import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Convex {

    private final ArrayList<int[]> dataPoints = new ArrayList<>();
    private final static String filePath = "../resources/data_set.txt";

    Convex(){
        this.readPointsFromFile();
    }

    private void readPointsFromFile(){
        // read file and extract points to dataPoints
        File inputFile = new File(Convex.filePath);
        if (inputFile.exists() && inputFile.isFile() && inputFile.canRead()){
            //read
            try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile))){
                String line;
                while ((line = fileReader.readLine()) != null){
                    String[] points = line.split(" ");
                    int[] temp = {Integer.parseInt(points[0]), Integer.parseInt(points[1])};
                    this.dataPoints.add(temp);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Convex();
    }
}
