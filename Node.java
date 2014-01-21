/**
 * This class is the Node used in a linked list
 * @author Peter
 *
 */

public class Node {
	
	private int duedate;
	private Day thisday;
	private Node next;

	Node (int duedate, Day thisday)
	{
		this.duedate = duedate;
		this.thisday = thisday;
		this.next = null;
	}

	/**
	 * @return the duedate
	 */
	public int getDuedate() {
		return duedate;
	}

	/**
	 * @param duedate the duedate to set
	 */
	public void setDuedate(int duedate) {
		this.duedate = duedate;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the thisday
	 */
	public Day getThisday() {
		return thisday;
	}

	/**
	 * @param thisday the thisday to set
	 */
	public void setThisday(Day thisday) {
		this.thisday = thisday;
	}

}
/**
 * This class is used to create linked lists
 * @author Peng Fei Wang
 *
 */

