package com.gcolella.APCalculator;

import java.awt.Dimension;
import java.awt.Label;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class OutDisplay
{
	private Label mylabel;
	private ArrayList<String> lines;
	private boolean shouldrun;
	
	
	public OutDisplay(){
		lines = new ArrayList<String>();
		lines.add("");
		mylabel = new Label("hi");
		mylabel.setPreferredSize(new Dimension(100,10));

	}
	public Label getLabel(){
		return mylabel;
	}
	public void updateLabel(){
		while(lines.size()>5)
			lines.remove(lines.size()-1);
		mylabel.setText(lines.get(0));
	}

	public void add(String s){
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
	public void end(){
		shouldrun = false;
	}
	
	
}	