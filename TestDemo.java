import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestDemo {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(4);
        list.addLast(3);
        list.addFirst(1);
        list.display();
        list.remove2(4);
        list.display();
        list.removeAllKey(3);
        list.display();
    }
    public static void main1(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(4);
        list.addLast(3);

        list.display();
        list.addIndex(0,10);
        list.display();
        list.addIndex(2,11);
        list.display();
        list.remove(3);
        list.display();


    }

}
