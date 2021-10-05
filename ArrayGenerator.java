import Arrays;
import Random;

class ArrayGenerator{

    private int getRandomNumberInRange(int min, int max){

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

    public int[] generateRandomArray(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = this.getRandomNumberInRange(0, 1000000);
        }
        return arr;
    }

    public int[] generateSortedToUp(int size){
        int[] arr = generateRandomArray(size);
        Arrays.sort(arr);
        return arr;
    }

    public int[] generateSortedToDown(int size){
        int[] arr = generateSortedToUp(size);
        int i, t;
        for (i = 0; i < size / 2; i++) {
            t = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = t;
        }
        return arr;
    }

    public int[] generateSimpleArray(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = this.getRandomNumberInRange(1, 3);
        }
        return arr;
    }
}
