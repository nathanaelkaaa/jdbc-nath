package fr.epsi.b32223g1.test;

import fr.epsi.b32223g1.bo.Article;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.FournisseurJDBCDAO;

import java.sql.SQLException;

public class TestJdbcArticles {
    private final FournisseurJDBCDAO fournisseurJDBCDAO;
    private final ArticleJDBCDAO articleJDBCDAO;

    public TestJdbcArticles(FournisseurJDBCDAO fournisseurJDBCDAO, ArticleJDBCDAO articleJDBCDAO) {
        this.fournisseurJDBCDAO = fournisseurJDBCDAO;
        this.articleJDBCDAO = articleJDBCDAO;
    }

    public void insert() throws SQLException {
        // inserts
        Fournisseur fournisseur = new Fournisseur("Textile Production");
        this.fournisseurJDBCDAO.insert(fournisseur);
        fournisseur = this.fournisseurJDBCDAO.findAll().get(0);

        Article article1 = new Article("T shirt 180g", 10.00, fournisseur);
        this.articleJDBCDAO.insert(article1);

        Article article2 = new Article("T shirt 150g", 9.50, fournisseur);
        this.articleJDBCDAO.insert(article2);

        Article article3 = new Article("T shirt noir 100g", 9.00, fournisseur);
        this.articleJDBCDAO.insert(article3);

        Article article4 = new Article("T shirt noir 150g", 10.50, fournisseur);
        this.articleJDBCDAO.insert(article4);




        for (Article article : this.articleJDBCDAO.findAll()) { //Supprimer un article
            articleJDBCDAO.delete(article.getId());
        }
        for (Fournisseur article : this.fournisseurJDBCDAO.findAll()) {
            fournisseurJDBCDAO.deleteById(article.getId());
        }


        for (Article article : this.articleJDBCDAO.findAll()) { //Modifier un article
            this.articleJDBCDAO.update(article , new Article(article.getnom(), article.getprix()*0.75, article.getFournisseur()));
        }

        for (Article article : this.articleJDBCDAO.findAll()) {
            System.out.printf("%s; %f; %s%n", article.getnom(), article.getprix(), article.getFournisseur().getName());
        }

        System.out.println(this.articleJDBCDAO.moyenne()); //Avoir la moyenne

        for (Article article : this.articleJDBCDAO.findAll()) { //Avoir la moyenne
            articleJDBCDAO.delete(article.getId());
        }
        for (Fournisseur f : this.fournisseurJDBCDAO.findAll()) {
            fournisseurJDBCDAO.deleteById(f.getId());
        }



    }
}
