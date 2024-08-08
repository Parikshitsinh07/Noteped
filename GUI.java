import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.undo.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GUI implements ActionListener{
	
	JFrame window;
	
	//Top manu bar
	JMenuBar menuBar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	//File name 
	JMenuItem iNew, iOpen ,iSave , iSaveAs ,iExit;
	//Edit manu
	JMenuItem iUndo,iRedo;
	//Format manu
	JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28;
	JMenu menuFont,menuFontSize;
	//Color Menu
	JMenuItem iColor1,iColor2,iColor3;
	//text Area 
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean WordWrapOn=false;
	//Graphic Label
	//JLabel label;
	//ImageIcon ii = null;
	//Classes
	Function_File file = new Function_File(this);
	Funcation_Format format = new Funcation_Format(this);
	Funcation_Color color = new Funcation_Color(this);
	Funcation_Edit edit = new Funcation_Edit(this);
	
	UndoManager um = new UndoManager();
	KeyHendler kHendler = new KeyHendler(this);
	
	public static void main(String [] args){
			
			new GUI();
			
	}
	public GUI(){
		createWindow();
		createTextAres();
		createMenuBar();
		createFileMenu();
		CreateEditmenu();
		createFormatMenu();
		createColorMenu();
		format.selectedFont ="Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		window.setVisible(true);
	}
	public void createWindow(){
		
		window = new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public void createTextAres(){
		textArea = new JTextArea();
		textArea.addKeyListener(kHendler);
		 textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener(){
					public void undoableEditHappened(UndoableEditEvent e){
						um.addEdit(e.getEdit());
					}
				});
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		//window.add(textArea);
		
	}
	public void createMenuBar(){
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
	}
	public void createFileMenu(){
		
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	public void CreateEditmenu(){
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
	}
	public void createFormatMenu(){
		iWrap = new JMenuItem("Word Wrap :Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("CSMS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times new Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("TNR");
		menuFont.add(iFontTNR);
		
		menuFontSize = new JMenu("FontSize");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("Size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("Size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Size28");
		menuFontSize.add(iFontSize28);
		
	}
	public void createColorMenu(){
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		
		switch(command){
			case "New" :file.newFile();
						break;
			case "Open" :file.OpenFile();
						break;
			case "Save" :file.saveFile();
						break;
			case "SaveAs" :file.saveAsFile();
						break;
			case "Exit" :file.ExitFile();
						break;
			case "Word Wrap" : format.wordWrap();
						break;
			case "Arial":format.setFont(command);
						break;
			case "CSMS":format.setFont(command);
						break;
			case "TNR":format.setFont(command);
						break;
			case "Size8" : format.createFont(8);
						break;
			case "Size12" : format.createFont(12);
						break;
			case "Size16" : format.createFont(16);
						break;
			case "Size20" : format.createFont(20);
						break;
			case "Size24" : format.createFont(24);
						break;
			case "Size28" : format.createFont(28);
						break;
			case "White"  : color.changeColor(command);
						break;
			case "Black"  : color.changeColor(command);
						break;
			case "Blue"  : color.changeColor(command);
						break;
			case "Undo"	 : edit.undo();
						break;
			case "Redo"	 : edit.redo();
						break;

			default :
					break;
					
			}
		}
	
	
}