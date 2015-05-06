package com.ldn.regates.dao;

import java.util.Scanner;


public class veutContinuer2 
{

	public static boolean vC() // Fonction Boucle pour donner la possibilité a l'utilisateur de refaire ou pas d'autres opérations.
	{

		String eMail;
		String eMailSt;
		char eMailCh;
		boolean res = false;

		Scanner contKeyb = new Scanner(System.in);
		System.out.println("Voulez-vous recommencer? (1 = Oui, 2 = Non)");
		eMailSt = contKeyb.nextLine();
		eMailCh = eMailSt.charAt(0);
		System.out.println(eMailSt);

		while ((eMailCh != '1') && (eMailCh != '2')) 
			{
			System.out.print("Saissie erronée. Recommencez");
			eMailSt = contKeyb.nextLine();
			eMailCh = eMailSt.charAt(0);
			}
			if ((eMailCh == '1')) {
				res = true;
				}

			else {
				res = false;

				}

		return res;
	}
//	public static boolean vM() // Fonction Boucle pour donner la possibilité a l'utilisateur de refaire ou pas d'autres opérations.
//	{
//
//		int choix = 0;
//		char eMail;
//		boolean res = false;
//
//		System.out.println("Voulez-vous revenir au menu? (O,o-N,n) : ");
//		eMail = Lire.c();
//		System.out.println();
//
//		while ((eMail != 'O') && (eMail != 'o') && (eMail != 'N') && (eMail != 'n')) 
//			{
//			System.out.print("Saissie erronée. Recommencez");
//			eMail = Lire.c();
//			}
//			if ((eMail == 'O') || (eMail == 'o')) {
//				res = true;
//				}
//
//			else {
//				res = false;
//				System.out.println("Bye.");
//				System.exit(0);
//
//				}
//
//		return res;
//	}
}