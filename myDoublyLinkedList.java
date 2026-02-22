package prolab;

public class myDoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;


    public static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node() {
            this.prev = null;
            this.next = null;
        }
    }

    public myDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addtoEnd(T data){
        Node<T> newNode = new Node<>(data);
        //Ilk eleman ekleme
        if (tail == null){
            head = newNode;
            tail = newNode;
        //Sonuna eleman ekleme
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail =newNode;
        }
    }

    public void addtoPosition(T data,int position){
        Node<T> newNode = new Node<>(data);
        Node<T> iter = new Node<>();
        //Istenen pozisyon ilk pozisyonsa
        if (position == 1){
            add(data);
        }
        else {
            iter = head;
            int i=1;
            while(iter != null && i<position){
                iter = iter.next;
                i++;
            }
            //Istenen pozisyon son pozisyonsa
            if (iter == null){
                addtoEnd(data);
            }
            //Istenen posizyon arada bir pozisyondaysa
            else{
                newNode.next = iter;
                newNode.prev = iter.prev;
                iter.prev.next = newNode;
                iter.prev = newNode;
            }
        }
    }

    public void add(T data){ //Add to begin
        Node<T> newNode = new Node<>(data);
        //Ilk eleman ekleme
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        //Basina eleman ekleme
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void removefromBegin(){
        Node<T> temp = new Node<>();
        //LinkedList bossa
        if(head == null){
            System.out.println("ERROR: Linked List is already empty!!!");
            return;
        }
        //LinkedList de bir tane eleman varsa
        else if(head == tail){
            head = null;
            tail = null;
            return;
        }
        //LinkedList de birden fazla eleman varsa
        else{
            temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
    }

    public void removewithPosition(int position){
        Node<T> deleteNode = new Node<>(); //Silinecek node
        Node<T> iter = new Node<>(); //Gezen node
        iter = head;
        //LinkedList bossa
        if(head == null){
            System.out.println("ERROR: Linked List is already empty!!!");
            return;
        }
        //Istenilen pozisyon ilk pozisyonsa
        if (position == 1){
            removefromBegin();
            return;
        }
        else{
            int i=1;
            while (iter != null && i<position){
                iter = iter.next;
                i++;
            }
            //Istenilen pozisyon linked list de yoksa
            if (iter == null){
                System.out.println("ERROR: LinkedList is not that long!!!");
            }
            //Istenilen pozisyon son pozisyonsa
            else if (iter == tail){
                removefromEnd();
                return;
            }
            //Istenilen pozisyon arada bir pozisyondaysa
            else {
                iter.prev.next = iter.next;
                iter.next.prev = iter.prev;
                iter.next = null;
                iter.prev = null;
            }
        }
    }

    public void removefromEnd(){
        Node<T> temp = new Node<>();
        //LinkedList bossa
        if(tail == null){
            System.out.println("ERROR: Linked List is already empty!!!");
            return;
        }
        //LinkedList de bir tane eleman varsa
        else if(head == tail){
            head = null;
            tail = null;
            return;
        }
        //LinkedList de birden fazla eleman varsa
        else{
            temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
    }

    public void removewithValue(T data) {
        Node<T> iter = head;
        if (head == null) {
            System.out.println("ERROR: Linked List is already empty!!!");
            return;
        }
        // Linked List bos mu kontrolu
        while (iter != null && !iter.data.equals(data)) {
            iter = iter.next;
        }

        // Istenilen pozisyon ilk pozisyonsa
        if (iter == head) {
            removefromBegin();
        }
        // Istenilen pozisyon linked list de yoksa
        else if (iter == null) {
            System.out.println("ERROR: The value you are looking for is not in the linked list!!!");
        }
        // Istenilen pozisyon son pozisyonsa
        else if (iter == tail) {
            removefromEnd();
        }
        // Istenilen pozisyon arada bir pozisyondaysa
        else {
            iter.prev.next = iter.next;
            iter.next.prev = iter.prev;
        }
    }


    public void displayAll(){
        Node<T> iter = head;
        while (iter != null ){
            System.out.println(iter.data+" ");
            iter = iter.next;
        }
        System.out.println();
    }

    public T get(int position) {
        Node<T> iter = head;
        int i = 1;
        while (iter != null && i < position) {
            iter = iter.next;
            i++;
        }
        if (iter == null) {
            System.out.println("ERROR: LinkedList is not that long!!!");
            return null;
        } else {
            return iter.data;
        }
    }

    public Node<T> getNode(int index) {
        Node<T> iter = head;
        int i = 0;
        while (iter != null && i < index) {
            iter = iter.next;
            i++;
        }
        return iter;
    }

    public int size() {
        int count = 0;
        Node<T> iter = head;
        while (iter != null) {
            count++;
            iter = iter.next;
        }
        return count;
    }














}
