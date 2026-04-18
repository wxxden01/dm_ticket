import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Caisse {
    public static void main(String[] args) {
        Magasin magasin = new Magasin("Chez Rudy", "123 Rue du Tasty Crousty");
        Scanner scanner = new Scanner(System.in);

        // catalogue  en dur
        Map<String, Article> catalogue = new HashMap<>();
        catalogue.put("3123123123789", new Article("3123123123789", "Gateau sec bio", 1.20));
        catalogue.put("3123123123111", new Article("3123123123111", "Chocolat", 1.90));
        catalogue.put("1", new Article("1", "Samsung SSD 870 EVO MZ-77E2T0B", 307.99));
        catalogue.put("2", new Article("2", "Seagate BarraCuda 1 To", 110));
        catalogue.put("3", new Article("3", "AMD Ryzen 3 4100 Wraith Stealth (3.8 GHz / 4.0 GHz)", 67.95));
        catalogue.put("4", new Article("4", "AMD Ryzen 9 7900 Wraith Prism (3.7 GHz / 5.4 GHz)", 359.95));
        catalogue.put("5", new Article("5", "AMD Ryzen 7 9850X3D (4.7 GHz / 5.6 GHz)", 550));
        catalogue.put("6", new Article("6", "Intel Core Ultra 7 270K Plus (3.7 GHz / 5.5 GHz)", 358.95));
        catalogue.put("7", new Article("7", "Intel Core i9-14900K (3.2 GHz / 5.8 GHz)", 599.95));
        catalogue.put("8", new Article("8", "Intel Core i7-13700F (2.1 GHz / 5.2 GHz)", 350));
        catalogue.put("9", new Article("9", "Intel Core i3-12100F (3.3 GHz / 4.3 GHz)", 88));
        catalogue.put("10", new Article("10", "Textorm 16 Go DDR4 3200 MHz CL16", 159.95));
        catalogue.put("11", new Article("11", "Kingston ValueRAM 16 Go DDR5 5600 MHz CL46 1Rx8", 340));


        while (true) {
            Ticket ticket = new Ticket(magasin);

            System.out.println("Merci de saisir un article :");
            String saisie = scanner.nextLine();

            while (!saisie.equals("*")) {
                Article article = catalogue.get(saisie);

                if (article != null) {
                    ticket.ajouterArticle(article);
                } else {
                    System.out.println("Article inconnu !");
                }

                System.out.println("Article suivant :");
                saisie = scanner.nextLine();
            }
            

            ticket.afficherTicket();

            System.out.println("**************************************");
            System.out.println("********** CLIENT SUIVANT ************");
            System.out.println("**************************************");
        }

    }

}