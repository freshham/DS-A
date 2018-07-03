import java.util.Random;

public class QuickSort{
    private int[] arr;//接受外来数组，快速排序操作的对象
    private int size;//尺寸啦
    //private int depth;
    QuickSort(int[] x){//初始化，构造函数
        this.arr = x;
        this.size = x.length - 1;
        quickSort(arr, 0, size);
    }
    void exchange(int[] x,int i,int j){
        int k = x[i];
        x[i] = x[j];
        x[j] = k;
    }
    void quickSort(int[] x,int p,int r){//迭代步骤，每次迭代可根据所选中的主元即标记将原始数组分成两个子数组，并在两个子数组上重复快排
        if(p < r){//刚才愚蠢的我身为愚蠢的人类啊竟然忘记了加上限制条件．．．
            int q = Random_Partition(x, p, r);//老子才是本体哇！
            quickSort(x,p,q - 1);
            quickSort(x,q + 1,r);
        }
    }
    int Random_Partition(int[] x,int p,int r){//对数组随机选择标记进行快速排序
        Random random = new Random();
        int r1 = random.nextInt(r - p + 1) + p;
        exchange(x, r1, r);
        return Partition(x, p, r);
    }
    int Partition(int[] x,int p,int r){//这个是核心，运用左右标记的方法，将比标记小的元素放在标记左边，比标记大的元素放到标记右边
        int j = p;
        int i = p - 1;
        int k = x[r];
        while(j < r){
            if(x[j] < k){
                i++;
                exchange(x,i,j);
            }
            j++;
        }
        exchange(x,i + 1,r);
        return i + 1;
    }
    void getArr(){//这个你不用管它，他就是来输出数组的
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
    }
    public static void main(String[] args){
        int[] x = {1,4,7,8,6,8,5,8,7,5,4,6,78,8,5,4,3,8,5};
        QuickSort q1 = new QuickSort(x);
        q1.getArr();
    }
}