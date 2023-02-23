package fr.epsi.b32223g1.test;

import fr.epsi.b32223g1.bo.Fournisseur;
import fr.epsi.b32223g1.dal.FournisseurJDBCDAO;

import java.sql.SQLException;

public class TestUpdate {
    private final FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestUpdate() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public void Update(Fournisseur oldFournisseur, Fournisseur newFournisseur) throws SQLException {
        this.fournisseurJDBCDAO.update(oldFournisseur, newFournisseur);
    }
}