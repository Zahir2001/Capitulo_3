package Ej3_17;

import java.util.Arrays;

public class EnteroRepetido {

	static int findRepeating(int[] arr, int N)
	{
		Arrays.sort(arr); // Ordenar el array
	
		for (int i = 0; i < N; i++) {
		
			// comparar el elemento del array con su index
			if (arr[i] != i + 1) {
				return arr[i];
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] arr = new int[] { 9, 6, 2, 8, 1, 7, 4, 3, 5, 9 };
		int N = arr.length;
	
		// Llamada de la función
		int repeatingNum = findRepeating(arr, N);
		System.out.println(repeatingNum);
	}
}
