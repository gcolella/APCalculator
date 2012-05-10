import java.awt.Color;
import java.awt.event.MouseEvent;


public abstract class OperationButton extends MiscButton {

	public OperationButton(String text, OutDisplay out, Color clr) {
		super(text, out, clr);
		// TODO Auto-generated constructor stub
	}
	public void mousePressed(MouseEvent arg0){
		getOut().storeOperation(getOperation());
		super.mousePressed(arg0);
	}
	public abstract Operation getOperation();
}
