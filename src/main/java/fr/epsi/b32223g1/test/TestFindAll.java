package fr.epsi.b32223g1.test;

import fr.epsi.b32223g1.bo.Fournisseur;
import  fr.epsi.b32223g1.dal.FournisseurJDBCDAO;

import java.sql.SQLException;
import java.util.List;

public class TestFindAll {
    private final FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestFindAll() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public List<Fournisseur> FindAll() throws SQLException {
        return this.fournisseurJDBCDAO.findAll();
    }
}