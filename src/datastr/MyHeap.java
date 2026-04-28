package datastr;

import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageTranscoder;

public class MyHeap<Ttype> {
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	private int level = 0;

	public int getHowManyElements() {
		return howManyElements;
	}

	// get funkciajs netaisām blokiem, lai lietotajs tiem netiek klāt
	// set funkcijas netaisām, jo neļaujam lieottajam mainīt ne blokus, ne arī
	// elementa skaitu

	// bez argumenta konstruktors nāks no Object klases, tāpec paši netaisām

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

	public void add(Ttype element) throws Exception {
		if (isFull()) {
			throw new Exception("Kaudze ir pilna un nevar pievienot jaunu elementu");
		}

		if (element == null) {
			throw new Exception("Ievades elements nevar būt null");
		}

		// ja kaudze ir tukša, tad jaunais bloks būs vienīagis
		if (isEmpty()) {
			MyNode newNode = new MyNode(element);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		// jāpievieno kārtejais elements
		else {
			MyNode newNode = new MyNode(element);
			// pievienot jauno bloku, lai nodrošinātu formas īpašību
			// pievienot pie sakni
			if (howManyElements == 1) {
				newNode.setParentNode(rootNode);
				rootNode.setLeftChildNode(newNode);
				lastNode = newNode;
				level++;
				reheapUp(newNode);
				howManyElements++;
				return;
			} else {
				// noskaidrojam, vai ir eksistējošam blokam labās puses māsa/brālis
				if (lastNode.getParentNode().getRightChildNode() == null) {
					lastNode.getParentNode().setRightChildNode(newNode);
					newNode.setParentNode(lastNode.getParentNode());
					lastNode = newNode;
					reheapUp(newNode);
					howManyElements++;
					return;
				}

				// 2^0 - 0. līmenī ir 1 bērns
				// 2^1 - 1. līmenī ir 2 bērni
				// 2^2 - 2. līmenī ir 4 bērni
				int sum = 0;
				for (int i = 0; i <= level; i++) {
					sum += Math.pow(2, i);
				}
				// ja lastNode ir konkrētajā līmenī pēdējais bloks
				if (howManyElements == sum) {// šo var optimizēt ar howManyElements == 1 scenāriju
					MyNode currentNode = rootNode;

					while (currentNode.getLeftChildNode() != null) {
						currentNode = currentNode.getLeftChildNode();
					}

					currentNode.setLeftChildNode(newNode);
					newNode.setParentNode(currentNode);
					lastNode = newNode;
					reheapUp(newNode);
					howManyElements++;
					level++;
					return;
				}

				if (lastNode.getParentNode().getLeftChildNode() != null
						&& lastNode.getParentNode().getRightChildNode() != null) {
					MyNode currentParent = findInsertionNode();

					currentParent.setLeftChildNode(newNode);
					newNode.setParentNode(currentParent);

					lastNode = newNode;
					reheapUp(newNode);
					howManyElements++;
					return;
				}

			}

		}
	}

	private MyNode findInsertionNode() {
		Queue<MyNode> queue = new LinkedList();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			MyNode currentNode = queue.poll();
			if (currentNode.getLeftChildNode() == null) {
				return currentNode;
			} else {
				queue.add(currentNode.getLeftChildNode());
			}
			if (currentNode.getRightChildNode() == null) {
				return currentNode;
			} else {
				queue.add(currentNode.getRightChildNode());
			}
		}
		return null;
	}

	private void reheapUp(MyNode node) {
		if (node != null && node.getParentNode() != null) {
			MyNode tempParentNode = node.getParentNode();
			// if(tempParentNode.getElement() < node.getElement()) {
			if (((Comparable) tempParentNode.getElement()).compareTo(node.getElement()) < 0) {
				Ttype tempElement = (Ttype) tempParentNode.getElement();
				tempParentNode.setElement(node.getElement());
				node.setElement(tempElement);
				reheapUp(tempParentNode);
			}
		}

	}

	public void print() throws Exception {
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša un nav elementu, ko printēt");
		}

