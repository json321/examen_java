// Main.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "csv/test1.csv";
        List<LigneCSV> parsedCSV = CSVAnalyseur.analyserCSV(filePath);
        CSVAnalyseur.afficherCSV(parsedCSV);

        String filePath2 = "csv/test2.csv";
        List<LigneCSV> parsedCSV2 = CSVAnalyseur.analyserCSV(filePath2);
        CSVAnalyseur.afficherCSV(parsedCSV2);

        String filePath3 = "csv/test3.csv";
        List<LigneCSV> parsedCSV3 = CSVAnalyseur.analyserCSV(filePath3);
        CSVAnalyseur.afficherCSV(parsedCSV3);

        String filePath4 = "csv/test4.csv";
        List<LigneCSV> parsedCSV4 = CSVAnalyseur.analyserCSV(filePath4);
        CSVAnalyseur.afficherCSV(parsedCSV4);


    }

}
