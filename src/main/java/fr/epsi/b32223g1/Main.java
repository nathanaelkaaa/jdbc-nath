package fr.epsi.b32223g1;
import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.ArticleJDBCDAO;
import fr.epsi.b32223g1.dal.FournisseurJDBCDAO;
import fr.epsi.b32223g1.test.*;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class Main {
    private static final String DB_URL;
    private static final String DB_LOGIN;
    private static final String DB_PWD;

    static {
        System.out.println("Chargement de la classe");
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_LOGIN = bundle.getString("db.login");
        DB_PWD= bundle.getString("db.password");
    }
    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD);
             Statement st = cnx.createStatement();) {

            TestInsertion test1 = new TestInsertion();
            test1.Insert(new Fournisseur("La Maison de la Peinture"));

            TestUpdate test2= new TestUpdate();
            test2.Update(new Fournisseur(1, "La Maison de la Peinture"), new Fournisseur("La Cabane de la Peinture"));

            TestFindAll test3 = new TestFindAll();
            List<Fournisseur> listFournisseurs = test3.FindAll();
            System.out.println(listFournisseurs.size());

            TestDelete test4= new TestDelete();
            test4.Delete(1);

            TestJdbcArticles test = new TestJdbcArticles(new FournisseurJDBCDAO(), new ArticleJDBCDAO());
            test.insert();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Working !🙆‍♂️");
    }
}