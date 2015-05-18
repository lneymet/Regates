package com.ldn.regates.ui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



import com.ldn.regates.dao.ProprietaireDAO;
import com.ldn.regates.model.Proprietaire;
import com.ldn.regates.utils.Controls;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Font;



public class UIproprio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 751804215035729549L;
	private JPanel contentPane;
	private JTextField tFieldNomProp;
	private JTextField tFieldPrenProp;
	private JTextField tFieldEmail;
	private JTextField tFieldTelProp;
	private JTextField tFieldAdresseProp;
	private JTextField tFieldClubProp;
	public static List<Proprietaire> prop = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIproprio frame = new UIproprio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIproprio() {
		setPreferredSize(new Dimension(450, 330));
		setTitle("Inscription de proriétaires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(52, 61, 79, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom:");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setBounds(52, 89, 79, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblEmail = new JLabel("eMail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(52, 117, 79, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTlphone = new JLabel("Téléphone:");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTlphone.setBounds(52, 145, 79, 14);
		contentPane.add(lblTlphone);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setBounds(52, 176, 79, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblClub = new JLabel("Club:");
		lblClub.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClub.setBounds(52, 207, 79, 14);
		contentPane.add(lblClub);
		
		tFieldNomProp = new JTextField();
		tFieldNomProp.setBounds(141, 58, 228, 20);
		contentPane.add(tFieldNomProp);
		tFieldNomProp.setColumns(10);

		
		tFieldPrenProp = new JTextField();
		tFieldPrenProp.setBounds(141, 86, 228, 20);
		contentPane.add(tFieldPrenProp);
		tFieldPrenProp.setColumns(10);

		
		tFieldEmail = new JTextField();
		tFieldEmail.setBounds(141, 114, 228, 20);
		contentPane.add(tFieldEmail);
		tFieldEmail.setColumns(10);

		
		tFieldTelProp = new JTextField();
		tFieldTelProp.setBounds(141, 142, 228, 20);
		contentPane.add(tFieldTelProp);
		tFieldTelProp.setColumns(10);

		
		tFieldAdresseProp = new JTextField();
		tFieldAdresseProp.setBounds(141, 173, 228, 20);
		contentPane.add(tFieldAdresseProp);
		tFieldAdresseProp.setColumns(10);

		
		tFieldClubProp = new JTextField();
		tFieldClubProp.setBounds(141, 204, 228, 20);
		contentPane.add(tFieldClubProp);
		tFieldClubProp.setColumns(10);

		
		JButton btnSaveProp = new JButton("Valider");
		btnSaveProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int propid = ProprietaireDAO.getID();
				String propnom = tFieldNomProp.getText();
				String proppre = tFieldPrenProp.getText();
				String propmail = tFieldEmail.getText();
				String proptel = tFieldTelProp.getText();
				String propcoor = tFieldAdresseProp.getText();
				String propclub = tFieldClubProp.getText();
			 
				boolean verimail = Controls.isValidEMail(propmail);
				if (verimail == false) {
					JOptionPane.showMessageDialog(null, "L'adresse eMail n'est pas valable.", "Erreur", JOptionPane.ERROR_MESSAGE);
					tFieldEmail.setText("");
				} else {
	 
		        // test avec select

	        	Proprietaire prop = new Proprietaire(propid, propnom, proppre, propmail, proptel, propcoor, propclub);
	        	
	        	ProprietaireDAO.createProprietaire(prop);

	        	JOptionPane.showMessageDialog(null,"Le propriétaire a bien été inscrit.","Info", JOptionPane.INFORMATION_MESSAGE);
				tFieldNomProp.setText("");
				tFieldPrenProp.setText("");
				tFieldEmail.setText("");
				tFieldTelProp.setText("");
				tFieldAdresseProp.setText("");
				tFieldClubProp.setText("");
				
				UIvoilier.cBoxProp.removeAllItems();
				ProprietaireDAO.rempliProp(1);
				}

			}
		});
		btnSaveProp.setBounds(168, 253, 89, 23);
		contentPane.add(btnSaveProp);
		
		JButton btnCancelProp = new JButton("Quitter");
		btnCancelProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelProp.setBounds(280, 253, 89, 23);
		contentPane.add(btnCancelProp);
		
		JLabel lblInscriptionDePropritaires = new JLabel("Inscription de propriétaires");
		lblInscriptionDePropritaires.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInscriptionDePropritaires.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscriptionDePropritaires.setBounds(0, 11, 434, 29);
		contentPane.add(lblInscriptionDePropritaires);
	}
}
