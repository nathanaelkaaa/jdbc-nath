package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Utilisateur;

import java.sql.*;

public class UtilisateurJDBCDAO implements UtilisateurDAO {
	
	private static final String LOGIN_QUERY = "SELECT * FROM utilisateur WHERE identifiant = '%s' AND mdp = '%s'";
	private static final String SECURED_LOGIN_QUERY = "SELECT * FROM utilisateur WHERE identifiant = ? AND mdp = ?";
	
	@Override
	public Utilisateur authentification( String login, String pwd ) throws Exception {
		
		Connection connection = DBConnection.getSingle().getSqlConnection();
		Utilisateur user = null;
		try ( Statement st = connection.createStatement();
			  ResultSet rs = st.executeQuery( String.format( LOGIN_QUERY, login, pwd )) ) {
			if (rs.next()) {
				int id = rs.getInt( "id" );
				String nom = rs.getString( "nom" );
				String identifiant = rs.getString( "identifiant" );
				String motDePasse = rs.getString( "mdp" );
				user = new Utilisateur( id, nom, identifiant, motDePasse );
			} else {
				throw new Exception("L'utilisateur n'existe pas");
			}
		}
		return user;
	}
	
	@Override
	public Utilisateur authentificationSecurisee( String login, String mdp ) throws Exception {
		Connection connection = DBConnection.getSingle().getSqlConnection();
		Utilisateur user = null;
		try ( PreparedStatement pst = connection.prepareStatement( SECURED_LOGIN_QUERY ) ) {
			pst.setString( 1, login );
			pst.setString( 2, mdp );
			
			try(ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					int id = rs.getInt( "id" );
					String nom = rs.getString( "nom" );
					String identifiant = rs.getString( "identifiant" );
					String motDePasse = rs.getString( "mdp" );
					user = new Utilisateur( id, nom, identifiant, motDePasse );
				} else {
					throw new Exception("L'utilisateur n'existe pas");
				}
			}
		}
		return user;
	}
}
