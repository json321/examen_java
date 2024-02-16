import java.util.ArrayList;
import java.util.List;

public class Convertisseur {

    public static String secondeEnTemps (int nb) {
        List<String> time = new ArrayList<>();

        for (int i = 0; i < ConstanteTemps.DIVISEURS.length; i++) {
            int quotient = nb / ConstanteTemps.DIVISEURS[i];
            nb %= ConstanteTemps.DIVISEURS[i];

            if (quotient > 0) {
                String unit = ConstanteTemps.UNITES[i] + (quotient > 1 ? "s" : "");
                time.add(quotient + " " + unit);
            }
        }

        if (time.isEmpty()) {
            return "0 secondes";
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < time.size(); i++) {
                if (i == 0) {
                    result.append(time.get(i));
                } else if (i == time.size() - 1) {
                    result.append(" et ").append(time.get(i));
                } else {
                    result.append(", ").append(time.get(i));
                }
            }
            return result.toString();
        }
    }
}
