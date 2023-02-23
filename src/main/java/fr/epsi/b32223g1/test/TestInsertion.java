package fr.epsi.b32223g1.test;

import  fr.epsi.b32223g1.bo.Fournisseur;
import  fr.epsi.b32223g1.dal.FournisseurJDBCDAO;

import java.sql.SQLException;

public class TestInsertion {
    private final FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestInsertion() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public void Insert(Fournisseur fournisseur) throws SQLException {
        this.fournisseurJDBCDAO.insert(fournisseur);
    }
}