
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;


import javax.swing.SwingUtilities;

public class OutDisplay implements KeyListener
{
	private boolean digitGroup = true;
	private JLabel memorylabel;
	private JLabel mylabel;
	private String line;
	public boolean shouldclear = false;
	private Operation currentop;
	private double second;
	private double first;
	private double memory;
	
	
	public OutDisplay(){
		line = " ";
		mylabel = new JLabel("0");
		mylabel.setFont(new Font("Dialog",Font.PLAIN,15));
		mylabel.setHorizontalAlignment(JLabel.RIGHT);
		mylabel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		memorylabel = new JLabel(" ");
		memorylabel.setHorizontalAlignment(JLabel.CENTER);
		memorylabel.setPreferredSize(new Dimension(10,20));
		memorylabel.setBorder(BorderFactory.createLoweredBevelBorder());
		memory = 0;

	}
	public JLabel getMemoryLabel(){
	return memorylabel;
	}
	public JLabel getLabel(){
		return mylabel;
	}
	public void updateLabel(){
		mylabel.setText(format(line));
	}

	public void memRecall(){
		line = memory+"";
		updateLabel();
	}
	public void memClear(){
		memory = 0;
		setMemory(false);
	}
	public void memStore(){
		memory = Double.parseDouble(line);
		setMemory(true);
		shouldclear = true;
	}
	public void memPlus(){

		memory = memory+Double.parseDouble(line);
		setMemory(true);
		shouldclear = true;

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
		if(currentLine().equals(" "))
			return;
		setCurrentLine(current.substring(0, current.length()-1));
		updateLabel();
	}
	public void clearLine(){
		line = " ";
		shouldclear = false;
		updateLabel();
	}
	public void execute(){
		if(!currentop.isComplete())
			currentop.setSecond(Double.parseDouble(line));
		line = ""+currentop.apply(currentop.first, currentop.second);
		currentop.setFirst(currentop.apply(currentop.first,currentop.second));
		updateLabel();
		shouldclear = true;
	}
	public void clear(){
		clearLine();
		currentop = null;
		
	}
	public void negate(){
		if(line.startsWith("-"))
			line = line.substring(1);
		else
			line = "-"+line.substring(1);
		updateLabel();
	}
	
	
	public void storeOperation(Operation o){
		if(currentop != null && !currentop.isComplete()){
			execute();
		}
		o.setFirst(Double.parseDouble(line));
		shouldclear = true;
		currentop = o;
	}
	public void setMemory(boolean mem){
	memorylabel.setText((mem?"M":" "));
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent arg0) {
	String key = arg0.getKeyChar()+"";
		if(isValid(key))
		{
			add(key);
			return;
		}
	if(key.equals("*"))
		storeOperation(new Operation(){
					public double apply(double a, double b) {
						
						return a*b;
					}

					@Override
					String getName() {
						
						return "MULT";
					}});
	if(key.equals("+"))
		storeOperation(new Operation(){
			public double apply(double a, double b) {
				
				return a+b;
			}

			@Override
			String getName() {
				
				return "ADD";
			}});
	if(key.equals("-"))
		storeOperation(new Operation(){
			public double apply(double a, double b) {
				
				return a-b;
			}

			@Override
			String getName() {
				
				return "SUB";
			}});
	if(key.equals("/"))
		storeOperation(new Operation(){
			public double apply(double a, double b) {
				
				return a/b;
			}

			@Override
			String getName() {
				
				return "DIV";
			}});
	if(key.equals("%"))
		percentKey();
	if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
		execute();
	if(arg0.getKeyCode()==KeyEvent.VK_BACK_SPACE)
		backspace();
	if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
		clearLine();
		memClear();
	}
	if(arg0.getKeyCode()==KeyEvent.VK_DELETE)
		clearLine();
	}
	public void percentKey(){
		double first = currentop.first;
		line = (first*(Double.parseDouble(line)/100))+"";
		updateLabel();
	}
	
	public String format(String in){
		if(in.endsWith(".0"))
			in = in.substring(0,in.length()-1);
		if(digitGroup){
			for(int pos=((in.indexOf(".")==-1)?in.length():in.indexOf("."))-3;pos>(in.indexOf(" ")==-1?0:1);pos-=3){
				in = in.substring(0,pos)+","+in.substring(pos,in.length());
				}
			}
		return in;
	}
	
	public boolean isValid(String s){
		String valids = "123456789890.";
		return valids.indexOf(s)!=-1;
	}
	public void toggleDigits(){
	 digitGroup = !digitGroup;
	}
	public void zero(){
	 setCurrentLine(""+Double.parseDouble("0"));
	 shouldclear = true;
	 updateLabel();
	}
	
}	