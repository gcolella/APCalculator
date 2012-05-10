

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class NumberButton extends MiscButton implements MouseListener
	{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7922128829745580948L;


		public NumberButton(String text, OutDisplay out, Color clr){
			super(text,out,clr);
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			getOut().add(txt);
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