		printHelper(rootNode);

	}

	private void printHelper(MyNode node) {
		if (node != null) {
			System.out.println("P: " + node.getElement());

			if (node.getLeftChildNode() != null) {
				System.out.println("P: " + node.getElement() + " LC: " + node.getLeftChildNode().getElement());
				printHelper(node.getLeftChildNode());
			}

			if (node.getRightChildNode() != null) {
				System.out.println("P: " + node.getElement() + " RC: " + node.getRightChildNode().getElement());
				printHelper(node.getRightChildNode());
			}
		}
	}

	public Ttype getMaxElement() throws Exception {
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša un nav prioritārais elements");
		}

		Ttype maxElement = rootNode.getElement();

		if (howManyElements == 1) {
			rootNode = null;
			lastNode = null;
			howManyElements = 0;
			return maxElement;
		} else {
			rootNode.setElement(lastNode.getElement());

			MyNode tempParentNode = lastNode.getParentNode();

			// ja ir abi bērnu, tad labais būs jādzēš
			if (tempParentNode.getLeftChildNode() != null && tempParentNode.getRightChildNode() != null) {
				tempParentNode.setRightChildNode(null);

				// un kreisais bērns kļūst par pēdējo lapu
				lastNode = tempParentNode.getLeftChildNode();
			}
			// ja tas ir kreisais bērnus, kurš jādzēš
			// eksistē kreisais bērns, bet nav labais, tad jādzēš kreisais
			else if (tempParentNode.getLeftChildNode() != null && tempParentNode.getRightChildNode() == null) {
				tempParentNode.setLeftChildNode(null);
			}

			// jānoskaidro, vai jāpārlec uz iepriekšējo līmeni, vai arī jāpāriet uz kreiso
			// kaimiņu

			// jānoskaidro par līmeņiem
			int sum = 0;
			for (int i = 0; i < level; i++) {
				sum += Math.pow(2, i);
			}
			System.out.println(sum + " " + howManyElements);
			if (sum == howManyElements - 1) {//ja ir jāpārlec uz iepriekšējo līmeni

				MyNode<Ttype> currentNode = rootNode;
				while (currentNode.getRightChildNode() != null) {
					currentNode = currentNode.getRightChildNode();
				}
				lastNode = currentNode;
				level--;

			} else {//ja ir jāpāŗiet uz kreiso kaimiņu
				MyNode<Ttype> tempNode = findLeafAtLevel(rootNode, 0, level);
				lastNode = tempNode;
			}

			reheahDown(rootNode);
			howManyElements--;
			return maxElement;
		}
	}

	private static MyNode findLeafAtLevel(MyNode node, int currentLevel, int targetLevel) {
		if (node != null) {

			if (currentLevel == targetLevel) {
				if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
					return node; // atrasts mezgls bez bērniem
				}
				return null;
			}

			MyNode found = findLeafAtLevel(node.getRightChildNode(), currentLevel + 1, targetLevel);
			if (found != null) {
				return found;
			}

			return findLeafAtLevel(node.getLeftChildNode(), currentLevel + 1, targetLevel);
		} else
			return null;
	}

	private void reheahDown(MyNode node) {
		if (node != null) {
			// ir tikai kreisais berns
			if (node.getLeftChildNode() != null && node.getRightChildNode() == null) {
				MyNode tempLeftChildNode = node.getLeftChildNode();

				if (((Comparable) tempLeftChildNode.getElement()).compareTo(node.getElement()) > 0) {
					Ttype tempElement = (Ttype) tempLeftChildNode.getElement();
					tempLeftChildNode.setElement(node.getElement());
					node.setElement(tempElement);
				}

			} else if (node.getLeftChildNode() != null && node.getRightChildNode() != null) {
				// ir abi bērni
				// ja kreisais ir lielāks par labo
				if (((Comparable) node.getLeftChildNode().getElement())
						.compareTo(node.getRightChildNode().getElement()) > 0) {
					// tad kreiso salīdzinam ar node.element
					// pēc nepieciešamības mainām vietam un izsaucām uz kreiso pusi rekursīvi
					// funkciju
					if (((Comparable) node.getLeftChildNode().getElement()).compareTo(node.getElement()) > 0) {
						
						Ttype tempElement = (Ttype) node.getElement();
						node.setElement(node.getLeftChildNode().getElement());
						node.getLeftChildNode().setElement(tempElement);
						reheahDown(node.getLeftChildNode());

					}

				} else {
					if (((Comparable) node.getRightChildNode().getElement()).compareTo(node.getElement()) > 0) {

						Ttype tempElement = (Ttype) node.getElement();
						node.setElement(node.getRightChildNode().getElement());
						node.getRightChildNode().setElement(tempElement);
						reheahDown(node.getRightChildNode());

					}
				}

				// ja kreisais ir mazāks vai vienāds par labo
				// tad labo salīdzinam ar node.element
				// pēc nepieciešamības mainām vietam un izsaucām uz labo pusi rekursīvi funkciju

			}
			// nav bērnu else if(node.getLeftChildNode() ==null && node.getRightChildNode()
			// == null)
			// tajā situācijā arī nekas nav jādara, tāpēc else if nav jāraksta
		}
	}
}
