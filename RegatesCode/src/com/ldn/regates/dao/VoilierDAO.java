package com.ldn.regates.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ldn.regates.model.Voilier;



public class VoilierDAO {
	
	
	 public static List<Voilier> getVoilier(int idVoilier){
		 
		 Voilier v = ProprietaireDAO.getProprietaire();
		 
		 
		 String sql = "SELECT * from ville where num_pays =" + numPays;
		 
		 Connection c = Connect.cConnect();
		 
		 List<Ville> villes = new ArrayList<>();
		   Statement stm;
			try {
				stm = c.createStatement();
				
		        ResultSet rs = stm.executeQuery(sql);
		      
		        
		        while (rs.next()){
		        	int nbhabitant = rs.getInt("nbhabitants");
		        	String nomVille = rs.getString("nom");
		        	int numVille = rs.getInt("num");
		        	
		        	Ville v = new Ville();
		        	v.setNom(nomVille);
		        	v.setNbHabitants(nbhabitant);
		        	v.setNumVille(numVille);
		        	v.setPays(p);
		        	
		        	
		        	villes.add(v);
		        }
		        rs.close();
				
				
			} catch (SQLException e) {
				throw new RuntimeException();
			}
			
			return villes;
	 }
	 

}
