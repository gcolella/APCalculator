
public abstract class Operation {
	boolean complete = false;
	double first,second;
	abstract double apply(double a, double b);
	abstract String getName();
	void setFirst(double one){
		first = one;
	}
	void setSecond(double sec){
		second = sec;
		complete = true;
	}
	boolean isComplete(){
		return complete;
	}

}
