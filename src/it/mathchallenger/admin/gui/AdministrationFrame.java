package it.mathchallenger.admin.gui;

import it.mathchallenger.admin.communication.Communication;
import it.mathchallenger.admin.communication.CommunicationMessageCreator;
import it.mathchallenger.admin.communication.CommunicationParser;
import it.mathchallenger.admin.communication.Messaggio;
import it.mathchallenger.admin.communication.beans.UtentiOnline;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.UIManager;

public class AdministrationFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField regUsernameText;
	private JTextField regEmailText;
	private JTextField deleteUsernameText;
	private JTextField versionNuovaVersione;
	private JTextField rankingNewUsername;
	private JTextField rankingNewPassword;
	private JTextField rankingNewUserAgent;
	private JTextField rankingNewURLPublish;
	private JTextField rankingNewSleepTime;
	private JTextField rankingNewURLRanking;
	private JTextField rankingNewSleepTimeError;
	private JTextField adminNewUsername;
	private JTextField adminNewPass;
	private JTextField mailNewEmail;
	private JTextField mailNewUsername;
	private JTextField mailNewPass;
	private JTextField mailNewNomeVisualizzato;
	private JTextField mailNewSMTP;
	private JTextField mailNewSMTPPort;

	private Communication comm=Communication.getInstance();
	private JButton btnCaricaUtenti;
	private JLabel lblNumClientConnessi;
	private JLabel lblNumUtentiLoggati;
	private JPanel listUtentiLoggatiPanel;
	private JTextField modificaIDUtente;
	private JTextField modificaPassword;
	private JTextField modificaEmail;
	private JLabel lblNomeutenteselezionato;
	private JTextField banID;
	private JTextField banUsername;
	private JTextField deleteID;
	private JButton btnCaricaVersioni;
	private JComboBox<Integer> versioniAbilitateChk;
	private JButton btnForzaAggiornamentoClassifica;
	private JButton btnRicaricaRankingProperties;
	private JButton btnRimuoviVersione;
	private JButton btnAggiungiVersione;
	private JButton adminChange;
	private JButton btnRicaricaEmailProperties;
	private JComboBox<Boolean> mailSSLBox;
	private JButton btnRegistraUtente;
	private JButton btnCancellaUtenteByID;
	private JButton btnCancellaUtenteByUsername;
	private JButton btnModificaPasswordUtente;
	private JButton btnModificaEmailUtente;
	private JButton btnBannaUtenteID;
	private JButton btnBannaUtenteUsername;
	private JButton btnRankingSalvaTutti;
	private JButton btnEmailSalvaTutti;
	private JButton btnDebugStatus;
	private JComboBox<Boolean> cmbdebug;
	private JButton btnRiavviaServer;
	/**
	 * Create the frame.
	 */
	public AdministrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Utenti", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 200, 323);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);
		
		JLabel lblUtentiLoggati = new JLabel("Utenti loggati: ");
		panel_12.add(lblUtentiLoggati);
		
		lblNumUtentiLoggati = new JLabel("0");
		panel_12.add(lblNumUtentiLoggati);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JLabel lblClientConnessi = new JLabel("Client connessi: ");
		panel_13.add(lblClientConnessi);
		
		lblNumClientConnessi = new JLabel("0");
		panel_13.add(lblNumClientConnessi);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		listUtentiLoggatiPanel = new JPanel();
		scrollPane.setViewportView(listUtentiLoggatiPanel);
		listUtentiLoggatiPanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		btnCaricaUtenti = new JButton("Carica utenti");
		panel_4.add(btnCaricaUtenti, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_6.setBorder(new TitledBorder(null, "Registra Utente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_6.setBounds(199, 0, 470, 61);
		panel.add(panel_6);
		
		JLabel lblUsername = new JLabel("Username");
		panel_6.add(lblUsername);
		
		regUsernameText = new JTextField();
		panel_6.add(regUsernameText);
		regUsernameText.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel_6.add(lblEmail);
		
		regEmailText = new JTextField();
		panel_6.add(regEmailText);
		regEmailText.setColumns(10);
		
		btnRegistraUtente = new JButton("OK");
		panel_6.add(btnRegistraUtente);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Cancella Account", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_7.setBounds(199, 61, 470, 80);
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_7.add(panel_23);
		
		JLabel lblId_1 = new JLabel("ID");
		panel_23.add(lblId_1);
		
		deleteID = new JTextField();
		panel_23.add(deleteID);
		deleteID.setColumns(20);
		
		btnCancellaUtenteByID = new JButton("OK");
		panel_23.add(btnCancellaUtenteByID);
		
		JPanel panel_22 = new JPanel();
		panel_7.add(panel_22);
		
		JLabel lblUsername_1 = new JLabel("Username");
		panel_22.add(lblUsername_1);
		
		deleteUsernameText = new JTextField();
		panel_22.add(deleteUsernameText);
		deleteUsernameText.setColumns(20);
		
		btnCancellaUtenteByUsername = new JButton("OK");
		panel_22.add(btnCancellaUtenteByUsername);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modifica Utente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_14.setBounds(199, 147, 470, 89);
		panel.add(panel_14);
		panel_14.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16);
		
		JLabel lblUsername_2 = new JLabel("ID");
		panel_16.add(lblUsername_2);
		
		modificaIDUtente = new JTextField();
		panel_16.add(modificaIDUtente);
		modificaIDUtente.setColumns(10);
		
		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15);
		
		JLabel lblPassword_1 = new JLabel("Password");
		panel_15.add(lblPassword_1);
		
		modificaPassword = new JTextField();
		panel_15.add(modificaPassword);
		modificaPassword.setColumns(10);
		
		btnModificaPasswordUtente = new JButton("OK");
		panel_15.add(btnModificaPasswordUtente);
		
		JPanel panel_17 = new JPanel();
		panel_14.add(panel_17);
		
		lblNomeutenteselezionato = new JLabel("");
		panel_17.add(lblNomeutenteselezionato);
		
		JPanel panel_18 = new JPanel();
		panel_14.add(panel_18);
		
		JLabel lblEmail_1 = new JLabel("Email");
		panel_18.add(lblEmail_1);
		
		modificaEmail = new JTextField();
		panel_18.add(modificaEmail);
		modificaEmail.setColumns(10);
		
		btnModificaEmailUtente = new JButton("OK");
		panel_18.add(btnModificaEmailUtente);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new TitledBorder(null, "Banna Utente", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_19.setBounds(199, 234, 460, 89);
		panel.add(panel_19);
		panel_19.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_19.add(panel_21);
		
		JLabel lblId = new JLabel("ID");
		panel_21.add(lblId);
		
		banID = new JTextField();
		panel_21.add(banID);
		banID.setColumns(10);
		
		btnBannaUtenteID = new JButton("OK");
		panel_21.add(btnBannaUtenteID);
		
		JPanel panel_20 = new JPanel();
		panel_19.add(panel_20);
		
		JLabel lblUsername_3 = new JLabel("Username");
		panel_20.add(lblUsername_3);
		
		banUsername = new JTextField();
		panel_20.add(banUsername);
		banUsername.setColumns(10);
		
		btnBannaUtenteUsername = new JButton("OK");
		panel_20.add(btnBannaUtenteUsername);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ranking", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnRicaricaRankingProperties = new JButton("Ricarica ranking.properties");
		btnRicaricaRankingProperties.setBounds(111, 289, 161, 23);
		panel_1.add(btnRicaricaRankingProperties);
		
		JLabel lblNuovoUsername = new JLabel("Nuovo Username");
		lblNuovoUsername.setBounds(10, 20, 100, 14);
		panel_1.add(lblNuovoUsername);
		
		rankingNewUsername = new JTextField();
		rankingNewUsername.setBounds(111, 17, 140, 20);
		panel_1.add(rankingNewUsername);
		rankingNewUsername.setColumns(10);
		
		JLabel lblNuovaPassword = new JLabel("Nuova Password");
		lblNuovaPassword.setBounds(10, 50, 100, 14);
		panel_1.add(lblNuovaPassword);
		
		rankingNewPassword = new JTextField();
		rankingNewPassword.setBounds(111, 47, 140, 20);
		panel_1.add(rankingNewPassword);
		rankingNewPassword.setColumns(10);
		
		JLabel lblNuovoUseragebt = new JLabel("Nuovo User-Agent");
		lblNuovoUseragebt.setBounds(10, 80, 100, 14);
		panel_1.add(lblNuovoUseragebt);
		
		rankingNewUserAgent = new JTextField();
		rankingNewUserAgent.setBounds(111, 77, 140, 20);
		panel_1.add(rankingNewUserAgent);
		rankingNewUserAgent.setColumns(10);
		
		JLabel lblNuovoUrlRanking = new JLabel("Nuovo URL Publish");
		lblNuovoUrlRanking.setBounds(10, 110, 100, 14);
		panel_1.add(lblNuovoUrlRanking);
		
		rankingNewURLPublish = new JTextField();
		rankingNewURLPublish.setBounds(111, 107, 140, 20);
		panel_1.add(rankingNewURLPublish);
		rankingNewURLPublish.setColumns(10);
		
		JLabel lblNuovoTimesleep = new JLabel("Nuovo TIME_SLEEP");
		lblNuovoTimesleep.setBounds(10, 140, 100, 14);
		panel_1.add(lblNuovoTimesleep);
		
		rankingNewSleepTime = new JTextField();
		rankingNewSleepTime.setBounds(111, 137, 140, 20);
		panel_1.add(rankingNewSleepTime);
		rankingNewSleepTime.setColumns(10);
		
		btnForzaAggiornamentoClassifica = new JButton("Forza aggiornamento classifica");
		btnForzaAggiornamentoClassifica.setBounds(282, 289, 179, 23);
		panel_1.add(btnForzaAggiornamentoClassifica);
		
		JLabel lblNuovoUrlRanking_1 = new JLabel("Nuovo URL Ranking");
		lblNuovoUrlRanking_1.setBounds(10, 200, 100, 14);
		panel_1.add(lblNuovoUrlRanking_1);
		
		rankingNewURLRanking = new JTextField();
		rankingNewURLRanking.setBounds(111, 197, 140, 20);
		panel_1.add(rankingNewURLRanking);
		rankingNewURLRanking.setColumns(10);
		
		JLabel lblTimesleeperror = new JLabel("TIME_SLEEP_ERROR");
		lblTimesleeperror.setBounds(10, 170, 100, 14);
		panel_1.add(lblTimesleeperror);
		
		rankingNewSleepTimeError = new JTextField();
		rankingNewSleepTimeError.setBounds(111, 167, 140, 20);
		panel_1.add(rankingNewSleepTimeError);
		rankingNewSleepTimeError.setColumns(10);
		
		btnRankingSalvaTutti = new JButton("Salva tutti");
		btnRankingSalvaTutti.setBounds(142, 228, 89, 23);
		panel_1.add(btnRankingSalvaTutti);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Server", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Funzioni server", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_8.setBounds(0, 0, 669, 94);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		btnRiavviaServer = new JButton("Riavvia Server");
		btnRiavviaServer.setBounds(10, 27, 103, 23);
		panel_8.add(btnRiavviaServer);
		
		JButton btnBloccaConnessioni = new JButton("Blocca connessioni");
		btnBloccaConnessioni.setBounds(123, 11, 127, 23);
		panel_8.add(btnBloccaConnessioni);
		
		JButton btnSbloccaConnessioni = new JButton("Sblocca connessioni");
		btnSbloccaConnessioni.setBounds(123, 45, 127, 23);
		panel_8.add(btnSbloccaConnessioni);
		
		JButton btnTerminaTutteLe = new JButton("<html><center>Termina tutte<br>le connessioni admin</center></html>");
		btnTerminaTutteLe.setBounds(260, 26, 139, 39);
		panel_8.add(btnTerminaTutteLe);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Versioni client abilitati - rimuovi", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_9.setBounds(0, 94, 669, 65);
		panel_2.add(panel_9);
		FlowLayout fl_panel_9 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_9.setLayout(fl_panel_9);
		
		JLabel lblVersioniAbilitate = new JLabel("Versioni abilitate");
		panel_9.add(lblVersioniAbilitate);
		
		versioniAbilitateChk = new JComboBox<Integer>();
		panel_9.add(versioniAbilitateChk);
		
		btnRimuoviVersione = new JButton("Rimuovi");
		panel_9.add(btnRimuoviVersione);
		
		btnCaricaVersioni = new JButton("Carica Versioni");
		panel_9.add(btnCaricaVersioni);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Versioni client abilitati - aggiungi", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_10.setBounds(0, 159, 669, 65);
		panel_2.add(panel_10);
		
		JLabel lblNuovaVersione = new JLabel("Nuova versione");
		panel_10.add(lblNuovaVersione);
		
		versionNuovaVersione = new JTextField();
		panel_10.add(versionNuovaVersione);
		versionNuovaVersione.setColumns(5);
		
		btnAggiungiVersione = new JButton("Aggiungi");
		panel_10.add(btnAggiungiVersione);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Cambia dati account amministratore", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_11.setBounds(0, 223, 669, 100);
		panel_2.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNuovoUsername_1 = new JLabel("Nuovo Username");
		panel_11.add(lblNuovoUsername_1);
		
		adminNewUsername = new JTextField();
		panel_11.add(adminNewUsername);
		adminNewUsername.setColumns(10);
		
		JLabel lblNuovaPassword_1 = new JLabel("Nuova Password");
		panel_11.add(lblNuovaPassword_1);
		
		adminNewPass = new JTextField();
		panel_11.add(adminNewPass);
		adminNewPass.setColumns(10);
		
		adminChange = new JButton("OK");
		panel_11.add(adminChange);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Email", null, panel_3, null);
		panel_3.setLayout(null);
		
		btnRicaricaEmailProperties = new JButton("Ricarica email.properties");
		btnRicaricaEmailProperties.setBounds(260, 289, 149, 23);
		panel_3.add(btnRicaricaEmailProperties);
		
		JLabel lblNuovoIndirizzoEmail = new JLabel("Nuovo indirizzo email");
		lblNuovoIndirizzoEmail.setBounds(10, 10, 120, 14);
		panel_3.add(lblNuovoIndirizzoEmail);
		
		JLabel lblNuovoUsername_2 = new JLabel("Nuovo username");
		lblNuovoUsername_2.setBounds(10, 40, 120, 14);
		panel_3.add(lblNuovoUsername_2);
		
		JLabel lblNuovaPassword_2 = new JLabel("Nuova password");
		lblNuovaPassword_2.setBounds(10, 70, 120, 14);
		panel_3.add(lblNuovaPassword_2);
		
		JLabel lblNomeVisualizzato = new JLabel("Nome visualizzato");
		lblNomeVisualizzato.setBounds(10, 100, 120, 14);
		panel_3.add(lblNomeVisualizzato);
		
		JLabel lblNuovoSmtpserver = new JLabel("Nuovo SMTP-Server");
		lblNuovoSmtpserver.setBounds(10, 130, 120, 14);
		panel_3.add(lblNuovoSmtpserver);
		
		JLabel lblNuovaPortaSmtp = new JLabel("Nuova porta SMTP");
		lblNuovaPortaSmtp.setBounds(10, 160, 120, 14);
		panel_3.add(lblNuovaPortaSmtp);
		
		JLabel lblUtilizzoSsl = new JLabel("Utilizzo SSL");
		lblUtilizzoSsl.setBounds(10, 190, 120, 14);
		panel_3.add(lblUtilizzoSsl);
		
		mailNewEmail = new JTextField();
		mailNewEmail.setBounds(121, 7, 140, 20);
		panel_3.add(mailNewEmail);
		mailNewEmail.setColumns(10);
		
		mailNewUsername = new JTextField();
		mailNewUsername.setBounds(121, 37, 140, 20);
		panel_3.add(mailNewUsername);
		mailNewUsername.setColumns(10);
		
		mailNewPass = new JTextField();
		mailNewPass.setBounds(121, 67, 140, 20);
		panel_3.add(mailNewPass);
		mailNewPass.setColumns(10);
		
		mailNewNomeVisualizzato = new JTextField();
		mailNewNomeVisualizzato.setBounds(121, 97, 140, 20);
		panel_3.add(mailNewNomeVisualizzato);
		mailNewNomeVisualizzato.setColumns(10);
		
		mailNewSMTP = new JTextField();
		mailNewSMTP.setBounds(121, 130, 140, 20);
		panel_3.add(mailNewSMTP);
		mailNewSMTP.setColumns(10);
		
		mailNewSMTPPort = new JTextField();
		mailNewSMTPPort.setBounds(121, 157, 140, 20);
		panel_3.add(mailNewSMTPPort);
		mailNewSMTPPort.setColumns(10);
		
		mailSSLBox = new JComboBox<Boolean>();
		mailSSLBox.setBounds(121, 187, 140, 20);
		mailSSLBox.addItem(null);
		mailSSLBox.addItem(Boolean.TRUE);
		mailSSLBox.addItem(Boolean.FALSE);
		panel_3.add(mailSSLBox);
		
		btnEmailSalvaTutti = new JButton("Salva tutti");
		btnEmailSalvaTutti.setBounds(148, 218, 89, 23);
		panel_3.add(btnEmailSalvaTutti);
		
		JLabel lblDebug = new JLabel("Debug ");
		lblDebug.setBounds(345, 10, 46, 14);
		panel_3.add(lblDebug);
		
		cmbdebug = new JComboBox<Boolean>();
		cmbdebug.addItem(Boolean.TRUE);
		cmbdebug.addItem(Boolean.FALSE);
		cmbdebug.setBounds(381, 7, 70, 20);
		panel_3.add(cmbdebug);
		
		btnDebugStatus = new JButton("OK");
		btnDebugStatus.setBounds(461, 6, 89, 23);
		panel_3.add(btnDebugStatus);
		
		addWindowListener();
		addListener();
	}
	private void addWindowListener(){
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				Messaggio m=CommunicationMessageCreator.getInstance().createLogoutMessage();
				try {
					comm.send(m);
				} 
				catch (IOException e1) {}
				super.windowClosing(e);
			}
		});
	}
	private void addListener(){
		btnCaricaUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Messaggio m=CommunicationMessageCreator.getInstance().createUserListOnline();
					comm.send(m);
					UtentiOnline uo=CommunicationParser.getInstance().parseUserListOnline(m);
					lblNumClientConnessi.setText("0");
					lblNumUtentiLoggati.setText("0");
					listUtentiLoggatiPanel.removeAll();
					if(uo!=null){
						lblNumClientConnessi.setText(""+uo.getClientConnessi());
						lblNumUtentiLoggati.setText(""+uo.getUtentiLoggati());
						GridLayout lay=(GridLayout) listUtentiLoggatiPanel.getLayout();
						lay.setRows(uo.getUtentiLoggati()<10?10:uo.getUtentiLoggati());
						for(String u:uo.getListaUtenti()){
							final String[] u_i=u.split(",");
							JButton lab=new JButton(u);
							lab.setBorderPainted(false);
							listUtentiLoggatiPanel.add(lab);
							lab.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									lblNomeutenteselezionato.setText(u_i[0]);
									banUsername.setText(u_i[0]);
									deleteUsernameText.setText(u_i[0]);
									deleteID.setText(u_i[1]);
									modificaIDUtente.setText(u_i[1]);
									banID.setText(u_i[1]);
								}
							});
						}
					}
					listUtentiLoggatiPanel.revalidate();
					listUtentiLoggatiPanel.repaint();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		modificaIDUtente.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				lblNomeutenteselezionato.setText("");
			}
		});
		btnCaricaVersioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messaggio m=CommunicationMessageCreator.getInstance().createVersioniAbilitate();
				try {
					comm.send(m);
					ArrayList<Integer> l=CommunicationParser.getInstance().parseVersioniAbilitate(m);
					versioniAbilitateChk.removeAllItems();
					for(Integer i:l){
						versioniAbilitateChk.addItem(i);
					}
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRicaricaRankingProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messaggio m=CommunicationMessageCreator.getInstance().createRankingReload();
				try {
					comm.send(m);
					boolean r=CommunicationParser.getInstance().parseRankingReload(m);
					JOptionPane.showMessageDialog(AdministrationFrame.this, r?"Ranking.properties caricato":m.getErrorMessage());
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRimuoviVersione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer versione=(Integer) versioniAbilitateChk.getSelectedItem();
				if(versione!=null){
					Messaggio m=CommunicationMessageCreator.getInstance().createVersionRemove(versione);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							versioniAbilitateChk.removeItemAt(versioniAbilitateChk.getSelectedIndex());
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Versione rimossa");
						}
						else 
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Versione non rimossa");
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAggiungiVersione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer ver=Integer.parseInt(versionNuovaVersione.getText());
					Messaggio m=CommunicationMessageCreator.getInstance().createVersionAdd(ver);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							versioniAbilitateChk.addItem(ver);
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Versione aggiunta");
						}
						else
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Versione non aggiunta");
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(AdministrationFrame.this, "La versione deve essere un numero intero");
				}
			}
		});
		btnForzaAggiornamentoClassifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Messaggio m=CommunicationMessageCreator.getInstance().createRankingForceUpdate();
				try {
					comm.send(m);
					if(CommunicationParser.getInstance().parseGeneric(m)){
						JOptionPane.showMessageDialog(AdministrationFrame.this, "Classifica aggiornata");
					}
					else
						JOptionPane.showMessageDialog(AdministrationFrame.this, "Classifica non aggiornata");
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnCancellaUtenteByID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(deleteID.getText());
				int r=JOptionPane.showConfirmDialog(AdministrationFrame.this, "Sei sicuro di voler eliminare l'account? ("+id+")");
				if(r==JOptionPane.YES_OPTION){
					Messaggio m=CommunicationMessageCreator.getInstance().createUserDeleteByID(id);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Utente cancellato");
						}
						else{
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Utente non cancellato");
						}
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnCancellaUtenteByUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=deleteUsernameText.getText().trim();
				int r=JOptionPane.showConfirmDialog(AdministrationFrame.this, "Sei sicuro di voler eliminare l'account? ("+username+")");
				if(r==JOptionPane.YES_OPTION){
					Messaggio m=CommunicationMessageCreator.getInstance().createUserDeleteByUsername(username);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Utente cancellato");
						}
						else{
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Utente non cancellato");
						}
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnRicaricaEmailProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Messaggio m=CommunicationMessageCreator.getInstance().createEmailReload();
				try {
					comm.send(m);
					if(CommunicationParser.getInstance().parseGeneric(m)){
						JOptionPane.showMessageDialog(AdministrationFrame.this, "File properties ricaricato");
					}
					else {
						JOptionPane.showMessageDialog(AdministrationFrame.this, "File properties non ricaricato");
					}
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnRankingSalvaTutti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> params=new ArrayList<>();
				if(!rankingNewUsername.getText().trim().isEmpty()){
					params.add("Username");
					params.add(rankingNewUsername.getText().trim());
				}
				if(!rankingNewPassword.getText().trim().isEmpty()){
					params.add("");
					params.add(rankingNewPassword.getText().trim());
				}
				if(!rankingNewURLPublish.getText().trim().isEmpty()){
					params.add("URL_Publish");
					params.add(rankingNewURLPublish.getText().trim());
				}
				if(!rankingNewURLRanking.getText().trim().isEmpty()){
					params.add("URL_Ranking");
					params.add(rankingNewURLRanking.getText().trim());
				}
				if(!rankingNewSleepTime.getText().trim().isEmpty()){
					if(isNumeric(rankingNewSleepTime.getText().trim())){
						params.add("TIME_SLEEP");
						params.add(rankingNewSleepTime.getText().trim());
					}
				}
				if(!rankingNewSleepTimeError.getText().trim().isEmpty()){
					if(isNumeric(rankingNewSleepTimeError.getText().trim())){
						params.add("TIME_SLEEP_ERROR");
						params.add(rankingNewSleepTimeError.getText().trim());
					}
				}
				if(!rankingNewUserAgent.getText().trim().isEmpty()){
					params.add("User-Agent");
					params.add(rankingNewUserAgent.getText().trim());
				}
				if(params.size()>0){
					Messaggio m=CommunicationMessageCreator.getInstance().createRankingChangeValues(params);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Aggiornamento riuscito");
						}
						else
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Aggiornamento non riuscito");
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnEmailSalvaTutti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> params=new ArrayList<String>();
				if(!mailNewEmail.getText().trim().isEmpty()){
					params.add("email");
					params.add(mailNewEmail.getText().trim());
				}
				if(!mailNewUsername.getText().trim().isEmpty()){
					params.add("username");
					params.add(mailNewUsername.getText().trim());
				}
				if(!mailNewPass.getText().trim().isEmpty()){
					params.add("password");
					params.add(mailNewPass.getText().trim());
				}
				if(!mailNewNomeVisualizzato.getText().trim().isEmpty()){
					params.add("nome-visualizzato");
					params.add(mailNewNomeVisualizzato.getText().trim());
				}
				if(!mailNewSMTP.getText().trim().isEmpty()){
					params.add("smtp-server");
					params.add(mailNewSMTP.getText().trim());
				}
				if(!mailNewSMTPPort.getText().trim().isEmpty()){
					if(isNumeric(mailNewSMTPPort.getText().trim())){
						params.add("smtp-port");
						params.add(mailNewSMTPPort.getText().trim());
					}
				}
				if(mailSSLBox.getSelectedItem()!=null){
					boolean b=(boolean) mailSSLBox.getSelectedItem();
					params.add("ssl");
					params.add(b+"");
				}
				if(params.size()>0){
					Messaggio m=CommunicationMessageCreator.getInstance().createEmailChangeValues(params);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Opzioni email aggiornate");
						}
						else
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Opzioni email non aggiornate");
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnDebugStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean b=(boolean) cmbdebug.getSelectedItem();
				Messaggio m=CommunicationMessageCreator.getInstance().createEmailDebugStatus(b);
				try {
					comm.send(m);
					if(CommunicationParser.getInstance().parseGeneric(m)){
						JOptionPane.showMessageDialog(AdministrationFrame.this, "Stato debug email cambiato");
					}
					else
						JOptionPane.showMessageDialog(AdministrationFrame.this, "Opzioni email non aggiornate");
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		btnRegistraUtente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=regUsernameText.getText().trim();
				String email=regUsernameText.getText().trim();
				if(user.length()>0 && email.length()>0){
					Messaggio m=CommunicationMessageCreator.getInstance().createUserAdd(user,email);
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Utente registrato");
						}
						else
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Utente non registrato");
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else 
					JOptionPane.showMessageDialog(AdministrationFrame.this, "Compila tutti i campi");
			}
		});
		btnRiavviaServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(AdministrationFrame.this, "Sei sicuro di voler riavviare il server?")==JOptionPane.YES_OPTION){
					Messaggio m = CommunicationMessageCreator.getInstance().createServerRestart();
					try {
						comm.send(m);
						if(CommunicationParser.getInstance().parseGeneric(m)){
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Server riavviato");
							comm.close();
							System.exit(0);
						}
						else {
							JOptionPane.showMessageDialog(AdministrationFrame.this, "Server non riavviato");
						}
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	private boolean isNumeric(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
}
