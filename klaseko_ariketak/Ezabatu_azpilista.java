public class DoubleNode<T> {
	T data;
	DoubleNode<T> next;
	DoubleNode<T> prev;
}

public class DoubleLinkedList<T> {
	DoubleNode<T> first;
	private int size = 0;

	public void ezabatuLista(DoubleLinkedList<T> azpilista) {
		if(azpilista.isEmpty()) {
			return;
		}
		boolean sartuDa = false;
		DoubleNode<T> unekoa1 = this.first;
		DoubleNode<T> unekoa2 = azpilista.first;
		while(unekoa1 != this.first || !sartuDa) {
			if(unekoa1.data.equals(unekoa2.data)) {
				DoubleNode<T> unekoa3 = unekoa1.prev;
				for(int i = 0; i < azpilista.size; i++) {
					unekoa1 = unekoa1.next;
				}
				unekoa3.next = unekoa1;
				unekoa1.prev = unekoa3;
				return;
			}
			unekoa1.next;
		}
	}
}
