
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.BorderFactory;


import javax.swing.SwingUtilities;

public class OutDisplay
{
	
	private Label memorylabel;
	private Label mylabel;
	private String line;
	public boolean shouldclear;
	private Operation currentop;
	private double second;
	private double first;
	
	public OutDisplay(){
		line = "";
		mylabel = new Label("0");
		mylabel.setFont(new Font("Dialog",Font.PLAIN,15));
		mylabel.setAlignment(Label.RIGHT);
		memorylabel = new Label(" ");
		memorylabel.setPreferredSize(new Dimension(10,50));
	//	memorylabel.setBorder(BorderFactory.createLineBorder(Color.black));

	}
	public Label getMemoryLabel(){
	return memorylabel;
	}
	public Label getLabel(){
		return mylabel;
	}
	public void updateLabel(){
		mylabel.setText(line);
	}

	public void add(String s){
		if(shouldclear)
			clearLine();
		setCurrentLine(currentLine().concat(s));
		updateLabel();
	}
	public String currentLine(){
		return line;
	}
	public void setCurrentLine(String s){
		line = s;
	}
	public void backspace(){
		String current = currentLine();
		setCurrentLine(current.substring(0, current.length()-1));
		updateLabel();
	}
	public void clearLine(){
		line = "";
		shouldclear = false;
		updateLabel();
	}
	public void execute(){
		second = Double.parseDouble(line);
		line = ""+currentop.apply(first, second);
		updateLabel();
		shouldclear = true;
	}
	public void clear(){
		clearLine();
	}
	public void negate(){
		if(line.startsWith("-"))
			line = line.substring(1);
		else
			line = "-"+line;
		updateLabel();
	}
	
	
	public void storeOperation(Operation o){
		first = Double.parseDouble(line);
		shouldclear = true;
		currentop = o;
	}
	public void setMemory(boolean mem){
	memorylabel.setText(mem?"M":" ");
	
	
	}
	
}	