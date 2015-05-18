package com.ldn.regates.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ldn.regates.dao.ClasseDAO;
import com.ldn.regates.dao.ProprietaireDAO;
import com.ldn.regates.dao.SerieDAO;
import com.ldn.regates.dao.VoilierDAO;
import com.ldn.regates.model.Voilier;
import com.ldn.regates.ui.UIproprio;
import com.ldn.regates.utils.Controls;
import com.ldn.regates.utils.MyComboBoxRenderer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import java.awt.Dimension;

public class UIvoilier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 623126453158993737L;
	public static JComboBox<String> cBoxSerie = new JComboBox<String>();
	public static JComboBox<String> cBoxClasse = new JComboBox<String>();
	public static JComboBox<String> cBoxProp = new JComboBox<String>();
	private JPanel contentPane;
	public static List<String> classe = new ArrayList<>();
	public static JTextField tFieldNomVoilier;
	public static JTextField tFieldNumVoile;

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
	

	// Création de la fenêtre.
	@SuppressWarnings("unchecked")
	public UIvoilier() {
		setPreferredSize(new Dimension(560, 300));
		setTitle("Inscription de voiliers");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnregistrementVoilier = new JLabel("Inscription de Voilier");
		lblEnregistrementVoilier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnregistrementVoilier.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnregistrementVoilier.setBounds(10, 11, 414, 28);
		contentPane.add(lblEnregistrementVoilier);
		
	// Création des composants (champs de saisie) pour l'inscription des voilers.
		
		// Création du champ de saisie "Série"
		final JLabel lblSerie = new JLabel("Série");
		lblSerie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSerie.setBounds(10, 53, 96, 14);
		contentPane.add(lblSerie);
		
		// Construction de l'appel pour affichage de la série dans sa comboBox.
		cBoxSerie = new JComboBox<String>();
		SerieDAO.rempliSerie(0);

		cBoxSerie.setBounds(116, 50, 218, 20);
		MyComboBoxRenderer renderer = new MyComboBoxRenderer("Choisissez");
		cBoxSerie.setRenderer(renderer);
		
		contentPane.add(cBoxSerie);
		
		// Classe
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClasse.setBounds(10, 84, 95, 14);
		contentPane.add(lblClasse);
		
		
		cBoxClasse = new JComboBox<String>();
		
			// Ajout des éléments dans la ComboBox "Classe".
			// On fait appel à la fonction "getLblBoxSerie" qui est chargée de
			// renvoyer les voiliers correspondant au choix de la série par l'utilisateur.
		cBoxSerie.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

			    String choix = getLblBoxSerie();
			    switch (choix) {
			    case "Habitables":
			     cBoxClasse.removeAllItems();
			     ClasseDAO.fillClasse(1);
			     break;

			    case "Quillards de sport":
			     cBoxClasse.removeAllItems();
			     ClasseDAO.fillClasse(2);
			     break;
				}
			}
		});
		cBoxClasse.setBounds(116, 81, 218, 20);
		contentPane.add(cBoxClasse);
		
		// Propriétaire
		JLabel lblPropritaire = new JLabel("Propriétaire");
		lblPropritaire.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropritaire.setBounds(10, 115, 95, 14);
		contentPane.add(lblPropritaire);
		
		// Remplissage de la CmboBox Propriétaire.
		cBoxProp.removeAllItems();
		ProprietaireDAO.rempliProp(1);
		
		cBoxProp.setBounds(116, 112, 218, 20);
		contentPane.add(cBoxProp);
		
		// Nom voilier.
		JLabel lblNomVoilier = new JLabel("Nom du Voilier");
		lblNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomVoilier.setBounds(10, 146, 95, 14);
		contentPane.add(lblNomVoilier);
		
		tFieldNomVoilier = new JTextField();
		tFieldNomVoilier.setBounds(116, 143, 218, 20);
		contentPane.add(tFieldNomVoilier);
		tFieldNomVoilier.setColumns(10);
		
		// Numéro de voile.
		JLabel lblNumVoile = new JLabel("Numéro de voile");
		lblNumVoile.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumVoile.setBounds(10, 177, 95, 14);
		contentPane.add(lblNumVoile);
		
		tFieldNumVoile = new JTextField();
		tFieldNumVoile.setBounds(116, 174, 218, 20);
		contentPane.add(tFieldNumVoile);
		tFieldNumVoile.setColumns(10);
		
	// Boutons
		// Fermeture de la fenêtre.
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnQuitter.setBounds(383, 223, 111, 28);
		contentPane.add(btnQuitter);
		
		// Enregistrement des voiliers dans la base de données.
		// on fait appel à la fonction "saveVoilier" qui recueille
		// les infos choisies et saisies par l'utilisateur.
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveVoilier();
			}
		});
		btnValider.setBounds(262, 223, 111, 28);
		contentPane.add(btnValider);
		
		// Bouton qui renvoie vers la fenêtre de création d'un nouveau propriétaire.
		JButton btnNewButton = new JButton("Nouveau propriétaire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   UIproprio anotherFrame = new UIproprio();
				   anotherFrame.pack();
				   anotherFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(344, 112, 180, 20);
		contentPane.add(btnNewButton);
	}
	
