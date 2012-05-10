
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
		loc.weighty = 1;
		loc.gridx = 0;
		loc.gridy = 0;
		loc.insets = new Insets(5,5,0,5);
		//=====================
		
		//===init the screen panel
		//loc.weighty = 1;
		loc.gridy = 0;
		loc.gridwidth = GridBagConstraints.REMAINDER;
		JPanel screenPanel = new JPanel(new BorderLayout());
		OutDisplay screen = new OutDisplay();
		stuff.add(screenPanel,loc);
		screenPanel.add(screen.getLabel(),BorderLayout.CENTER);
		screenPanel.setBackground(Color.WHITE);
		loc.weighty = .0;
		//loc.insets = new Insets(5,0,0,0);
		//===================
		
		//===make the utility button panel
		loc.gridx = 0;
		loc.gridy=1;
		loc.weighty = .5;
		stuff.add(makeUtilPanel(screen),loc);
		
		loc.weighty = 1;
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
		ButtonGroup views = new ButtonGroup();
		JMenuBar menubar = new JMenuBar();
		JMenu edit = new JMenu("Edit");
		JMenu view = new JMenu("View");
		JMenu help = new JMenu("Help");
		menubar.add(edit);
		menubar.add(view);
		menubar.add(help);
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		edit.add(copy);
		edit.add(paste);
		JRadioButtonMenuItem standard = new JRadioButtonMenuItem("Standard");
		JRadioButtonMenuItem scientific = new JRadioButtonMenuItem("Scientific");
		JMenuItem digit = new JMenuItem("Digit grouping");
		
		views.add(standard);
		views.add(scientific);
		view.add(standard);
		view.add(scientific);
		view.add(digit);
		
		JMenuItem helpb = new JMenuItem("Help Topics");
		JMenuItem about = new JMenuItem("About Calculator");
		help.add(helpb);
		help.add(about);
		
		return menubar;
	}
	public static JPanel makeLeftPanel(OutDisplay out){
		GridPanel leftpanel = new GridPanel();
		GridBagConstraints loc = new GridBagConstraints();
		leftpanel.setWeights(.5, .5);
		leftpanel.setInsets(new Insets(5,0,5,5));
		MiscButton memclear = new MiscButton("MC",out,Color.red) {
		};
		MiscButton memR = new MiscButton("MR",out,Color.red){};
		MiscButton memS = new MiscButton("MS",out,Color.red){};
		MiscButton memPlus = new MiscButton("M+",out,Color.red){};
		leftpanel.add(memclear,0,0);
		leftpanel.add(memR,0,1);
		leftpanel.add(memS,0,2);
		leftpanel.add(memPlus,0,3);
		return leftpanel;
		
	}
	public static JPanel makeUtilPanel(OutDisplay out){
		GridPanel utilpanel = new GridPanel();
		utilpanel.setWeights(.5, .5);
		utilpanel.setFill(true);
		utilpanel.getConstraint().anchor = GridBagConstraints.WEST;
		utilpanel.setInsets(new Insets(0,10,0,10));
		utilpanel.add(out.getMemoryLabel(),0,0);
		utilpanel.setInsets(new Insets(0,2,0,2));
		MiscButton backspace = new MiscButton("Backspace",out,Color.red) {
			public void mousePressed(MouseEvent e){
			getOut().backspace();	
			}
		};
		utilpanel.add(backspace,utilpanel.nextX(),0);
		
		MiscButton clear = new MiscButton("C",out,Color.red) {
			public void mousePressed(MouseEvent e){
				getOut().clear();
			}
		};
		utilpanel.add(clear,utilpanel.nextX(),0);
		
		MiscButton clearE = new MiscButton("CE",out,Color.red) {
			public void mousePressed(MouseEvent e){
				getOut().clearLine();
			}
		};
		
		utilpanel.add(clearE,utilpanel.nextX(),0);
		
		return utilpanel;
	}

	public static JPanel makeNumberPanel(OutDisplay out){
		GridPanel numberPanel = new GridPanel();
		numberPanel.setInsets(new Insets(2,2,2,2));
		numberPanel.getConstraint().ipadx = 10;
		numberPanel.getConstraint().ipady = 10;
		numberPanel.setFill(true);
		numberPanel.setWeights(.5,.5);
		MiscButton memclear = new MiscButton("MC",out,Color.red) {
			public void mousePressed(MouseEvent e){
				getOut().memClear();
			}
		
		};
		MiscButton memR = new MiscButton("MR",out,Color.red){
			public void mousePressed(MouseEvent e){
				getOut().memRecall();
			}
		};
		MiscButton memS = new MiscButton("MS",out,Color.red){
			public void mousePressed(MouseEvent e){
				getOut().memStore();
			}
		};
		MiscButton memPlus = new MiscButton("M+",out,Color.red){};
		numberPanel.add(memclear,0,0);
		numberPanel.add(memR,numberPanel.thisX(),numberPanel.nextY());
		numberPanel.add(memS,numberPanel.thisX(),numberPanel.nextY());
		numberPanel.add(memPlus,numberPanel.thisX(),numberPanel.nextY());
		
		
		
		
		//Here are all the numbers.
		int x = numberPanel.thisX();
		for(int i=1;i<4;i++){
			for(int j=0;j<3;j++){
				int num = 10-(i+(3*j));
				numberPanel.add(new NumberButton(""+num,out,Color.blue),x+i,j);
			}
		}
		numberPanel.add(new NumberButton(""+0,out,Color.blue),1,numberPanel.nextY());
		numberPanel.add(new MiscButton("+/-",out,Color.blue){
			public void mousePressed(MouseEvent arg0){
				getOut().negate();
			}
		},numberPanel.nextX(),numberPanel.thisY());
		numberPanel.add(new NumberButton(".",out,Color.blue),numberPanel.nextX(),numberPanel.thisY());
		//end numbers
		
		
		
		//start operations
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
		},4,3);
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
		},4,2);
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
		},4,1);
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
		},4,0);
		numberPanel.add(new MiscButton("sqrt",out,Color.blue){
			public void mousePressed(MouseEvent e){
				getOut().setCurrentLine(""+Math.sqrt(Double.parseDouble(getOut().currentLine())));
				getOut().shouldclear = true;
				getOut().updateLabel();
			}
		},numberPanel.nextX(),0);

		
		numberPanel.add(new MiscButton("%",out,Color.blue){
			public void mousePressed(MouseEvent e){
			}
		},numberPanel.thisX(),numberPanel.nextY());
		
		numberPanel.add(new MiscButton("1/x",out,Color.blue){
			public void mousePressed(MouseEvent e){
			getOut().setCurrentLine(""+1/Double.parseDouble(getOut().currentLine()));
			getOut().shouldclear = true;
			getOut().updateLabel();
			}
		},numberPanel.thisX(),numberPanel.nextY());
		
		numberPanel.add(new ExecuteButton("=",out,Color.red),numberPanel.thisX(),numberPanel.nextY());
		return numberPanel;
	}
	

	
	
}
