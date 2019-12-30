package sort2;

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
				draw.rePaint();
				sleepfor(1000000000/feld.length);
			}
		
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
				draw.rePaint();
				sleepfor(1000000000/zusortieren.length);
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
			draw.rePaint();
			sleepfor(1000000000/sortieren.length);
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
            draw.rePaint();
    		sleepfor(1000000000/arr.length);
        }
       
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
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
            draw.rePaint();
    		sleepfor(2000000000/a.length);
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
                draw.rePaint();
        		sleepfor(2000000000/arr.length);
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
                    draw.rePaint();
            		sleepfor(2000000000/arr.length);
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
            draw.rePaint();
    		sleepfor(2000000000/arr.length);
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
            draw.rePaint();
    		sleepfor(200000000/arr.length);
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
        
    } 
	
	public void sleepfor(long nanosec) {
		long timeElapse;
		final long starttime = System.nanoTime();
		do {
			timeElapse = System.nanoTime() -starttime;
		} while (timeElapse<nanosec);
	}
}
