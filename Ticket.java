import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ticket {
    private Map<String, LigneTicket> lignes;
    private Magasin magasin;

    public Ticket(Magasin magasin) {
        this.magasin = magasin;
        this.lignes = new HashMap<>();
    }

    public void ajouterArticle(Article article) {
        String code = article.getCodeBarre();

        if (lignes.containsKey(code)) {
            lignes.get(code).incrementerQuantite();
        } else {
            lignes.put(code, new LigneTicket(article));
        }
    }

    public double calculerTotal() {
        double total = 0;
        for (LigneTicket ligne : lignes.values()) {
            total += ligne.getTotalLigne();
        }
        return total;
    }

    public void afficherTicket() {
        System.out.println("----------"+magasin.getNom()+"----------\n"+ magasin.getAdr()+"\n\n");
        System.out.println("Produits:");
        List<LigneTicket> lignesTriees = lignes.values()
        .stream()
        .sorted(Comparator.comparing(l -> l.getArticle().getNom()))
        .collect(Collectors.toList());

        for (LigneTicket ligne : lignesTriees) {
            System.out.println(ligne);
        }

        System.out.println("\n\nTotal: " + String.format("%.2f €", calculerTotal()));
    }
}