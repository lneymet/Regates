package com.ldn.regates.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.ldn.regates.ui.UIvoilier;

public class SerieDAO {

	
	 public static void rempliSerie(int numserie)
	 {
	  Connection c = Connect.cConnect();
	  Statement stmt;
	  String sql = "select Nom_serie from serie";
	  
	  try 
	  { 
	   ResultSet rs = null ;  
	   stmt = c.createStatement(); 
	   rs = stmt.executeQuery(sql); 

	   while (rs.next()) 
	   { 
	    String nomserie = rs.getString("Nom_serie");
	    UIvoilier.cBoxSerie.addItem(nomserie); 
	   } 
	  }
	  catch (Exception ex) 
	  { 
	   JOptionPane.showMessageDialog(null, "erreur");
	  }
	 }
}
