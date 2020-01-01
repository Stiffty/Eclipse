package sort2;

import java.util.Arrays;
import java.util.Random;

public class Sort {

	 private static final int BITS_PER_BYTE = 8;
	
	private Draw draw;
	public Sort(Draw draw) {
		this.draw = draw;
	}
	
	public void füllen(int[] feld) {
		for (int i = 0; i < feld.length; i++) {
			feld[i] = i;
		}
		
	}
	public void mischen(int [] feld){
			Random rand =new Random();
			int s;
			int r;
			for (int i = 0; i < feld.length; i++) {
				r = rand.nextInt(feld.length);
				s = feld[r];
				feld[r] = feld[i];
				feld[i] = s;
				//12345
				sleepfor(1000000000/(feld.length));
			}
		
	}
	
	public void reverse(int[] feld) {
		int safe;
		for (int i = 0; i < (feld.length/2)-1; i++) {
			safe = feld[i];
			feld[i] = feld[(feld.length-i)-1];
			feld[(feld.length-i)-1] = safe;
			//12345
			sleepfor((1000000000/(feld.length))*2);
		}
	}
	
	public void tunnel(int[] feld) {
		//12345
		sleepfor((1000000000/(feld.length)));
	}
	
	public void bubblesort(int[] zusortieren) {
			int temp;
			for(int i=1; i<zusortieren.length; i++) {
				for(int j=0; j<zusortieren.length-i; j++) {
					if(zusortieren[j]>zusortieren[j+1]) {
						temp=zusortieren[j];
						zusortieren[j]=zusortieren[j+1];
						zusortieren[j+1]=temp;
						Frame.counter+=1;
					}
					
				}
				//12345
				sleepfor((1000000000)/(zusortieren.length/4));
			}
		
	}
	
	public void insertionSort(int[] sortieren) {
		int temp;
		for (int i = 1; i < sortieren.length; i++) {
			temp = sortieren[i];
			int j = i;
			while (j > 0 && sortieren[j - 1] > temp) {
				sortieren[j] = sortieren[j - 1];
				j--;
				Frame.counter+=1;
			}
			sortieren[j] = temp;
			//12345
			sleepfor((1000000000)/(sortieren.length/4));
		}
		
	}
	

