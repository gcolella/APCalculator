package com.gcolella.APCalculator;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.*;

public class CalcMainPanel {
	public static void main(String[] args){
	JFrame theframe = setupFrame();
	theframe.setVisible(true);
	}
	public static JFrame setupFrame(){
		JFrame theframe = new JFrame("Calculator");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents(theframe);
		theframe.pack();
		theframe.setSize(new Dimension(500,500));
		return theframe;
	}
	public static void addComponents(JFrame frame){
		Container stuff = frame.getContentPane();
		stuff.setLayout(new GridLayout());
		GridBagConstraints loc = new GridBagConstraints();
		loc.fill = GridBagConstraints.BOTH;
		loc.weightx = .5;
		loc.weighty = .5;
		loc.gridx = 0;
		loc.gridy = 0;
		JPanel buttonPanel = new JPanel();
		JPanel screenPanel = new JPanel();
		OutDisplay screen = new OutDisplay();
		stuff.add(screenPanel,loc);
		loc.gridy = 1;
		stuff.add(makeNumberPanel(screen),loc);

		screenPanel.add(screen.getLabel());
	}
	public static JPanel makeNumberPanel(OutDisplay out){
		JPanel numberPanel = new JPanel(new GridBagLayout());
		GridBagConstraints loc = new GridBagConstraints();
		loc.weightx = .5;
		loc.weighty = .5;
		loc.fill = GridBagConstraints.BOTH;
		for(int i=1;i<4;i++){
			for(int j=0;j<3;j++){
				int num = i+(3*j);
				loc.gridx=i-1;
				loc.gridy=j;
				NumberButton thisbutton = new NumberButton(""+num,out);
				numberPanel.add(thisbutton.getButton(),loc);
			}
		}
		
		return numberPanel;
	}
	

	
	
}
