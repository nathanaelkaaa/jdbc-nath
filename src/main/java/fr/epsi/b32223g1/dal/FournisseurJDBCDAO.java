package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurJDBCDAO implements FournisseurDAO {
	
	private static final String FIND_ALL_QUERY = "SELECT * FROM fournisseur";
	private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES ('%s')";

	private static final String UPDATE_QUERY = "UPDATE fournisseur SET NOM=? WHERE ID=?";
	private static final String DELETE_ID_QUERY = "DELETE FROM fournisseur WHERE ID=?";
	
	@Override
	public List<Fournisseur> findAll() throws SQLException {
		
		List<Fournisseur> list = new ArrayList<>();
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_QUERY);
			 ResultSet rs = ps.executeQuery()) {
			
			while ( rs.next() ) {
				int id = rs.getInt( "ID" );
				String nom = rs.getString( "NOM" );
				Fournisseur fournisseur = new Fournisseur( id, nom );
				list.add( fournisseur );
			}
		}
		return list;
	}
	
	@Override
	public void insert( Fournisseur fournisseur ) throws SQLException {
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY)) {
			ps.setString(1, fournisseur.getName());
			ps.executeUpdate();
		}
	}
	
	@Override
	public int update(Fournisseur oldF, Fournisseur newF) throws SQLException  {
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try (PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY)) {
			ps.setString(1, newF.getName());
			ps.setString(2, Integer.toString(oldF.getId()));
			ps.executeUpdate();
		}
		return 0;
	}
	
	@Override
	public boolean deleteById(int id)  throws SQLException {
		Connection connection = DBConnection.getSingle().getSqlConnection();
		try (PreparedStatement ps = connection.prepareStatement(DELETE_ID_QUERY)) {
			ps.setString(1, String.valueOf(id));
			ps.executeUpdate();
		}
		return false;
	}
}
