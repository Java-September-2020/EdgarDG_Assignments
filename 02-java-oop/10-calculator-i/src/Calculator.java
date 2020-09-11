
public class Calculator implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//attributes 
	private int operandOne;
	private int operandTwo;
	private String operation;
	private int result;
	
	//constructors
	public void calculator() {
		
	}
	
	//methods
	public int performOperation(int num1, int num2, String operation) {
		this.setOperandOne(num1);
		this.setOperandTwo(num2);		
		this.setOperation(operation);
		if (this.operation.equals("+")) {
			this.setResult(this.operandOne + this.operandTwo);
			return this.operandOne + this.operandTwo;
		} else if (this.operation.equals("-")) {
			this.setResult(this.operandOne - this.operandTwo);
			return this.operandOne - this.operandTwo;
		} else {
			System.out.println("Not a correct Operation, must be + or -.");
			return -1;
		}
	}
	public void getResults() {
		System.out.println(this.getResult());
	}
	
	//getters and setters
	public void setResult(int result) {
		this.result = result;
	}
	public void setOperandOne(int opOne) {
		this.operandOne = opOne;
	}
	public void setOperandTwo(int opTwo) {
		this.operandTwo = opTwo;
	}
	public void setOperation(String op) {
		this.operation = op;
	}
	public int getResult() {
		return this.result;
	}
	public int getOperandOne() {
		return this.operandOne;
	}
	public int getOperandTwo() {
		return this.operandTwo;
	}
	public String getOperation() {
		return this.operation;
	}
	
	//main
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.performOperation(1, 1, "+");
		cal.getResults();
		cal.performOperation(2, 1, "-");
		cal.getResults();
		cal.performOperation(1, 1, "/");
		cal.getResults();
	}

}
