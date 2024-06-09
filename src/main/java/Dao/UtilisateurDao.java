package Dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {
	
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private static int id = 1;
	
	static {
		utilisateurs.add(new Utilisateur("admin", "admin","admin", "admin"));
	}
	
	public static ArrayList<Utilisateur> lister() {
		return utilisateurs;
	}
	
	public static void ajouter(Utilisateur utilisateur) {
		
		utilisateur.setId(id);
		id++;	
		utilisateurs.add(utilisateur);
	}
	
	public static Utilisateur getById(int id) {
		
		for( Utilisateur utilisateur: utilisateurs) {
			if(utilisateur.getId() == id) {
				return utilisateur;
			}
		}
		
		return null;
	}
	
	public static boolean update(Utilisateur utilisateur) {
		
		for(Utilisateur user: utilisateurs) {
			if(user.getId() == utilisateur.getId()) {
				user.setLogin(utilisateur.getLogin());
				user.setPassword(utilisateur.getPassword());
				user.setNom(utilisateur.getNom());
				user.setPrenom(utilisateur.getPrenom());
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean supprimer(int id) { 
		
		for(Utilisateur utilisateur: utilisateurs) {
			if( utilisateur.getId() == id) {
				utilisateurs.remove(utilisateur);
				return true;
			}
		}
		
		return false;
	}
	
	public static Utilisateur get (String login) {
		for (Utilisateur utilisateur: utilisateurs) {
			
			if( utilisateur.getLogin().equals(login)) {
				return utilisateur;
			}
			
		}
		
		return null;
	}
	
	
}
