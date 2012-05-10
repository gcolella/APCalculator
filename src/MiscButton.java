

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MiscButton extends JButton implements MouseListener
	{
	static JFrame focusFrame;
		/**
	 * 
	 */
	private static final long serialVersionUID = -7480031113595412616L;
		private OutDisplay out;
		String txt;
		public MiscButton(String text, OutDisplay out, Color clr){
			super(text);
			setFont(new Font("Dialog",Font.PLAIN,11));
			setForeground(clr);
			txt = text;
			addMouseListener(this);
			setMargin(new Insets(1,2,1,2));
			this.out = out;
		}
		public OutDisplay getOut(){
			return out;
		}
		public void mousePressed(MouseEvent arg0){
			MiscButton.focusFrame.requestFocus();
		}
		public void focus()
		{
			MiscButton.focusFrame.requestFocus();
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
		public static void setFocusFrame(JFrame in){
			focusFrame = in;
		}
	}