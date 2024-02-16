import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVAnalyseur {

    public static List<LigneCSV> analyserCSV(String cheminFichier) {
        List<LigneCSV> resultat = new ArrayList<>();
        boolean dansGuillemets = false;
        StringBuilder ligneCourante = new StringBuilder();

        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;

            while ((ligne = lecteur.readLine()) != null) {
                if (compterGuillemets(ligne) % 2 != 0) {
                    dansGuillemets = !dansGuillemets;
                    if (ligneCourante.length() > 0) {
                        ligneCourante.append("\\n").append(ligne);
                    } else {
                        ligneCourante.append(ligne);
                    }
                } else {
                    if (ligneCourante.length() > 0) {
                        String ligneCSV = ligneCourante.toString().replaceAll("\"(?!\\\")", "");
                        resultat.add(new LigneCSV(ligneCSV));
                        ligneCourante.setLength(0);
                    }

                    String ligneCSV = ligne.replaceAll("\"(?!\\\")", "");
                    resultat.add(new LigneCSV(ligneCSV));
                }
            }

            if (ligneCourante.length() > 0) {
                String ligneCSV = ligneCourante.toString().replaceAll("\"(?!\\\")", "");
                resultat.add(new LigneCSV(ligneCSV));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultat;
    }

    private static int compterGuillemets(String ligne) {
        int compteur = 0;
        for (char c : ligne.toCharArray()) {
            if (c == '"') {
                compteur++;
            }
        }
        return compteur;
    }

    public static void afficherCSV(List<LigneCSV> csv) {
        System.out.println(csv);
    }
}
