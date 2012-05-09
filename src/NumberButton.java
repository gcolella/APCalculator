

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class NumberButton extends JButton implements MouseListener
	{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7922128829745580948L;

		private OutDisplay out;
		String txt;
		public NumberButton(String text, OutDisplay out){
			super(text);
			txt = text;
			addMouseListener(this);
			this.out = out;
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			out.add(txt);
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