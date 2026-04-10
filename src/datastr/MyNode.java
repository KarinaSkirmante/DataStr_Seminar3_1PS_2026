package datastr;

public class MyNode <Ttype> {
	//1.mainīgie
	private Ttype element;
	private MyNode rightChildNode = null;
	private MyNode leftChildNode = null;
	private MyNode parentNode = null;
	//2. getters
	public Ttype getElement() {
		return element;
	}
	
	public MyNode getRightChildNode() {
		return rightChildNode;
	}
	
	public MyNode getLeftChildNode() {
		return leftChildNode;
	}
	
	public MyNode getParentNode() {
		return parentNode;
	}

	//3.setters
	public void setElement(Ttype element) {
		if(element != null) {
			this.element = element;
		}
		else
		{
			this.element = (Ttype)new Object();
		}
		
	}

	public void setRightChildNode(MyNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

	public void setLeftChildNode(MyNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public void setParentNode(MyNode parentNode) {
		this.parentNode = parentNode;
	}
	
	//4. konstruktors
	public MyNode (Ttype element) {
		setElement(element);
	}
	
	//5.toString
	public String toString() {
		return ""+element;
	}
	
	
}
