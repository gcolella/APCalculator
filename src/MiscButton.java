

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.JButton;

public class MiscButton extends JButton implements MouseListener
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = -7480031113595412616L;
		private OutDisplay out;
		String txt;
		public MiscButton(String text, OutDisplay out, Color clr){
			super(text);
			setFont(new Font("Dialog",Font.PLAIN,12));
			setForeground(clr);
			txt = text;
			addMouseListener(this);
			setMargin(new Insets(1,1,1,1));
			this.out = out;
		}
		public OutDisplay getOut(){
			return out;
		}
		public void mousePressed(MouseEvent arg0){}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		
	}