// Création de la fonction "saveVoilier" qui recueille et contrôle les infos apportées par l'utilisateur.
	
	// Récuperation des valeurs affichées dans les ComboBoxes.
	public String getLblBoxSerie( ){return (String)UIvoilier.cBoxSerie.getSelectedItem();}
	public String getLblBoxClasse( ){return (String)UIvoilier.cBoxClasse.getSelectedItem();}
	public static String getLblBoxProp( ){return (String)UIvoilier.cBoxProp.getSelectedItem();}
	
	public void saveVoilier() {
		// Initialisation des variables.
			// Recueil des champs de saisie
		String proprioBox = getLblBoxProp();
		String classeBox = getLblBoxClasse();
		int idVoilier = VoilierDAO.getIDvoilier();		
		int idproprio = ProprietaireDAO.getIDpropBox(proprioBox);
		int idClasse = VoilierDAO.getIDclasse(classeBox);
		String nomvoilier = tFieldNomVoilier.getText();
		String numvoileST = tFieldNumVoile.getText();
		
		// Vérification des infos
			// On vérifie si les deux champs de saisie (nom voilier et numéro de voile)
			// ne sont pas vides.
		boolean verichamps = Controls.verifChampsVoilierVoile(numvoileST, nomvoilier);
		if (verichamps == false) {
			JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis", "Error", JOptionPane.ERROR_MESSAGE);
			// On vérifie que l'utilisateur a bien saisie une chiffre dans le champ "numéro de voile".
		} else if (tFieldNumVoile.getText().matches("^\\d+$")) {
		int numvoile = Integer.parseInt(numvoileST);
			boolean numvoilebool = Controls.verifNumVoile(numvoile);
			// On vérifie si le numéro de voile existe déjà dans la base de données.
			if (numvoilebool == false) {
				JOptionPane.showMessageDialog(null, "Le numéro de voile existe déjà", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
			// une fois les vérifications réussies on passe à l'enregistrement du voilier.
			Voilier voil = new Voilier (idVoilier, idproprio,idClasse,nomvoilier,numvoile);
			
			VoilierDAO.createVoilier(voil);
			// Message de succès de l'enregistrement
	    	JOptionPane.showMessageDialog(null,"Le voilier a bien été inscrit.","Info", JOptionPane.INFORMATION_MESSAGE);
			tFieldNomVoilier.setText("");
			tFieldNumVoile.setText("");	
		}
		} else {
			JOptionPane.showMessageDialog(null, "Le numéro de voile doit être une chiffre", "Error", JOptionPane.ERROR_MESSAGE);
		}
	};		
}


