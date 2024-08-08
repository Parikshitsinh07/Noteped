
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class KeyHendler implements KeyListener{
	GUI gui;
	public KeyHendler(GUI gui){
		this.gui=gui;
	}
	
	@Override
	public void keyTyped(KeyEvent e){
				
	}
	@Override
	public void keyPressed(KeyEvent e){
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
			gui.file.saveFile();//ctrl+s->Save The File
		}
		if(e.isShiftDown() &&  e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
			gui.file.saveAsFile();//Shift+ctrl+s->SaveAs The File
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){
			gui.edit.undo();//ctrl+z->Undoo
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y){
			gui.edit.redo();//ctrl+y->Redo 
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_W){
			gui.file.ExitFile();//ctrl+w->Close The file
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){
			gui.file.OpenFile();//ctrl+O->open the File
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N){
			gui.file.newFile();//ctrl+N->New the File
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_F){
			gui.menuFile.doClick();//ctrl+F->the Click File Menu
		}
	}
	@Override
	public void keyReleased(KeyEvent e){
		
	}

}