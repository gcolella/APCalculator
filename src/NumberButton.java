

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NumberButton implements MouseListener
	{
		private Button mybutton;
		private OutDisplay out;
		String txt;
		public NumberButton(String text, OutDisplay out){
			txt = text;
			mybutton = new Button(text);
			mybutton.addMouseListener(this);
			this.out = out;
		}
		public Button getButton(){
			return mybutton;
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