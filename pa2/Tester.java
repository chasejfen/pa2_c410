
import java.util.PriorityQueue;
import java.util.Random;

public class Tester {
	public static int N = 500;

	public static void main(String[] args) {

		PQ<Double> pq1 = new PQasSortedArray<Double>(N);
		PriorityQueue<Double> pq2 = new PriorityQueue<Double>(N);
		double[] arr1 = new double[N];
		double[] arr2 = new double[N];
		for (int i = 0; i < arr1.length; i++) {
			Random rand = new Random();
			arr1[i] = rand.nextDouble();
			arr2[i] = arr1[i];
		}
		// timing for insert of PQasSortedArray
		long startTime, endTime;
		startTime = System.nanoTime();

		for (int i = 0; i < arr1.length; i++)
			pq1.insert(arr1[i]);

		endTime = System.nanoTime();
		System.out.println("PQasArray took " + ((endTime - startTime) / 1000000) + " time units");

		// timing for offer of java's PQ
		long startTime2, endTime2;
		startTime2 = System.nanoTime();

		for (int i = 0; i < arr1.length; i++)
			pq2.offer(arr1[i]);

		endTime2 = System.nanoTime();
		System.out.println("java PQ took " + ((endTime2 - startTime2) / 1000000) + " time units");
	}
}
