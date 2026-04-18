public class Article {
    private String codeBarre;
    private String nom;
    private double prix;

    public Article(String codeBarre, String nom, double prix) {
        this.codeBarre = codeBarre;
        this.nom = nom;
        this.prix = prix;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return nom + " " + String.format("%.2f €", prix);
    }
}