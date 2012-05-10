

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ExecuteButton extends JButton implements MouseListener
	{
		private OutDisplay out;
		String txt;
		public ExecuteButton(String text, OutDisplay out, Color clr){
			super(text);
			setForeground(clr);
			setFont(new Font("Dialog",Font.PLAIN,15));
			txt = text;
			addMouseListener(this);
			this.out = out;
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			out.execute();
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