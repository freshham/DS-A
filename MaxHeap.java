public class MaxHeap{
    private int[] arr;
    private int num;
    void getArr(){//输出整个堆的方法．．而已
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
    }
    void exchange(int[] x,int a,int b){//做一个位置转换的方法而已
        int k = x[a];
        x[a] = x[b];
        x[b] = k;
    }
    int HeapExtractMax(){//提取最大值的方法而已
        int max = this.arr[0];
        exchange(arr, 0, arr.length - 1);
        arr[arr.length - 1] = 0;
        MaxHeapify(arr, 0);
        return max;
    }
    int HeapMaximum(){//返回最大值的方法而已
        return arr[0];
    }
    void HeapIncreaseKey(int[] x,int i,int k){//提高堆中某元素的值
        if(i >= x.length){
            System.out.println("out of range");
            return;
        }
        if(k < x[i]){
            System.out.println("that's not enough big");
            return;
        }
        x[i] = k;
        for(int j = i;j >= 0;j--){
            MaxHeapify(x, j);
        }
    }
    void HeapInsert(int[] x,int k){//一个向堆内插入元素的方法
        int[] y = new int[x.length + 1];
        y[x.length] = k;
        for(int i = 0;i < x.length;i++){
            y[i] = x[i];
        }
        BuildHeap(y);
    }
    void MaxHeapify(int[] x,int i){//维护最大堆的性质，就是父节点最大
        int parent = i;
        int left = 2*parent + 1;
        int right = 2*(parent + 1);
        int index = parent;
        while(left < x.length && right < x.length){
            //System.out.println(parent);
            int max = x[parent];
            if(x[left] > max){
                max = x[left];
                index = left;
            }
            if(x[right] > max){
                max = x[right];
                index = right;
            }
            if(max != x[parent]){
                exchange(x,parent,index);
                parent = index;
                left = 2*parent + 1;
                right = 2*(parent + 1);
            }
            else{
                break;
            }
        }
    }
    void BuildHeap(int[] x){//建堆
        for(int i = x.length/2; i >= 0; i--){
            MaxHeapify(x,i);
        }
        this.arr = new int[x.length];
        for(int i = 0;i < x.length;i++){
            this.arr[i] = x[i];
        }
    }
    int[] HeapSort(int[] x){//每次取出堆中的最大值，并重构堆.
        BuildHeap(x);
        int[] y = new int[x.length];
        for(int i = x.length - 1;i >= 0;i--){
            y[x.length - i - 1] = x[0];
            exchange(x, i, 0);
            x[i] = 0;
            MaxHeapify(x, 0);
        }
        return y;
    }
    public static void main(String[] args){
        int[] x = {1,7,6,5,2,4};
        MaxHeap m = new MaxHeap();
        m.HeapInsert(x, 15);
        //m.BuildHeap(x);
        //m.HeapIncreaseKey(x, 3, 10);
        // for(int i = 0;i < x.length;i++){
        //     System.out.print(x[i]);
        //     System.out.print("\t");
        // }
        //System.out.print("\n" + max + "\n");
        m.getArr();
    }
}
