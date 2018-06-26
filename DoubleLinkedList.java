//java中不具备指针；故而所有的连接都是以对象句柄的形式代替．
public class DoubleLinkedList{
    Node head = null;
    class Node{
        private int data;
        private Node next = null;
        private Node prev = null;
        Node(int d){
            this.data = d;
        }
    }
    public void addNode(int d){//在链表头节点前端添加新节点，构建双向连接，链表头部若为空，则其不具备指向新节点的连接
        Node newnode = new Node(d);
        newnode.next = head;
        if(head != null){//头部非空，假设指向新节点的连接
            head.prev = newnode;
        }
        head = newnode;
        newnode.prev = null;
    }
    public Node searchNode(int d){//查找具有特定内容的节点
        Node n = head;
        while(n != null && n.data != d){//从链表头部遍历整个链表，返回该节点或空值
            n = n.next;
        }
        return n;
    }
    public void deleteNode(int d){//删除特定节点
        Node x = searchNode(d);//先检索该节点的对象句柄
        if(x == null){
            System.out.println("no such node");
            return;
        }
        if(x.prev != null){//节点向前的连接指向非空，即其前端有节点存在
            x.prev.next = x.next;
        }
        else{//若节点前端为空，则其为链表头部
            head = x.next;//更新头部节点位置，在删除头节点后头部节点应为后一位
        }
        if(x.next != null){//后方有节点存在
            x.next.prev = x.prev;//使后方节点指向制定节点的前方节点
        }
    }
    public int getlength(){
        Node x = head;
        int len = 0;
        while(x != null){
            x = x.next;
            len++;
        }
        return len;
    }
    public static void main(String[] args){
        DoubleLinkedList l1 = new DoubleLinkedList();
        for(int i = 0;i < 10;i++){
            l1.addNode(i);
        }
        System.out.println(l1.searchNode(5));
        l1.deleteNode(6);
        System.out.println(l1.getlength());
    }
}