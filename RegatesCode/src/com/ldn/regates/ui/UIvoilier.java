package com.ldn.regates.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIvoilier extends JFrame {

	private JPanel contentPane;
	private JTextField tFieldNomVoilier;
	private JTextField tFieldNumVoile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIvoilier frame = new UIvoilier();
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
	public UIvoilier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSerie = new JLabel("Série");
		lblSerie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerie.setBounds(21, 71, 116, 14);
		contentPane.add(lblSerie);
		
		JComboBox cBoxSerie = new JComboBox();
		cBoxSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		cBoxSerie.setBounds(147, 68, 218, 20);
		contentPane.add(cBoxSerie);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClasse.setBounds(20, 102, 116, 14);
		contentPane.add(lblClasse);
		
		JComboBox cBoxClasse = new JComboBox();
		cBoxClasse.setBounds(147, 99, 218, 20);
		contentPane.add(cBoxClasse);
		
		JLabel lblPropritaire = new JLabel("Propri\u00E9taire");
		lblPropritaire.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropritaire.setBounds(20, 133, 116, 14);
		contentPane.add(lblPropritaire);
		
		JComboBox cBoxProp = new JComboBox();
		cBoxProp.setBounds(147, 130, 218, 20);
		contentPane.add(cBoxProp);
		
		JLabel lblNomVoilier = new JLabel("Nom Voilier");
		lblNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoilier.setBounds(20, 164, 116, 14);
		contentPane.add(lblNomVoilier);
		
		tFieldNomVoilier = new JTextField();
		tFieldNomVoilier.setBounds(147, 161, 218, 20);
		contentPane.add(tFieldNomVoilier);
		tFieldNomVoilier.setColumns(10);
		
		JLabel lblNumVoile = new JLabel("Num\u00E9ro de voile");
		lblNumVoile.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumVoile.setBounds(20, 195, 116, 14);
		contentPane.add(lblNumVoile);
		
		tFieldNumVoile = new JTextField();
		tFieldNumVoile.setBounds(147, 192, 218, 20);
		contentPane.add(tFieldNumVoile);
		tFieldNumVoile.setColumns(10);
		
		JLabel lblEnregistrementVoilier = new JLabel("Enregistrement Voilier");
		lblEnregistrementVoilier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnregistrementVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnregistrementVoilier.setBounds(10, 11, 414, 28);
		contentPane.add(lblEnregistrementVoilier);
	}
}
