//Name: Connor Noonan
//Student ID: 101316377

package assignment1;


public class coreData {
    private int[] m_array;
    private int numEl;
    private int maxSize;
    
    public coreData(int size)
    {
        maxSize = size;
        numEl = 1;
        m_array = new int[maxSize];
    }
    
    public void addLast(int item){
        if (numEl<maxSize){
            m_array[numEl] = item;
            numEl++;           
        }      
    }
    
    public void addInOrder(int item){
        if (numEl<maxSize){
            m_array[numEl] = item;
            numEl++;           
        } 
        
        int temp = m_array[numEl-1]; 
        int presPos =numEl-2;
        while (presPos>=0 && m_array[presPos]<temp){
            m_array[presPos+1]=m_array[presPos];
            presPos--;
        }
        m_array[presPos+1]=temp;      
    }
    
    public void selectionSort(){     
        for (int i=0; i<numEl-1;i++){
            int min =i;
            for (int index=i+1; index<numEl;index++){
                if (m_array[index]>m_array[min]){
                    min=index;
                }
            }      
            int temp =m_array[i];
            m_array[i]=m_array[min];
            m_array[min]=temp;
        }
    }   
    
    public void insertionSort(){
        for (int i=1; i <numEl; i++){
            int temp = m_array[i]; 
            int presPos =i-1;
            while (presPos>=0 && m_array[presPos]<temp){
                m_array[presPos+1]=m_array[presPos];
                presPos--;
            }
            m_array[presPos+1]=temp;      
        }           
    }
        
    public void mergeSort() {
        mergeSortWorker(0, numEl-1);
    }
    
    public void mergeSortWorker(int left, int right){
        if (left<right){
            int mid = (left+right)/2;
            mergeSortWorker(left,mid);
            mergeSortWorker(mid+1, right);
            merge(left,mid,right);
        }
    }
    
    public void merge(int left, int mid, int right) {
        int[] leftArray = new int[mid-left+1];
        int[] rightArray = new int[right-mid];
        
        for (int x=0;x<leftArray.length;x++) {
            leftArray[x] = m_array[left+x];
        }
        
        for (int x=0;x<rightArray.length;x++) {
            rightArray[x] = m_array[mid+1+x];
        }
        
        int p1=0,p2=0,pM=left;
        
        while(p1<leftArray.length && p2 <rightArray.length) {
            if (leftArray[p1]>rightArray[p2]) {
                m_array[pM]=leftArray[p1];
                p1++;
            }
            else{
                m_array[pM]=rightArray[p2];
                p2++;
            }
            pM++;
        }
        
        while (p1<leftArray.length){
            m_array[pM]=leftArray[p1];
            p1++;
            pM++;
        }
        
        while (p2<rightArray.length){
            m_array[pM]=rightArray[p2];
            p2++;
            pM++;
        }
    }
    
    public void quickSort() {
        quickSortWorker(0, numEl-1);
    }
    
    public void quickSortWorker(int lo, int hi){
        if(lo<hi){
            int pivot = partition(lo,hi);
            quickSortWorker(lo,pivot-1);
            quickSortWorker(pivot+1,hi);
        }
    }
    
    private void swap (int loc1, int loc2){
        int temp = m_array[loc1];
        m_array[loc1]=m_array[loc2];
        m_array[loc2]=temp;
    }
    
    public int partition (int lo, int hi){
        int pivot = m_array[hi];
        int marker = lo -1;
        for(int x=lo; x<hi; x++){
            if (m_array[x]>pivot){
                marker++;
                swap(x,marker);   
            }
        }
        swap(hi, marker+1);
        return marker+1;
            
    }
    
    public int binarySearch(int key){
        int lo=0,hi=numEl-1,mid;
        
        while (lo<=hi){
            mid = (lo+hi)/2;
            if (m_array[mid]==key) return mid;
            if (m_array[mid]>key)
                hi=mid-1;
            else
                lo=mid+1;      
        }
        return -1;     
    }
    
    public int linearSearch(int key){
        int x = numEl;
        for (int i = 0; i < x; i++){
            if(m_array[i] == x) return i;
        }
        return -1;
    }
}
