
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.*;

public class CalcMainPanel {
	public static void main(String[] args){
	setUITheme();
	JFrame theframe = setupFrame();
	theframe.setResizable(false);
	theframe.setVisible(true);
	}
	public static void setUITheme(){
			try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static JFrame setupFrame(){
		JFrame theframe = new JFrame("Calculator");
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents(theframe);
		theframe.pack();
		theframe.setSize(new Dimension(260,265));
		return theframe;
	}
	public static void addComponents(JFrame frame){
		Container stuff = frame.getContentPane();
		stuff.setLayout(new GridBagLayout());
		
		//===set up gridbag===
		GridBagConstraints loc = new GridBagConstraints();
		loc.fill = GridBagConstraints.BOTH;
		loc.weightx = 1;
		loc.weighty = .0;
		loc.gridx = 0;
		loc.gridy = 0;
		//=====================
		
		//===init the screen panel
		loc.weighty = .00;
		loc.gridy = 0;
		loc.gridwidth = GridBagConstraints.REMAINDER;
		JPanel screenPanel = new JPanel(new BorderLayout());
		OutDisplay screen = new OutDisplay();
		stuff.add(screenPanel,loc);
		screenPanel.add(screen.getLabel(),BorderLayout.CENTER);
		screenPanel.setBackground(Color.WHITE);
		loc.weighty = .0;
		//===================
		
		//===make the utility button panel
		loc.gridx = 0;
		loc.gridy=1;
		loc.weighty = .0;
		stuff.add(makeUtilPanel(screen),loc);
		
		loc.weighty = .0;
		loc.gridwidth = 1;
		//================
		

		
		//===make the number button panel
		loc.gridy = 2;
		loc.gridx = 0;
		stuff.add(makeNumberPanel(screen),loc);
		//=====================
		
		

		//===make the menu bar and add it
		frame.setJMenuBar(makeMenuBar());
	}
	public static JMenuBar makeMenuBar(){
		JMenuBar menubar = new JMenuBar();
		JMenu test = new JMenu("Test");
		menubar.add(test);
		JMenuItem test2 = new JMenuItem("Test2");
		test.add(test2);
		return menubar;
	}
	public static JPanel makeLeftPanel(OutDisplay out){
		JPanel leftpanel = new JPanel(new GridBagLayout());
		GridBagConstraints loc = new GridBagConstraints();
		loc.weightx = .5;
		loc.weighty = .5;
		loc.gridx = 0;
		loc.gridy = 0;
		loc.fill = GridBagConstraints.BOTH;
		loc.insets = new Insets(5,5,5,5);
		MiscButton memclear = new MiscButton("MC",out,Color.red) {
		};
		MiscButton memR = new MiscButton("MR",out,Color.red){};
		MiscButton memS = new MiscButton("MS",out,Color.red){};
		MiscButton memPlus = new MiscButton("M+",out,Color.red){};
		leftpanel.add(memclear,loc);
		loc.gridy++;
		leftpanel.add(memR,loc);
		loc.gridy++;
		leftpanel.add(memS,loc);
		loc.gridy++;
		leftpanel.add(memPlus,loc);
		
		
		return leftpanel;
		
	}
	public static JPanel makeUtilPanel(OutDisplay out){
		JPanel utilpanel = new JPanel(new GridBagLayout());
		GridBagConstraints loc = new GridBagConstraints();
		
		loc.weightx = .5;
		loc.weighty = .5;
		loc.gridx = 0;
		loc.gridy = 0;
		loc.fill = GridBagConstraints.BOTH;
		loc.anchor = GridBagConstraints.WEST;
		
		utilpanel.add(out.getMemoryLabel(),loc);
		
		
		loc.gridx++;
		MiscButton backspace = new MiscButton("Backspace",out,Color.red) {
			public void mousePressed(MouseEvent e){
			getOut().backspace();	
			}
		};
		utilpanel.add(backspace,loc);
		
		MiscButton clear = new MiscButton("C",out,Color.red) {
			public void mousePressed(MouseEvent e){
				getOut().clear();
			}
		};
		loc.gridx++;
		utilpanel.add(clear,loc);
		
		MiscButton clearE = new MiscButton("CE",out,Color.red) {
			public void mousePressed(MouseEvent e){
				getOut().clearLine();
			}
		};
		
		loc.gridx++;
		utilpanel.add(clearE,loc);
		
		return utilpanel;
	}

	public static JPanel makeNumberPanel(OutDisplay out){
		JPanel numberPanel = new JPanel(new GridBagLayout());
		GridBagConstraints loc = new GridBagConstraints();
		loc.insets = new Insets(2,2,2,2);
		loc.ipadx = 10;
		loc.ipady = 10;

		loc.fill = GridBagConstraints.BOTH;
		loc.weightx = .5;
		loc.weighty = .5;
		loc.gridx = 0;
		loc.gridy = 0;
		loc.fill = GridBagConstraints.BOTH;
		loc.insets = new Insets(2,2,2,2);
		MiscButton memclear = new MiscButton("MC",out,Color.red) {
		};
		MiscButton memR = new MiscButton("MR",out,Color.red){};
		MiscButton memS = new MiscButton("MS",out,Color.red){};
		MiscButton memPlus = new MiscButton("M+",out,Color.red){};
		numberPanel.add(memclear,loc);
		loc.gridy++;
		numberPanel.add(memR,loc);
		loc.gridy++;
		numberPanel.add(memS,loc);
		loc.gridy++;
		numberPanel.add(memPlus,loc);
		
		
		
		
		//Here are all the numbers.
		for(int i=1;i<4;i++){
			for(int j=0;j<3;j++){
				int num = i+(3*j);
				loc.gridx=1+i-1;
				loc.gridy=j;
				numberPanel.add(new NumberButton(""+num,out,Color.blue),loc);
			}
		}
		loc.gridy++;
		loc.gridx = 1;
		numberPanel.add(new NumberButton(""+0,out,Color.blue),loc);
		loc.gridx++;
		numberPanel.add(new MiscButton("+/-",out,Color.blue){
			public void mousePressed(MouseEvent arg0){
				getOut().negate();
			}
		},loc);
		loc.gridx++;
		numberPanel.add(new NumberButton(".",out,Color.blue),loc);
		//end numbers
		
		
		
		//start operations
		loc.fill = GridBagConstraints.BOTH;
		loc.gridx = 4;
		loc.gridy = 3;
		numberPanel.add(new OperationButton("+",out,Color.red){
			public Operation getOperation() {
				// TODO Auto-generated method stub
				return new Operation(){
					public double apply(double a, double b) {
						// TODO Auto-generated method stub
						return a+b;
					}
				};
			}
		},loc);
		loc.gridy=2;
		numberPanel.add(new OperationButton("-",out,Color.red){
			public Operation getOperation() {
				// TODO Auto-generated method stub
				return new Operation(){
					public double apply(double a, double b) {
						// TODO Auto-generated method stub
						return a-b;
					}
				};
			}
		},loc);
		loc.gridy=1;
		numberPanel.add(new OperationButton("*",out,Color.red){
			public Operation getOperation() {
				// TODO Auto-generated method stub
				return new Operation(){
					public double apply(double a, double b) {
						// TODO Auto-generated method stub
						return a*b;
					}
				};
			}
		},loc);
		loc.gridy=0;
		numberPanel.add(new OperationButton("/",out,Color.red){
			public Operation getOperation() {
				// TODO Auto-generated method stub
				return new Operation(){
					public double apply(double a, double b) {
						// TODO Auto-generated method stub
						return a/b;
					}
				};
			}
		},loc);
		loc.gridx++;
		numberPanel.add(new MiscButton("sqrt",out,Color.blue){
			public void mousePressed(MouseEvent e){
				getOut().setCurrentLine(""+Math.sqrt(Double.parseDouble(getOut().currentLine())));
				getOut().shouldclear = true;
				getOut().updateLabel();
			}
		},loc);
		loc.gridy++;
		
		numberPanel.add(new ExecuteButton("=",out,Color.red),loc);
		
		return numberPanel;
	}
	

	
	
}