    public void quickSort(int[] arr, int start, int end){
 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    public  int partition(int[] arr, int start, int end){
        int pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
                Frame.counter+=1;
            }
        }
     
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        //12345
		sleepfor((100000000)/(arr.length*4));
        return start;
    }
	
    
    public  void LSD_sort(int[] a) {
        final int BITS = 32;                 // each int is 32 bits 
        final int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        final int MASK = R - 1;              // 0xFF
        final int w = BITS / BITS_PER_BYTE;  // each int is 4 bytes

        System.out.println(R);
        int n = a.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {         

            int[] count = new int[R+1];
            for (int i = 0; i < n; i++) {           
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
                
            }

            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            if (d == w-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
                
            }

            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                aux[count[c]++] = a[i];
               
            }

            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            //12345
            sleepfor((100000000)/(a.length/4));
            }
        }
    }
    
    public void cycleSort (int arr[], int n) 
    { 
   
        int writes = 0; 

        for (int cycle_start=0; cycle_start<=n-2; cycle_start++) 
        { 
            int item = arr[cycle_start]; 
  
         
            int pos = cycle_start; 
            for (int i = cycle_start+1; i<n; i++) 
                if (arr[i] < item) 
                    pos++; 
  
           
            if (pos == cycle_start) 
                continue; 
  
            while (item == arr[pos]) 
                pos += 1; 
  
            if (pos != cycle_start) 
            { 
                int temp = item; 
                item = arr[pos]; 
                arr[pos] = temp; 
                writes++; 
                //12345
                sleepfor((100000000)/(arr.length/4));
            } 
  
            while (pos != cycle_start) 
            { 
                pos = cycle_start; 
  
                for (int i = cycle_start+1; i<n; i++) 
                    if (arr[i] < item) 
                        pos += 1; 
  
                while (item == arr[pos]) 
                    pos += 1; 
  
                if (item != arr[pos]) 
                { 
                    int temp = item; 
                    item = arr[pos]; 
                    arr[pos] = temp; 
                    writes++; 
                    //12345
                    sleepfor((100000000)/(arr.length/4));
                } 
            } 
        } 
    } 
    
    void merge(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 =  r - m; 
      
        int[]L = new int[n1];
        int[]R = new int [n2]; 
      
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; // Initial index of first subarray 
        j = 0; // Initial index of second subarray 
        k = l; // Initial index of merged subarray 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
            //12345
            sleepfor((100000000)/(arr.length/4));
        } 
      
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
      
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
      
    void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = l+(r-l)/2; 
      
            mergeSort(arr, l, m); 
            mergeSort(arr, m+1, r); 
      
            merge(arr, l, m, r); 
        } 
    } 
    
    public void heapsort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i); 
      
        }
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
            
        } 
    } 
    
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            //12345
            sleepfor((100000000)/(arr.length/4));
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
        
    } 
    
    void Selectionsort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
            //12345
            sleepfor((100000000)/(arr.length/4));
        } 
    } 
	
    public void radixsort(int arr[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
     int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
    
     void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
            //12345
            sleepfor((100000000)/(arr.length/4));
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) {
            arr[i] = output[i]; 
            //12345
            sleepfor((100000000)/(arr.length/4));
        }
    } 
     
     int Shellsort(int arr[]) 
     { 
         int n = arr.length; 
   
         // Start with a big gap, then reduce the gap 
         for (int gap = n/2; gap > 0; gap /= 2) 
         { 
             // Do a gapped insertion sort for this gap size. 
             // The first gap elements a[0..gap-1] are already 
             // in gapped order keep adding one more element 
             // until the entire array is gap sorted 
             for (int i = gap; i < n; i += 1) 
             { 
                 // add a[i] to the elements that have been gap 
                 // sorted save a[i] in temp and make a hole at 
                 // position i 
                 int temp = arr[i]; 
   
                 // shift earlier gap-sorted elements up until 
                 // the correct location for a[i] is found 
                 int j; 
                 for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                     arr[j] = arr[j - gap]; 
                     //12345
                     sleepfor((100000000)/(arr.length/4));
                 }
                 // put temp (the original a[i]) in its correct 
                 // location 
                 arr[j] = temp; 
                 //12345
                 sleepfor((100000000)/(arr.length/4));
             } 
         } 
         return 0; 
     } 
     

     static int RUN = 32; 
     
    
     public void insertionSort(int[] arr, int left, int right)  
     { 
         for (int i = left + 1; i <= right; i++)  
         { 
             int temp = arr[i]; 
             int j = i - 1; 
             while (arr[j] > temp && j >= left) 
             { 
                 arr[j + 1] = arr[j]; 
                 j--; 
             } 
             arr[j + 1] = temp; 
         } 
     } 
   
     
     public void mergeS(int[] arr, int l,  
                                 int m, int r) 
     { 
         // original array is broken in two parts  
         // left and right array  
         int len1 = m - l + 1, len2 = r - m; 
         int[] left = new int[len1]; 
         int[] right = new int[len2]; 
         for (int x = 0; x < len1; x++)  
         { 
             left[x] = arr[l + x]; 
         } 
         for (int x = 0; x < len2; x++)  
         { 
             right[x] = arr[m + 1 + x]; 
         } 
   
         int i = 0; 
         int j = 0; 
         int k = l; 
   
         // after comparing, we merge those two array  
         // in larger sub array  
         while (i < len1 && j < len2)  
         { 
             if (left[i] <= right[j])  
             { 
                 arr[k] = left[i]; 
                 i++; 
             } 
             else 
             { 
                 arr[k] = right[j]; 
                 j++; 
             } 
             k++; 
         } 
   
         // copy remaining elements of left, if any  
         while (i < len1) 
         { 
             arr[k] = left[i]; 
             k++; 
             i++; 
         } 
   
         // copy remaining element of right, if any  
         while (j < len2)  
         { 
             arr[k] = right[j]; 
             k++; 
             j++; 
         } 
     } 
   
     
     public void timSort(int[] arr, int n)  
     { 
           
         // Sort individual subarrays of size RUN  
         for (int i = 0; i < n; i += RUN)  
         { 
             insertionSort(arr, i, Math.min((i + 31), (n - 1))); 
         } 
   
         // start merging from size RUN (or 32). It will merge  
         // to form size 64, then 128, 256 and so on ....  
         for (int size = RUN; size < n; size = 2 * size)  
         { 
               
             // pick starting point of left sub array. We  
             // are going to merge arr[left..left+size-1]  
             // and arr[left+size, left+2*size-1]  
             // After every merge, we increase left by 2*size  
             for (int left = 0; left < n; left += 2 * size)  
             { 
                   
                 // find ending point of left sub array  
                 // mid+1 is starting point of right sub array  
                 int mid = left + size - 1; 
                 int right = Math.min((left + 2 * size - 1), (n - 1)); 
   
                 // merge sub array arr[left.....mid] &  
                 // arr[mid+1....right]  
                 mergeS(arr, left, mid, right); 
             } 
         } 
     } 
     
     private final static boolean ASCENDING=true, DESCENDING=false;
     private int[] a;
     
     public void sortbio(int[] a)
     {
    	 this.a=a;
         bitonicSort(0, a.length, ASCENDING);
     }

     private void bitonicSort(int lo, int n, boolean dir)
     {
         if (n>1)
         {
             int m=n/2;
             bitonicSort(lo, m, ASCENDING);
             bitonicSort(lo+m, m, DESCENDING);
             bitonicMerge(lo, n, dir);
         }
     }

     private void bitonicMerge(int lo, int n, boolean dir)
     {
         if (n>1)
         {
             int m=n/2;
             for (int i=lo; i<lo+m; i++)
                 compare(i, i+m, dir);
             bitonicMerge(lo, m, dir);
             bitonicMerge(lo+m, m, dir);
         }
     }

     private void compare(int i, int j, boolean dir)
     {
         if (dir==(a[i]>a[j]))
             exchange(i, j);
     }

     private void exchange(int i, int j)

     {
         int t=a[i];
         a[i]=a[j];
         a[j]=t;
         //12345
         sleepfor((100000000)/(a.length/4));
     }

	public void sleepfor(long nanosec) {
		long timeElapse;
		final long starttime = System.nanoTime();
		do {
			timeElapse = System.nanoTime() -starttime;
		} while (timeElapse<nanosec);
	}
}
