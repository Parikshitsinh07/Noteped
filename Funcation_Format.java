
import java.awt.Font;
public class Funcation_Format{
	GUI gui;
	Font arial,ComicSanMS,timesNewRoman;
	String selectedFont;
	public Funcation_Format(GUI gui){
		this.gui = gui;
	}
	public void wordWrap(){
		if(gui.WordWrapOn == false){
			gui.WordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap :On");
		}
		else if(gui.WordWrapOn == true){
			gui.WordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap :Off");
		}
	}
	public void createFont(int fontSize){
		arial = new Font("Arial",Font.PLAIN,fontSize);
		ComicSanMS = new Font("Comic Sans MS",Font.PLAIN,fontSize);
		timesNewRoman = new Font("Times new Roman",Font.PLAIN,fontSize);
		
		setFont(selectedFont);
	}
	public void setFont(String Font){
		selectedFont = Font;
		switch(selectedFont){
			case "Arial":gui.textArea.setFont(arial);
						break;
			case "CSMS":gui.textArea.setFont(ComicSanMS);
						break;
			case "TNR":gui.textArea.setFont(timesNewRoman);
						break;
						
		}
	}
}