package boot;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Window.Type;

import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;

import java.awt.BorderLayout;

import javax.swing.JSplitPane;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;


public class janela {

	private JFrame frmHyperlinkDatabase;
	private JTextField textField;
	private JTextField txtGfgfdg;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPanel panelWelcome;
	private JPanel panelAdd;
	private JPanel panelSearch;
	private JPanel panelSearchResults;
	private JPanel panelEdit;
	private int confirm, index;
	private String link, tag, comment, dateCreate, dateMod;
	private String Search;
	private DefaultListModel lmName = new DefaultListModel();
	private ArrayList<String>namelist = new ArrayList<String>();
	
	public static ArrayList<Integer> poslist = new ArrayList<Integer>();
	public static ArrayList<String> nameresults = new ArrayList<String>();
	public static ArrayList<Hyperlink> list = new ArrayList<Hyperlink>();
	private JTextField textField_10;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela window = new janela();
					window.frmHyperlinkDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public janela() {
		initialize();
	}

	private void initialize() {
		frmHyperlinkDatabase = new JFrame();
		frmHyperlinkDatabase.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmHyperlinkDatabase.setTitle("Hyperlink Database");
		frmHyperlinkDatabase.setResizable(false);
		frmHyperlinkDatabase.setBounds(0, 0, 410, 266);
		frmHyperlinkDatabase.setLocationRelativeTo(null);
		frmHyperlinkDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHyperlinkDatabase.getContentPane().setLayout(new CardLayout(0, 0));

		final JPanel panelWelcome = new JPanel();
		panelWelcome.setBackground(Color.BLACK);
		frmHyperlinkDatabase.getContentPane().add(panelWelcome, "name_10759115263101");
		panelWelcome.setLayout(null);
		panelWelcome.setVisible(true);
		
		final JPanel panelAdd = new JPanel();
		panelAdd.setBackground(Color.BLACK);
		frmHyperlinkDatabase.getContentPane().add(panelAdd, "name_10761070178109");
		panelAdd.setLayout(null);
		panelAdd.setVisible(false);
		
		final JPanel panelSearch = new JPanel();
		panelSearch.setBackground(Color.BLACK);
		frmHyperlinkDatabase.getContentPane().add(panelSearch, "name_10762781805041");
		panelSearch.setLayout(null);
		panelSearch.setVisible(false);
		
		final JPanel panelSearchResults = new JPanel();
		panelSearchResults.setBackground(Color.BLACK);
		frmHyperlinkDatabase.getContentPane().add(panelSearchResults, "name_10788389939917");
		panelSearchResults.setLayout(null);
		panelSearchResults.setVisible(false);
		
		final JPanel panelEdit = new JPanel();
		panelEdit.setBackground(Color.BLACK);
		frmHyperlinkDatabase.getContentPane().add(panelEdit, "name_10789941824712");
		panelEdit.setLayout(null);
		panelEdit.setVisible(false);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 384, 182);
		panelSearchResults.add(scrollPane);
		
