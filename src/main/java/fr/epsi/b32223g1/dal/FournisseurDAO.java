package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDAO {

	List<Fournisseur> findAll() throws SQLException;

	void insert( Fournisseur fournisseur ) throws SQLException;

	int update(Fournisseur oldF, Fournisseur newF) throws SQLException;

	boolean deleteById(int id) throws SQLException;
}
