package fr.epsi.b32223g1.dal;

import fr.epsi.b32223g1.bo.Utilisateur;

public interface UtilisateurDAO {
	
	
	Utilisateur authentification(String login, String pwd) throws Exception;
	
	Utilisateur authentificationSecurisee( String login, String mdp ) throws Exception;
}
