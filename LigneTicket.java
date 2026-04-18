public class LigneTicket {
    private Article article;
    private int quantite;

    public LigneTicket(Article article) {
        this.article = article;
        this.quantite = 1;
    }

    public void incrementerQuantite() {
        quantite++;
    }

    public double getTotalLigne() {
        return article.getPrix() * quantite;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "\n" + article.getNom() + "\nQte: " + quantite + "\nprix unitaire: " +
               String.format("%.2f €;", article.getPrix()) + " Prix total: " + String.format("%.2f €", getTotalLigne());
    }
}