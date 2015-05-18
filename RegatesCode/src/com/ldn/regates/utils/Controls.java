package com.ldn.regates.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
// import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;





import org.joda.time.LocalDate;
import org.joda.time.Years;

import com.ldn.regates.dao.VoilierDAO;
import com.ldn.regates.ui.UIvoilier;

public class Controls {

	static final String emailRegex = "^[a-zA-Z0-9._-]{2,}+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$";
	static Pattern patternEmail = Pattern.compile(emailRegex);
	static final String dateRegex = "^(\\d{4})/(\\d{2})/(\\d{2})$";
	static Pattern patternDate = Pattern.compile(dateRegex);
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
// Class licencié (Equipier)
	
	public static boolean isValidEMail(String email){
		
		Matcher matcher = patternEmail.matcher(email);
		return matcher.find();
		
	}
	

	public static boolean isValidDate(String date){
		Matcher matcher = patternDate.matcher(date);
		return matcher.find();
	}
	
	public static String age(Date datene) {
		String ageST = null;	
		LocalDate birthdate = new LocalDate(datene);
		LocalDate now = new LocalDate();
		if (datene == null) {
			JOptionPane.showMessageDialog(null, "Veuillez saisir une date.", "Error", JOptionPane.ERROR_MESSAGE);
			ageST = "0";
		} else {
		int ages = Years.yearsBetween(birthdate, now).getYears();
		
	    ageST = Integer.toString(ages);

		}
		return ageST;
	}
	
	
	
	public static double calculPoints(Date anneelic, double pffv, double padd){
		double pffvRes = 0;
		String zeroes;
		
		SimpleDateFormat dFor = new SimpleDateFormat("yyyy/MM/dd");
		
		zeroes = dFor.format(anneelic);
		
		if ( (anneelic.equals(null) ) || (zeroes.equals("0002/11/30") ) || (pffv == 0) || (padd == 0))  {
//			JOptionPane.showMessageDialog(null, "Veuillez saisir une date.", "Error", JOptionPane.ERROR_MESSAGE);
			pffvRes = 0;
		} else {
		Calendar calInp = Calendar.getInstance();
		calInp.setTime(anneelic);	
		 
		Calendar someCalendar1 = Calendar.getInstance(); // current date/time
		someCalendar1.add(Calendar.YEAR, -1);

			if (calInp.compareTo(someCalendar1) < 0) {
				JOptionPane.showMessageDialog(null, "La licence est perimée.", "Error", JOptionPane.ERROR_MESSAGE);
	//			String yearbef = sdf.format(cal.getTime());
				pffvRes = 0;
			} else {
				
				pffvRes = pffv + padd;
			}
		}
		return pffvRes;
	}
	
	public static Date dateConstruct(String year, String month, String day) {
		String dateSt = null;
		Date date = null;
		SimpleDateFormat dFor = new SimpleDateFormat("yyyy/MM/dd");
		
		if ( (year.equals("") ) || (month.equals("")) || (day.equals("")) ) {
			JOptionPane.showMessageDialog(null, "Veuillez saisir une date", "Error", JOptionPane.ERROR_MESSAGE);

				try {
					date = dFor.parse("0000/00/00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
		dateSt = year.concat("/");
		dateSt = dateSt.concat(month);
		dateSt = dateSt.concat("/");
		dateSt = dateSt.concat(day);

		try {
			date = dFor.parse(dateSt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return date;
	}
	
	// Class voilier
	public static String verifNomVoilier (String nomvoilier) {
		
		if (nomvoilier == "") {
			JOptionPane.showMessageDialog(null, "Le champ du nom du voilier est vide.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return nomvoilier;
	}
	
	public static boolean verifNumVoile(int numvoile) {
		
		List<Integer> voileSql = new ArrayList<Integer>();
		voileSql = VoilierDAO.getNumVoile();
		
		if (voileSql.contains(numvoile)) {
			UIvoilier.tFieldNumVoile.setText("");
			return false;
		} else {
			return true;
		}
	}
	
	
	public static boolean verifChampsVoilierVoile(String numvoileST, String nomvoilier) {
		if((numvoileST != null && !numvoileST.isEmpty()) && (nomvoilier != null && !nomvoilier.isEmpty())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static String convertDateToString(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
	
}
