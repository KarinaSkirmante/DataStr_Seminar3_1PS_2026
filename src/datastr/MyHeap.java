package datastr;

public class MyHeap <Ttype> {
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	
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

	
}
