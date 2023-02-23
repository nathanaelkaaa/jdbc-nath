package fr.epsi.b32223g1.test;

import  fr.epsi.b32223g1.dal.FournisseurJDBCDAO;

import java.sql.SQLException;

public class TestDelete {
    private final FournisseurJDBCDAO fournisseurJDBCDAO;
    public TestDelete() {
        this.fournisseurJDBCDAO = new FournisseurJDBCDAO();
    }
    public void Delete(int fournisseurId) throws SQLException {
        this.fournisseurJDBCDAO.deleteById(fournisseurId);
    }
}