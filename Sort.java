class Sort{
    public int selectionSort(int[] arr){  
        int n = arr.length;
        int operations = 0;
        for (int i = 0; i < n - 1; i++){  
            int index = i;  
            for (int j = i + 1; j < n; j++){  
                operations++;
                if (arr[j] < arr[index]){  
                    index = j;  
                }  
            }
            operations++;
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }
        return operations;
    }

    public int insertionSort(int[] array){  
        int operations = 0;
        int n = array.length;  
        for (int j = 1; j < n; j++){  
            int key = array[j];  
            int i = j - 1;  
            while ((i > -1) && (array [i] > key)){  
                operations++;
                array [i+1] = array [i];  
                i--;  
            }
            operations++;
            array[i+1] = key;  
        }
        return operations;
    }

    private int merge(int arr[], int l, int m, int r){
        int operations = 0;
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1+ j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2){
            operations++;
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1){
            operations++;
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2){
            operations++;
            arr[k] = R[j];
            j++;
            k++;
        }
        return operations;
    }
 
    public int mergeSort(int arr[]){
        return mergeSort1(arr, 0, arr.length - 1);
    }

    private int mergeSort1(int arr[], int l, int r){
        int operations = 0;
        if (l < r){
            int m = (l+r)/2;
 
            operations += mergeSort1(arr, l, m);
            operations += mergeSort1(arr , m+1, r);
 
            operations += merge(arr, l, m, r);
        }
        return operations;
    }

    public int shellSort(int[] arr){
        int num = arr.length;
        int i, j, k, tmp;
        int operations = 0;
        for (i = num / 2; i > 0; i = i / 2){
            operations++;
            for (j = i; j < num; j++){
                operations++;
                for(k = j - i; k >= 0; k = k - i){
                    operations++;
                    if (arr[k+i] >= arr[k])
                        break;
                    else{
                        tmp = arr[k];
                        arr[k] = arr[k+i];
                        arr[k+i] = tmp;
                    }
                }
            }
        }
        return operations;
    }
}
