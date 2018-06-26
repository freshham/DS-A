public class Queue{
    private int size;
    private int head;
    private int tail;
    private int[] queue;
    Queue(int s){
        this.size = s;//队列尺寸
        this.queue = new int[size];//队列本体
        this.head = -1;//最后一个元素
        this.tail = 0;//第一个元素
    }
    public boolean isEmpty(){//检验队列是否为空
        if(head < tail){
            return true;
        }
        else{
            return false;
        }
    }
    public void inQueue(int x) throws Exception{//入队
        if(head == size - 1){
            throw new Exception("overflow");
        }
        else{
            head++;
            queue[head] = x;
        }
    }
    public int deQueue() throws Exception{//出队，先入先出
        if(isEmpty()){
            throw new Exception("underflow");
        }
        else{
            int x = queue[tail];
            tail++;
            return x;
        }
    }
    public static void main(String[] args) throws Exception{
        Queue q1 = new Queue(10);
        for(int i = 0;i < q1.size;i++){
            q1.inQueue(i);
            System.out.println(q1.queue[i]);
        }
        System.out.println(q1.deQueue());
    }
}