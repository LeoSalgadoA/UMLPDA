package org.eclipse.acceleo.module.ServerlessDDApp.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Insets;

import  org.eclipse.acceleo.module.ServerlessDDApp.main.Launcher;


public class WinMain
{
	private JFrame frame;
	private JTextField inputFileField;
	private JTextField behaviorFileField;
	private JTextField destField;
	private JCheckBox openFileCheck;
	private JCheckBox behaviorCheck;
	private JCheckBox propsCheck;
	private JComboBox<String> behaviorTypeCombo;
	private JComboBox<String> propsTypeCombo;
	private JTextArea msgTextArea;
	private Launcher launcher;
	private JTextField propsFileField;
	private JButton generateBtn;

	/**
	 * Create the application.
	 */
	public WinMain(Launcher launcher)
	{
		this.launcher = launcher;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new JFrame();
					frame.setTitle("USDDA Transformation Engine");
					frame.setBounds(100, 100, 720, 497);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					initialize();
					frame.setVisible(true);
					inputFileField.requestFocusInWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		JPanel centerPanel = new JPanel();
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		centerPanel.requestFocusInWindow();
		
		
	
		
		JLabel inputFileLabel = new JLabel("Input Model:");
		inputFileLabel.setFont(new Font("Thoma", Font.PLAIN, 14));
		inputFileLabel.setBounds(98, 48, 90, 20);
		centerPanel.add(inputFileLabel);
		
		generateBtn = new JButton("Generate");
		generateBtn.setFont(new Font("Thoma", Font.PLAIN, 12));
		generateBtn.setBounds(565, 270, 96, 23);
		centerPanel.add(generateBtn);
		
		inputFileField = new JTextField();
		inputFileField.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		inputFileField.setBounds(194, 46, 347, 24);
		centerPanel.add(inputFileField);
		inputFileField.setColumns(10);
		
		JButton inputBrowseBtn = new JButton("Browse...");
		inputBrowseBtn.setFont(new Font("Thoma", Font.PLAIN, 12));
		inputBrowseBtn.setBounds(564, 47, 97, 23);
		
		
		centerPanel.add(inputBrowseBtn);
		
		JButton destBrowseBtn = new JButton("Browse...");
		destBrowseBtn.setFont(new Font("Thoma", Font.PLAIN, 12));
		destBrowseBtn.setBounds(564, 192, 97, 23);
		centerPanel.add(destBrowseBtn);
		
		destField = new JTextField();
		destField.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		destField.setColumns(10);
		destField.setBounds(194, 192, 347, 24);
		centerPanel.add(destField);
		
		JLabel destFolderLabel = new JLabel("Output Folder:");
		destFolderLabel.setFont(new Font("Thoma", Font.PLAIN, 14));
		destFolderLabel.setBounds(63, 195, 121, 14);
		centerPanel.add(destFolderLabel);
	
		JButton resetBtn = new JButton("Reset");
		resetBtn.setFont(new Font("Thoma", Font.PLAIN, 12));
		resetBtn.setBounds(458, 270, 97, 23);
		centerPanel.add(resetBtn);
		
		JPanel msgPanel = new JPanel();
		msgPanel.setFont(new Font("Thoma", Font.PLAIN, 14));
		msgPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Console", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Vernada", Font.PLAIN, 14), Color.BLACK));
		msgPanel.setBackground(SystemColor.control);
		msgPanel.setPreferredSize(new Dimension(40, 140));
		msgPanel.setBounds(38, 305, 623, 85);
		centerPanel.add(msgPanel);
		
		msgTextArea = new JTextArea();
		msgTextArea.setFocusable(false);
		msgTextArea.setForeground(new Color(47, 79, 79));
		msgTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		msgTextArea.setBackground(SystemColor.control);
		msgTextArea.setEditable(false);
		msgTextArea.setPreferredSize(new Dimension(583, 55));
		msgPanel.add(msgTextArea);
		
		
		
		JButton closeBtn = new JButton("Close");
		closeBtn.setFont(new Font("Thoma", Font.PLAIN, 12));
		closeBtn.setBounds(564, 410, 97, 23);
		centerPanel.add(closeBtn);
		
		openFileCheck = new JCheckBox("Open Generated Files");
		openFileCheck.setSelected(true);
		openFileCheck.setFont(new Font("Thoma", Font.PLAIN, 14));
		openFileCheck.setBounds(194, 236, 180, 23);
		//centerPanel.add(openFileCheck);
		
		
		//Here
		behaviorFileField = new JTextField();
		behaviorFileField.setBounds(310, 145, 152, 24);
		//centerPanel.add(behaviorFileField);
		behaviorFileField.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		behaviorFileField.setColumns(10);
		
		JLabel behaviorLabel = new JLabel("File Name:");
		behaviorLabel.setBounds(234, 147, 74, 19);
		//centerPanel.add(behaviorLabel);
		behaviorLabel.setFont(new Font("Thoma", Font.PLAIN, 14));
		
		behaviorTypeCombo = new JComboBox<String>();
		behaviorTypeCombo.setBounds(466, 147, 74, 20);
		//centerPanel.add(behaviorTypeCombo);
		behaviorTypeCombo.setFont(new Font("Thoma", Font.PLAIN, 13));
		behaviorTypeCombo.setModel(new DefaultComboBoxModel(new String[] {".sv", ".txt"}));
		
		behaviorCheck = new JCheckBox("Behavior Code");
		behaviorCheck.setBounds(63, 143, 152, 27);
		//centerPanel.add(behaviorCheck);
		behaviorCheck.setSelected(true);
		behaviorCheck.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel propsLabel = new JLabel("File Name:");
		propsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		propsLabel.setBounds(234, 99, 74, 19);
		//centerPanel.add(propsLabel);
		
		propsCheck = new JCheckBox("Assertions Code");
		propsCheck.setSelected(true);
		propsCheck.setFont(new Font("Dialog", Font.PLAIN, 14));
		propsCheck.setBounds(63, 95, 152, 27);
		//centerPanel.add(propsCheck);
		
		propsFileField = new JTextField();
		propsFileField.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		propsFileField.setColumns(10);
		propsFileField.setBounds(310, 97, 152, 24);
		//centerPanel.add(propsFileField);
		
		propsTypeCombo = new JComboBox<String>();
		propsTypeCombo.setModel(new DefaultComboBoxModel(new String[] {".sv", ".txt"}));
		propsTypeCombo.setFont(new Font("Dialog", Font.PLAIN, 13));
		propsTypeCombo.setBounds(466, 99, 74, 20);
		//centerPanel.add(propsTypeCombo);
		
		//till here
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputFileField.setText("");
				propsCheck.setSelected(true);
				behaviorCheck.setSelected(true);
				propsFileField.setText("");
				propsTypeCombo.setSelectedIndex(0);
				behaviorFileField.setText("");
				behaviorTypeCombo.setSelectedIndex(0);
				destField.setText("");
				openFileCheck.setSelected(true);
				msgTextArea.setText("");
			}
		});
		
		inputBrowseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("uml", "uml"));
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("xmi", "xmi"));
				if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					inputFileField.setText(file.getPath());
				}
			}
		});
		
		
		
		
		destBrowseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  destField.setText(file.getPath());
				  // load from file
				}
			}
		});
		
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		
		behaviorCheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				boolean status = behaviorCheck.isSelected();
				behaviorLabel.setEnabled(status);
				behaviorFileField.setEnabled(status);
				behaviorTypeCombo.setEnabled(status);
				refreshGenerateBtnStatus();
			}
		});
		
		destField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void removeUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void insertUpdate(DocumentEvent e) {
				textChangedAction();
			}
			
			public void textChangedAction() {
				refreshGenerateBtnStatus();
			}
		});
		
		inputFileField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void removeUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void insertUpdate(DocumentEvent e) {
				textChangedAction();
			}
			
			public void textChangedAction() {
				String fname = inputFileField.getText();
				if (!fname.isEmpty()){
					int ind = fname.lastIndexOf('\\');
					if(ind != -1) {
						fname = fname.substring(ind+1);
					}
					ind = fname.lastIndexOf('.');
					if(ind != -1) {
						fname = fname.substring(0, ind);
					}
					propsFileField.setText(fname+"_bayesian");
					behaviorFileField.setText(fname+"_behavior");
				}
				refreshGenerateBtnStatus();
			}
		});
		
		propsCheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				boolean status = propsCheck.isSelected();
				propsLabel.setEnabled(status);
				propsFileField.setEnabled(status);
				propsTypeCombo.setEnabled(status);
				refreshGenerateBtnStatus();
			}
		});
		
		propsFileField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void removeUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void insertUpdate(DocumentEvent e) {
				textChangedAction();
			}
			
			public void textChangedAction() {
				refreshGenerateBtnStatus();
			}
		});
		
		behaviorFileField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void removeUpdate(DocumentEvent e) {
				textChangedAction();
			}
			public void insertUpdate(DocumentEvent e) {
				textChangedAction();
			}
			
			public void textChangedAction() {
				refreshGenerateBtnStatus();
			}
		});
		
		generateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean launch = true;
				if(getInputPath().trim().isEmpty() || getDestFolder().trim().isEmpty() 
						|| (propsCheck.isSelected() && propsFileField.getText().trim().isEmpty())
						|| (behaviorCheck.isSelected() && behaviorFileField.getText().trim().isEmpty())) {
					launcher.setStatus(Launcher.EMPTY_REQUIRED_FIELDS);
					launch = false;
				}
				else {
					String propsFileName = getPropsFileName();
					String behaviorFileName = getBehaviorFileName();
					if(!(new File (getInputPath().replace('\\', '/')).exists())) {
						launcher.setStatus(Launcher.MODEL_NOT_FOUND);
						launch = false;
					}
					else if(!(getInputPath().endsWith("uml") || getInputPath().endsWith("UML") ||
							getInputPath().endsWith("xmi") || getInputPath().endsWith("XMI")) ) {
						launcher.setStatus(Launcher.MODEL_NOT_SUPPORTED);
						launch = false;
					}
					else if((propsCheck.isSelected() && !isAValidFileName(propsFileName)) ||
							(behaviorCheck.isSelected() && !isAValidFileName(behaviorFileName))) {
						launcher.setStatus(Launcher.ILLEGAL_FILE_NAME);
						launch = false;
					}
					else if (!(new File (getDestFolder().replace('\\', '/')).exists())) {
						launcher.setStatus(Launcher.FOLDER_DOES_NOT_EXIST);
						launch = false;
					}
					else {
						if(propsCheck.isSelected()) {
							launch = launch && getFileStatus(propsFileName);
						}
						if(behaviorCheck.isSelected()) {
							launch = launch && getFileStatus(behaviorFileName);
						}
						
						if(!launch) {
							launcher.setStatus(Launcher.CLEAR);
						}
					}
					if (launch){
						launcher.setStatus(Launcher.CLEAR);
						launcher.setStatus(Launcher.CREATING);
						String args[] = new String[2];
						args[0] = getInputPath().replace('\\', '/');
						args[1] = getDestFolder().replace('\\', '/');
						launcher.start(args);
					}
				}
			}
		});
		
		refreshGenerateBtnStatus();
	}

	private void refreshGenerateBtnStatus()
	{
		if(	(!inputFileField.getText().trim().isEmpty()) && (!destField.getText().trim().isEmpty()) &&
				(propsCheck.isSelected() || behaviorCheck.isSelected()) ) {
			if((propsCheck.isSelected() && propsFileField.getText().trim().isEmpty()) ||
				(behaviorCheck.isSelected() && behaviorFileField.getText().trim().isEmpty())){
				generateBtn.setEnabled(false);
			}
			else {
				generateBtn.setEnabled(true);
			}
		}
		else {
			generateBtn.setEnabled(false);
		}
	}
	
	private boolean isAValidFileName(String name)
	{
		if(name.contains("/") ||name.contains("\\") || name.contains("*") ||
				name.contains("?") ||name.contains("<") ||name.contains(">") ||
				name.contains("|") ||name.contains(":")) {
			return false;
		}
		
		return true;
	}
	
	private boolean fileExistsInDest(String name)
	{
		if(new File (getDestFolder().replace('\\', '/')+"/"+name).exists()) {
			return true;
		}

		return false;
	}
	
	private boolean getFileStatus(String fileName)
	{
		boolean status = true;
		if(fileExistsInDest(fileName)) {
			int op = JOptionPane.showConfirmDialog(frame,
			  "A file with name \""+fileName+ "\" already exists.\nDo you want to replace it?", "",
			  JOptionPane.YES_NO_OPTION);
			if(op == JOptionPane.YES_OPTION) {
				if(fileExistsInDest(fileName)) {
					if(!(new File(getDestFolder().replace('\\', '/')+"/"+fileName)).delete()) {
						status = false;
						JOptionPane.showMessageDialog(frame,
								fileName+" cannot be replaced. If file is open, close it first.",
						   "", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else {
				status = false;
			}
		}
		return status;
	}
	
	public String getInputPath()
	{
		return inputFileField.getText();
	}

	public String getPropsFileName()
	{
		return propsFileField.getText().trim()+propsTypeCombo.getSelectedItem().toString();
	}

	public String getBehaviorFileName()
	{
		return behaviorFileField.getText().trim()+behaviorTypeCombo.getSelectedItem().toString();
	}
	
	public String getDestFolder()
	{
		return destField.getText();
	}

	public boolean isOpenFiles()
	{
		return openFileCheck.isSelected();
	}

	public boolean isGenerateProps()
	{
		return propsCheck.isSelected();
	}
	
	public boolean isGenerateBehavior()
	{
		return behaviorCheck.isSelected();
	}
	
	public void setMessage(String msg)
	{
		msgTextArea.setText(msg);
		msgTextArea.update(msgTextArea.getGraphics());
	}
}
