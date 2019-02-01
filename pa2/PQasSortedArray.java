
public class PQasSortedArray<C extends Comparable<? super C>> implements PQ<C> {
	private C[] arr; // store the elements in the priority queue IN SORTED ORDER
	private int currentSize;
	int j;
	C min;

	@SuppressWarnings("unchecked")
	public PQasSortedArray(int size) {
		arr = (C[]) new Comparable[size];
		currentSize = 0;
	}

	public boolean isFull() {
		return currentSize == arr.length;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void insert(C data) {
		if (currentSize == 0)
			arr[currentSize++] = data;
		else {
			for (j = currentSize - 1; j >= 0; j--) {
				if (data.compareTo(arr[j]) < 0)
					arr[j + 1] = arr[j];
				else
					break;
			}
			arr[j + 1] = data;
			currentSize++;
		}
	}

	public C min() {
		if (!isEmpty())
			return arr[0];
		return null;
	}

	public C deleteMin() {
		if (!isEmpty()) {
			C temp = this.min();
			currentSize--;
			for (int j = 0; j < currentSize; j++)
				arr[j] = arr[j + 1];
			return temp;
		}
		return null;
	}
}
