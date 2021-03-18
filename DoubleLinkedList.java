
class ListNode{
    private int val;
    private ListNode next;
    private ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
}

public class DoubleLinkedList {
    private ListNode head;
    private ListNode last;
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            node.setNext(this.head);
            head.setPrev(node);
            head = node;
        }

    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            last.setNext(node);
            node.setPrev(last);
            last = node;
        }

    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index < 0 || index > size()){
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        if(index == size()){
            addLast(data);
            return true;
        }
        ListNode cur = this.head;
        while(index != 0){
            cur = cur.getNext();
            index--;
        }
        ListNode node = new ListNode(data);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        node.getPrev().setNext(node);
        cur.setPrev(node);
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){

        if(this.head == null){
            return false;
        }
        ListNode cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                return true;
            }else{
                cur = cur.getNext();
            }
        }
        return false;

    }
    public ListNode findKey(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode list = findKey(key);
        if(list == null){
            return;
        }
        if(list == head){
            this.head = head.getNext();
            this.head.setPrev(null);
            return;
        }
        if(list == last){

            this.last = last.getPrev();
            this.last.setNext(null);
            //list.getPrev().setNext(null);
            //this.last = this.last.getPrev();
            return;
        }
        list.getPrev().setNext(list.getNext());
        list.getNext().setPrev(list.getPrev());
    }

    public void remove2(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                if(cur == this.head){
                    if(this.head.getNext() == null){
                        this.head = null;
                    }else{
                        this.head = head.getNext();
                        this.head.setPrev(null);
                    }
                }else if(cur == this.last){
                    this.last = last.getPrev();
                    this.last.setNext(null);
                }else{
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                }
                return;
            }
            cur = cur.getNext();
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.getVal() == key){
                if(cur == this.head){
                    if(this.head.getNext() == null){
                        this.head = null;
                    }else{
                        this.head = head.getNext();
                        this.head.setPrev(null);
                    }
                }else if(cur == this.last){
                    this.last = last.getPrev();
                    this.last.setNext(null);
                }else{
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                }
            }
            cur = cur.getNext();
        }

    }
    //得到单链表的长度
    public int size(){
        if(this.head == null){
            return 0;
        }
        ListNode cur = this.head;
        int tmp = 0;
        while(cur != null){
            tmp++;
            cur = cur.getNext();
        }
        return  tmp;

    }
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println();

    }
    public void clear(){
        this.head = null;
        this.last = null;


    }


}
