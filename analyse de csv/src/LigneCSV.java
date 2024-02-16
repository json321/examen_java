import java.util.ArrayList;

// CSVRow.java
public class LigneCSV {
    private ArrayList<String> datas = new ArrayList<String>();

    public LigneCSV(String data) {

        datas.add(data);
    }

    @Override
    public String toString() {
        return "" + datas ;
    }
}
