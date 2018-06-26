public class Stack{
    private int size;
    private int[] stack;
    private int top;
    Stack(int s){
        this.size = s;//栈的尺寸
        this.stack = new int[size];//用数组构造栈的主体
        this.top = -1;//栈中最后一个元素的标记
    }
    public boolean isEmpty(){//检验栈是否为空
        if(top == -1){
            return true;
        }
        return false;
    }
    public void push(int x){//向栈中压入元素
        if(top == size - 1){
            System.out.println("out of size");
            return;
        }
        top++;
        stack[top] = x;
    }
    public int pop() throws Exception{//弹出最后一个元素
        if(isEmpty()){
            throw new Exception("underflow");
        }
        else{
            int x = stack[top];
            top--;
            return x;
        }
    }
    public static void main(String[] args) throws Exception{
        Stack s1 = new Stack(10);
        for(int i = 0;i < 10;i++){
            s1.push(i);
            System.out.print(s1.stack[i] + "\t");
        }
        System.out.println(s1.pop());
    }
}