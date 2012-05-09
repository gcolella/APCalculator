
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class OutDisplay
{
	private Label mylabel;
	private ArrayList<String> lines;
	private boolean shouldrun;
	private boolean shouldclear;
	
	public OutDisplay(){
		lines = new ArrayList<String>();
		lines.add("");
		mylabel = new Label("0");
		mylabel.setFont(new Font("Dialog",Font.PLAIN,30));
		mylabel.setAlignment(Label.RIGHT);

	}
	public Label getLabel(){
		return mylabel;
	}
	public void updateLabel(){
		while(lines.size()>10)
			lines.remove(lines.size()-1);
		mylabel.setText(lines.get(0));
	}

	public void add(String s){
		if(shouldclear)
			clearLine();
		setCurrentLine(currentLine().concat(s));
		updateLabel();
	}
	public String currentLine(){
		return getLine(0);
	}
	public void setCurrentLine(String s){
		setLine(s,0);
	}
	public void setLine(String s, int i){
		lines.set(i,s);
	}
	public String getLine(int i){
		return lines.get(i);
	}
	public void backspace(){
		String current = currentLine();
		setCurrentLine(current.substring(0, current.length()-2));
	}
	public void goBack(){
		lines.remove(0);
	}
	public void clearLine(){
		lines.add(0,"");
		shouldclear = false;
	}
	public void execute(){
		add("="+Calculator.result(currentLine()));
		shouldclear = true;
	}
	
	
	
	
	public void end(){
		shouldrun = false;
	}
	
	
}	