		final JList lfName = new JList(lmName);
		lfName.setSelectionForeground(Color.WHITE);
		lfName.setSelectionBackground(SystemColor.textHighlight);
		lfName.setForeground(Color.ORANGE);
		lfName.setBorder(new LineBorder(Color.WHITE));
		lfName.setBackground(Color.BLACK);
		lfName.setFont(new Font("Tekton Pro", Font.PLAIN, 12));
		lfName.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lfName);
		
		JButton button_3 = new JButton("Back");
		button_3.setContentAreaFilled(false);
		button_3.setBorder(new LineBorder(Color.WHITE));
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearchResults.setVisible(false);
				panelSearch.setVisible(true);
				lmName.removeAllElements();
			}
		});
		button_3.setBounds(10, 203, 78, 23);
		panelSearchResults.add(button_3);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorder(new LineBorder(Color.WHITE));
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lfName.isSelectionEmpty()){
					panelSearchResults.setVisible(false);
					panelEdit.setVisible(true);
					index = lfName.getSelectedIndex();
					textField_7.setText(list.get(poslist.get(index)).name);
					textField_8.setText(list.get(poslist.get(index)).metatag);
					textField_9.setText(list.get(poslist.get(index)).comment);
				}
			}
		});
		btnEdit.setBounds(316, 203, 78, 23);
		panelSearchResults.add(btnEdit);
		panelSearchResults.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{button_3}));
		panelSearchResults.setVisible(false);

		JLabel lblWelcomeToThe = new JLabel("Welcome to the Ho-kago Tea Party hyperlink database.");
		lblWelcomeToThe.setForeground(Color.WHITE);
		lblWelcomeToThe.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setBounds(10, 53, 384, 14);
		panelWelcome.add(lblWelcomeToThe);

		JButton StartButton = new JButton("Start");
		StartButton.setBorder(new LineBorder(Color.WHITE));
		StartButton.setContentAreaFilled(false);
		StartButton.setForeground(Color.WHITE);
		StartButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list = Hyperlink.Load();
				panelWelcome.setVisible(false);
				panelAdd.setVisible(true);
			}
		});
		StartButton.setBounds(155, 155, 89, 23);
		panelWelcome.add(StartButton);
		
		JLabel lblClickTheButton = new JLabel("Click the button below to begin.");
		lblClickTheButton.setForeground(Color.WHITE);
		lblClickTheButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblClickTheButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickTheButton.setBounds(10, 103, 384, 14);
		panelWelcome.add(lblClickTheButton);
		panelWelcome.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{StartButton}));

		JLabel lblHereYouCan = new JLabel("Here you can add your hyperlinks or search for them.");
		lblHereYouCan.setForeground(Color.WHITE);
		lblHereYouCan.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblHereYouCan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereYouCan.setBounds(10, 11, 384, 14);
		panelAdd.add(lblHereYouCan);

		JLabel lblLink = new JLabel("Link");
		lblLink.setForeground(Color.WHITE);
		lblLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblLink.setBounds(10, 68, 46, 14);
		panelAdd.add(lblLink);

		JLabel lblNewLabel = new JLabel("Meta-tags");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 107, 66, 14);
		panelAdd.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Commentary");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 146, 72, 14);
		panelAdd.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField.setSelectedTextColor(Color.WHITE);
		textField.setCaretColor(Color.WHITE);
		textField.setSelectionColor(SystemColor.textHighlight);
		textField.setForeground(Color.ORANGE);
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField.setBackground(Color.BLACK);
		textField.setBounds(84, 65, 310, 20);
		panelAdd.add(textField);
		textField.setColumns(10);

		txtGfgfdg = new JTextField();
		txtGfgfdg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtGfgfdg.setSelectedTextColor(Color.WHITE);
		txtGfgfdg.setCaretColor(Color.WHITE);
		txtGfgfdg.setForeground(Color.ORANGE);
		txtGfgfdg.setSelectionColor(SystemColor.textHighlight);
		txtGfgfdg.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		txtGfgfdg.setBackground(Color.BLACK);
		txtGfgfdg.setBounds(84, 104, 310, 20);
		panelAdd.add(txtGfgfdg);
		txtGfgfdg.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_2.setSelectedTextColor(Color.WHITE);
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setForeground(Color.ORANGE);
		textField_2.setSelectionColor(SystemColor.textHighlight);
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(84, 143, 310, 20);
		panelAdd.add(textField_2);
		textField_2.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBorder(new LineBorder(Color.WHITE));
		btnAdd.setContentAreaFilled(false);
		btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				link = textField.getText();
				tag = txtGfgfdg.getText();
				comment = textField_2.getText();
				dateCreate = getDate.pegarData();
				dateMod = "None";
				if(link.equals("") || tag.equals("") || comment.equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Please fill all the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Hyperlink added to the database.", "Message", JOptionPane.INFORMATION_MESSAGE);
					textField.setText("");
					txtGfgfdg.setText("");
					textField_2.setText("");
					Hyperlink hyperlink = new Hyperlink(link,tag,comment,dateCreate,dateMod);
					list.add(hyperlink);
					Hyperlink.Serialize(list);
				}
			}
		});
		btnAdd.setBounds(159, 203, 89, 23);
		panelAdd.add(btnAdd);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(new LineBorder(Color.WHITE));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdd.setVisible(false);
				panelSearch.setVisible(true);
				textField_6.setText("MM/dd/yyyy");
				textField_10.setText("MM/dd/yyyy");
			}
		});
		btnSearch.setBounds(10, 203, 89, 23);
		panelAdd.add(btnSearch);
		
		JButton buttonDeleteAll = new JButton("Delete all");
		buttonDeleteAll.setForeground(Color.WHITE);
		buttonDeleteAll.setBorder(new LineBorder(Color.WHITE));
		buttonDeleteAll.setContentAreaFilled(false);
		buttonDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm = JOptionPane.showConfirmDialog(frmHyperlinkDatabase, "Are you sure?", "Delete Hyperlink", JOptionPane.YES_NO_OPTION);
				if (confirm == 0)
				{
					list.clear();
					Hyperlink.Serialize(list);
				}
				
			}
		});
		buttonDeleteAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		buttonDeleteAll.setBounds(305, 203, 89, 23);
		panelAdd.add(buttonDeleteAll);
		panelAdd.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, txtGfgfdg, textField_2, btnAdd, btnSearch, buttonDeleteAll}));

		JLabel lblHereYouCan_1 = new JLabel("Perform your search using one of the fields below.");
		lblHereYouCan_1.setForeground(Color.WHITE);
		lblHereYouCan_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblHereYouCan_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHereYouCan_1.setBounds(10, 11, 384, 14);
		panelSearch.add(lblHereYouCan_1);

		JLabel label = new JLabel("Link");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		label.setBounds(10, 39, 46, 14);
		panelSearch.add(label);

		JLabel label_1 = new JLabel("Meta-tags");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		label_1.setBounds(10, 70, 66, 14);
		panelSearch.add(label_1);

		JLabel label_2 = new JLabel("Commentary");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		label_2.setBounds(10, 101, 72, 14);
		panelSearch.add(label_2);

		textField_3 = new JTextField();
		textField_3.setSelectedTextColor(Color.WHITE);
		textField_3.setSelectionColor(SystemColor.textHighlight);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setForeground(Color.ORANGE);
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_3.setColumns(10);
		textField_3.setBounds(98, 36, 208, 20);
		panelSearch.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setSelectedTextColor(Color.WHITE);
		textField_4.setSelectionColor(SystemColor.textHighlight);
		textField_4.setBackground(Color.BLACK);
		textField_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_4.setCaretColor(Color.WHITE);
		textField_4.setForeground(Color.ORANGE);
		textField_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(98, 67, 208, 20);
		panelSearch.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setSelectedTextColor(Color.WHITE);
		textField_5.setSelectionColor(SystemColor.textHighlight);
		textField_5.setBackground(Color.BLACK);
		textField_5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setForeground(Color.ORANGE);
		textField_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_5.setColumns(10);
		textField_5.setBounds(98, 98, 208, 20);
		panelSearch.add(textField_5);

		JLabel lblNewLabel_2 = new JLabel("Created on");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 135, 90, 14);
		panelSearch.add(lblNewLabel_2);

		textField_6 = new JTextField();
		textField_6.setSelectedTextColor(Color.WHITE);
		textField_6.setSelectionColor(SystemColor.textHighlight);
		textField_6.setBackground(Color.BLACK);
		textField_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_6.setCaretColor(Color.WHITE);
		textField_6.setForeground(Color.ORANGE);
		textField_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_6.setBounds(98, 132, 208, 20);
		panelSearch.add(textField_6);
		textField_6.setColumns(10);

		JButton buttonSearchDate = new JButton("Search");
		buttonSearchDate.setForeground(Color.WHITE);
		buttonSearchDate.setContentAreaFilled(false);
		buttonSearchDate.setBorder(new LineBorder(Color.WHITE));
		buttonSearchDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		buttonSearchDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search = textField_6.getText();
				if(Search.equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Field can't be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					poslist.clear();
					poslist = Hyperlink.searchHyperlink(Search, list, 4);
					lmName.removeAllElements();
					namelist.removeAll(namelist);
					for(int i=0;i<poslist.size();i++)
						namelist.add(list.get(poslist.get(i)).name);
					for(String tmpName:namelist)
						lmName.addElement(tmpName);
					
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("MM/dd/yyyy");
					textField_10.setText("MM/dd/yyyy");
					
					panelSearch.setVisible(false);
					panelSearchResults.setVisible(true);
				}
			}
		});
		buttonSearchDate.setBounds(316, 131, 78, 23);
		panelSearch.add(buttonSearchDate);

		JButton buttonSearchComment = new JButton("Search");
		buttonSearchComment.setForeground(Color.WHITE);
		buttonSearchComment.setContentAreaFilled(false);
		buttonSearchComment.setBorder(new LineBorder(Color.WHITE));
		buttonSearchComment.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		buttonSearchComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search = textField_5.getText();
				if(Search.equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Field can't be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					poslist.clear();
					poslist = Hyperlink.searchHyperlink(Search, list, 3);
					lmName.removeAllElements();
					namelist.removeAll(namelist);
					for(int i=0;i<poslist.size();i++)
						namelist.add(list.get(poslist.get(i)).name);
					for(String tmpName:namelist)
						lmName.addElement(tmpName);
					
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("MM/dd/yyyy");
					textField_10.setText("MM/dd/yyyy");
					
					panelSearch.setVisible(false);
					panelSearchResults.setVisible(true);
				}
			}
		});
		buttonSearchComment.setBounds(316, 97, 78, 23);
		panelSearch.add(buttonSearchComment);

		JButton buttonSearchMeta = new JButton("Search");
		buttonSearchMeta.setForeground(Color.WHITE);
		buttonSearchMeta.setContentAreaFilled(false);
		buttonSearchMeta.setBorder(new LineBorder(Color.WHITE));
		buttonSearchMeta.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		buttonSearchMeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search = textField_4.getText();
				if(Search.equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Field can't be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					poslist.clear();
					poslist = Hyperlink.searchHyperlink(Search, list, 2);
					lmName.removeAllElements();
					namelist.removeAll(namelist);
					for(int i=0;i<poslist.size();i++)
						namelist.add(list.get(poslist.get(i)).name);
					for(String tmpName:namelist)
						lmName.addElement(tmpName);
					
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("MM/dd/yyyy");
					textField_10.setText("MM/dd/yyyy");
					
					panelSearch.setVisible(false);
					panelSearchResults.setVisible(true);
				}
			}
		});
		buttonSearchMeta.setBounds(316, 66, 78, 23);
		panelSearch.add(buttonSearchMeta);

		JButton buttonSearchLink = new JButton("Search");
		buttonSearchLink.setForeground(Color.WHITE);
		buttonSearchLink.setContentAreaFilled(false);
		buttonSearchLink.setBorder(new LineBorder(Color.WHITE));
		buttonSearchLink.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		buttonSearchLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search = textField_3.getText();
				if(Search.equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Field can't be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					poslist.clear();
					poslist = Hyperlink.searchHyperlink(Search, list, 1);
					lmName.removeAllElements();
					namelist.removeAll(namelist);
					for(int i=0;i<poslist.size();i++)
						namelist.add(list.get(poslist.get(i)).name);
					for(String tmpName:namelist)
						lmName.addElement(tmpName);
					
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("MM/dd/yyyy");
					textField_10.setText("MM/dd/yyyy");
					
					panelSearch.setVisible(false);
					panelSearchResults.setVisible(true);
					
				}
			}
		});
		buttonSearchLink.setBounds(316, 35, 78, 23);
		panelSearch.add(buttonSearchLink);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new LineBorder(Color.WHITE));
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearch.setVisible(false);
				panelAdd.setVisible(true);
			}
		});
		btnBack.setBounds(10, 203, 78, 23);
		panelSearch.add(btnBack);
		
		JLabel lblLastModification = new JLabel("Last modified");
		lblLastModification.setForeground(Color.WHITE);
		lblLastModification.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblLastModification.setBounds(10, 167, 78, 14);
		panelSearch.add(lblLastModification);
		
		textField_10 = new JTextField();
		textField_10.setSelectedTextColor(Color.WHITE);
		textField_10.setSelectionColor(SystemColor.textHighlight);
		textField_10.setBackground(Color.BLACK);
		textField_10.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_10.setCaretColor(Color.WHITE);
		textField_10.setForeground(Color.ORANGE);
		textField_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_10.setBounds(98, 164, 208, 20);
		panelSearch.add(textField_10);
		textField_10.setColumns(10);
		
		JButton buttonSearchMod = new JButton("Search");
		buttonSearchMod.setForeground(Color.WHITE);
		buttonSearchMod.setContentAreaFilled(false);
		buttonSearchMod.setBorder(new LineBorder(Color.WHITE));
		buttonSearchMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search = textField_10.getText();
				if(Search.equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Field can't be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					poslist.clear();
					poslist = Hyperlink.searchHyperlink(Search, list, 5);
					lmName.removeAllElements();
					namelist.removeAll(namelist);
					for(int i=0;i<poslist.size();i++)
						namelist.add(list.get(poslist.get(i)).name);
					for(String tmpName:namelist)
						lmName.addElement(tmpName);
					
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("MM/dd/yyyy");
					textField_10.setText("MM/dd/yyyy");
					
					panelSearch.setVisible(false);
					panelSearchResults.setVisible(true);
				}
			}
		});
		buttonSearchMod.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		buttonSearchMod.setBounds(316, 162, 78, 23);
		panelSearch.add(buttonSearchMod);
		
		JButton btnShowAll = new JButton("Show all");
		btnShowAll.setForeground(Color.WHITE);
		btnShowAll.setContentAreaFilled(false);
		btnShowAll.setBorder(new LineBorder(Color.WHITE));
		btnShowAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				poslist.clear();
				for(int i=0; i<list.size();i++)
					poslist.add(i);
				lmName.removeAllElements();
				namelist.removeAll(namelist);
				for(int i=0;i<poslist.size();i++)
					namelist.add(list.get(poslist.get(i)).name);
				for(String tmpName:namelist)
					lmName.addElement(tmpName);
				
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("MM/dd/yyyy");
				textField_10.setText("MM/dd/yyyy");
				
				panelSearch.setVisible(false);
				panelSearchResults.setVisible(true);
			}
		});
		btnShowAll.setBounds(316, 203, 78, 23);
		panelSearch.add(btnShowAll);
		panelSearch.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_3, buttonSearchLink, textField_4, buttonSearchMeta, textField_5, buttonSearchComment, textField_6, buttonSearchDate, textField_10, buttonSearchMod, btnBack, btnShowAll}));

		JLabel lblPerformsTheEdit = new JLabel("Performs the edit you want. But don't forget to hit that save button!");
		lblPerformsTheEdit.setForeground(Color.WHITE);
		lblPerformsTheEdit.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblPerformsTheEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformsTheEdit.setBounds(10, 11, 384, 14);
		panelEdit.add(lblPerformsTheEdit);

		JLabel label_3 = new JLabel("Link");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		label_3.setBounds(10, 61, 46, 14);
		panelEdit.add(label_3);

		JLabel label_4 = new JLabel("Meta-tags");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		label_4.setBounds(10, 100, 66, 14);
		panelEdit.add(label_4);

		JLabel label_5 = new JLabel("Commentary");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		label_5.setBounds(10, 139, 72, 14);
		panelEdit.add(label_5);

		textField_7 = new JTextField();
		textField_7.setSelectedTextColor(new Color(255, 255, 255));
		textField_7.setForeground(Color.ORANGE);
		textField_7.setBackground(Color.BLACK);
		textField_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_7.setCaretColor(Color.WHITE);
		textField_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_7.setSelectionColor(SystemColor.textHighlight);
		textField_7.setColumns(10);
		textField_7.setBounds(88, 58, 306, 20);
		panelEdit.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setSelectedTextColor(new Color(255, 255, 255));
		textField_8.setForeground(Color.ORANGE);
		textField_8.setBackground(Color.BLACK);
		textField_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_8.setCaretColor(Color.WHITE);
		textField_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_8.setSelectionColor(SystemColor.textHighlight);
		textField_8.setColumns(10);
		textField_8.setBounds(88, 97, 306, 20);
		panelEdit.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setSelectedTextColor(new Color(255, 255, 255));
		textField_9.setForeground(Color.ORANGE);
		textField_9.setBackground(Color.BLACK);
		textField_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textField_9.setCaretColor(Color.WHITE);
		textField_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		textField_9.setSelectionColor(SystemColor.textHighlight);
		textField_9.setColumns(10);
		textField_9.setBounds(88, 136, 306, 20);
		panelEdit.add(textField_9);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEdit.setVisible(false);
				panelSearch.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 197, 89, 23);
		panelEdit.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirm = JOptionPane.showConfirmDialog(frmHyperlinkDatabase, "Are you sure?", "Delete Hyperlink", JOptionPane.YES_NO_OPTION);
				if (confirm == 0){
					list.remove((int)poslist.get(index));
					poslist.remove(index);
					Hyperlink.Serialize(list);
					lmName.removeAllElements();
					panelEdit.setVisible(false);
					panelSearch.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(305, 197, 89, 23);
		panelEdit.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_7.getText().equals("") || textField_8.getText().equals("") || textField_9.getText().equals("")){
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Please fill all the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else{
					dateMod = getDate.pegarData();
					JOptionPane.showMessageDialog(frmHyperlinkDatabase, "Changes saved.", "Message", JOptionPane.INFORMATION_MESSAGE);
					list.get(poslist.get(index)).name = textField_7.getText();
					list.get(poslist.get(index)).metatag = textField_8.getText();
					list.get(poslist.get(index)).comment = textField_9.getText();
					list.get(poslist.get(index)).datemod = dateMod;
					Hyperlink.Serialize(list);
					lmName.removeAllElements();
					panelEdit.setVisible(false);
					panelSearch.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(157, 197, 89, 23);
		panelEdit.add(btnNewButton_2);
		panelEdit.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_7, textField_8, textField_9, btnNewButton, btnNewButton_1, btnNewButton_2}));
	}
}
