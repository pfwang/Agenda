
public class LinkedList {
private Node head; 
/**
 * the method get, returns a Node from the linked list
 * @param index: int used to locate the Node to be returned
 * @return Node
 */
public Node get(int index)
{
	 Node temp = head;
	 Node temp2;
	 int counter = 0;
	 for (temp2 = temp; counter <= index; temp = temp2.getNext()) // traveres the linked list until the index is reached
	 {
		 if (counter == index)
		 {
			 return temp;
		 }
		 counter ++;
		 temp2 = temp;
	 }
	 return null;
}
/**
 * the method appendFront adds a Node to the front of the linked list
 * @param o
 */
public void appendFront(Node o)
{
	Node temp;
	 temp = head;
	 head = o;
	 head.setNext(temp);
}
/**
 * the method size returns the size of the linked list
 * @return int: represents the size of the linked list
 */
public int size()
{
	 Node temp = head;
	 Node temp2;
	 int size = 0;
	 for (temp2 = temp; temp != null; temp = temp2.getNext())
	 {
		 size++;
		 temp2 = temp;
	 }
	 return size;
}
}

