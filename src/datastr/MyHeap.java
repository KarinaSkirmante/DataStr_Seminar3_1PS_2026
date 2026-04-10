package datastr;

public class MyHeap <Ttype> {
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	private int level = 0;
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//get funkciajs netaisām blokiem, lai lietotajs tiem netiek klāt
	//set funkcijas netaisām, jo neļaujam lieottajam mainīt ne blokus, ne arī elementa skaitu
	
	//bez argumenta konstruktors nāks no Object klases, tāpec paši netaisām
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try {
			new MyNode('a');
			return false;
		} catch (OutOfMemoryError error) {
			return true;
		}

	}

	
	public void add(Ttype element) throws Exception{
		if(isFull()) {
			throw new Exception("Kaudze ir pilna un nevar pievienot jaunu elementu");
		}
		
		if(element == null) {
			throw new Exception("Ievades elements nevar būt null");
		}
		
		//ja kaudze ir tukša, tad jaunais bloks būs vienīagis
		if(isEmpty()) {
			MyNode newNode = new MyNode(element);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		//jāpievieno kārtejais elements
		else
		{
			MyNode newNode = new MyNode(element);
			//pievienot jauno bloku, lai nodrošinātu formas īpašību
			//pievienot pie sakni
			if(howManyElements == 1) {
				newNode.setParentNode(rootNode);
				rootNode.setLeftChildNode(newNode);
				lastNode = newNode;
				level++;
			}
			
			//noskaidrojam, vai ir eksistējošam blokam labās puses māsa/brālis
			if(lastNode.getParentNode().getRightChildNode() == null) {
				lastNode.getParentNode().setRightChildNode(newNode);
				newNode.setParentNode(lastNode.getParentNode());
				lastNode = newNode;
			}
			
			//2^0 - 0. līmenī ir 1 bērns
			//2^1 - 1. līmenī ir 2 bērni
			//2^2 - 2. līmenī ir 4 bērni
			int sum = 0;
			for(int i = 0; i < level; i++) {
				sum += Math.pow(2, i);
			}
			//ja lastNode ir konkrētajā līmenī pēdējais bloks
			if(howManyElements == sum) {//šo var optimizēt ar howManyElements == 1 scenāriju
				MyNode currentNode = rootNode;
				
				while(currentNode.getLeftChildNode()!=null) {
					currentNode = currentNode.getLeftChildNode();
				}
				
				currentNode.setLeftChildNode(newNode);
				newNode.setParentNode(currentNode);
				lastNode = newNode;
			}
			
			
			reheapUp(newNode);
			howManyElements++;
			
		}
	}
		private void reheapUp(MyNode node) {
			if(node != null && node.getParentNode() != null) {
				MyNode tempParentNode = node.getParentNode();
				//if(tempParentNode.getElement() < node.getElement()) {
				if(((Comparable)tempParentNode.getElement()).compareTo(node.getElement()) < 0) {
					Ttype tempElement = (Ttype)tempParentNode.getElement();
					tempParentNode.setElement(node.getElement());
					node.setElement(tempElement);
					reheapUp(tempParentNode);
				}
			}

	}
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Kaudze ir tukša un nav elementu, ko printēt");
		}
		
		printHelper(rootNode);

	}
	
	private void printHelper(MyNode node) {
		if(node != null) {
			System.out.println("P: " + node.getElement());
			
			if(node.getLeftChildNode() != null) {
				System.out.println("P: " + node.getElement() 
				+ " LC: " + node.getLeftChildNode().getElement());
				printHelper(node.getLeftChildNode());
			}
			
			if(node.getRightChildNode() != null) {
				System.out.println("P: " + node.getElement() 
				+"RC: " + node.getRightChildNode().getElement());
				printHelper(node.getRightChildNode());
			}
		}
	}
		
	
}
