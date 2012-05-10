

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ExecuteButton extends MiscButton implements MouseListener
	{
		public ExecuteButton(String text, OutDisplay out, Color clr){
			super(text,out,clr);
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			getOut().execute();
			super.mousePressed(arg0);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		
	}