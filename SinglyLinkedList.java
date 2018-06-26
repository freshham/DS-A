public class SinglyLinkedList{
    Node head = null;
    class Node{
        int data;
        Node next = null;
        //int prev;
        Node(int k){
            this.data = k;
        }
    }
    public void addNode(int k){
        Node newnode = new Node(k);
        if(head == null){
            head = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }
    public boolean deleteNode(int k){
        if(head.data == k){
            head = head.next;
            return true;
        }
        Node prenode = head;
        Node curnode = prenode.next;
        while(curnode != null){
            prenode = curnode;
            curnode = prenode.next;
            if(curnode.data == k){
                prenode.next = curnode.next;
                curnode.next = curnode;
                return true;
            }
        }
        return false;
    }
    public Node searchList(int k){
        Node x = head;
        while(x != null){
            if(x.data == k){
                return x;
            }
            x = x.next;
        }
        return head;
    }
    public int getLength(){
        int l = 0;
        Node tem = head;
        while(tem != null){
            tem = tem.next;
            l++;
        }
        return l;
    }
    public static void main(String[] args){
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.addNode(5);
        l1.addNode(6);
        l1.addNode(7);
        l1.addNode(8);
        System.out.println(l1.deleteNode(6));
        //System.out.println(l1.searchList(6));
        System.out.println(l1.getLength());
    }
}