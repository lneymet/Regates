package com.ldn.regates.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.ldn.regates.model.Licencie;


public class EquipierDAO {

	 public static int getIDequipier(){
			int autoinc = 0;
			Connection c = Connect.cConnect();
			
			  Statement stm;
			try {
				stm = c.createStatement();
				
				String sql = "select id_equipier from equipier order by id_equipier desc limit 1;";
				ResultSet rs = stm.executeQuery(sql);
			
				while(rs.next()) {
				    // ... get column values from this record
					int autoinc2 = rs.getInt("id_equipier");
					autoinc = (autoinc2+1);
				}
	   
				stm.close();
			} 

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return autoinc;
	 }
	
	 public static void createEquipier(Licencie e) {
		 int idequip = EquipierDAO.getIDequipier();

//		 int idprop = Proprietaire.
		 java.util.Date datelic = new java.util.Date();
		 datelic = e.getAnneeLic();
		 java.sql.Date datelicSQL = new java.sql.Date(datelic.getTime());
		 
		 java.util.Date datebirth = new java.util.Date();
		 datebirth = e.getAnneeLic();
		 java.sql.Date datebirthSQL = new java.sql.Date(datebirth.getTime());
		 
		 Connection c = Connect.cConnect();
		 PreparedStatement stm;
		try {
			stm = c.prepareStatement("INSERT INTO equipier (id_equipier, nom_equipier, prenom_equipier, email_equipier, coordonnees_equipier, id_licence_ffv, points_ffv, date_obtention_licence, date_naissance) VALUES (?,?,?,?,?,?,?,?,?)");
			stm.setInt(1, idequip);
			stm.setString(2, e.getNomPers());
			stm.setString(3, e.getPrenPers());
			stm.setString(4, e.geteMail());
			stm.setString(5, e.getAddrLic());
			stm.setInt(6, e.getIdLic());
			stm.setDouble(7, e.getPointsFFV());
			stm.setDate(8, datelicSQL);
			stm.setDate(9, datebirthSQL);
			
			stm.execute();
			
			stm.close();
			
		} catch (SQLException e1) {
			throw new RuntimeException();
		}	
		 
		 
	 }
	 
	 
}
