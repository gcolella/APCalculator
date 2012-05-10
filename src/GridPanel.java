import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class GridPanel extends JPanel {
	GridBagConstraints loc;
	public GridPanel(){
		super(new GridBagLayout());
		loc = new GridBagConstraints();
	}
	public int nextX(){
		return loc.gridx+1;
	}
	public int nextY(){
		return loc.gridy+1;
	}
	public void add(JComponent C,int x, int y){
		loc.gridx = x;
		loc.gridy = y;
		add(C,loc);
	}
	public void setFill(boolean b){
		if(b)
			loc.fill = GridBagConstraints.BOTH;
		else
			loc.fill = GridBagConstraints.NONE;
	}
	public void setInsets(Insets i){
		loc.insets = i;
	}
	public void setWeights(double a, double b)
	{
		loc.weightx=a;
		loc.weighty=b;
	}
	public GridBagConstraints getConstraint(){
		return loc;
	}
	public void reset(){
		loc = new GridBagConstraints();
	}
	public int thisX(){
		return loc.gridx;
	}
	public int thisY(){
		return loc.gridy;
	}
	
	
}
