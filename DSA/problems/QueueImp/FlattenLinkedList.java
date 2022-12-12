package QueueImp;

import LinkedListImp.LinkedList;

public class FlattenLinkedList {
    public Node head;

    public static void main(String[] args) {
        FlattenLinkedList ob = new FlattenLinkedList();
        ob.make();

        LinkedList<Integer> FlattenedLinkedList = ob.flatten();
        System.out.println(FlattenedLinkedList);
    }

    public void make() {
        head = new Node(1);
        Node tail = head.addDown(6).addNext(7);
        tail.addDown(11);
        tail.addNext(8).addDown(12).addDown(15);
        tail = head.addNext(2).addNext(3).addNext(4);
        tail.addNext(5);
        tail = tail.addDown(9);
        tail.addNext(10);
        tail = tail.addDown(13);
        tail.addNext(14);
        tail = tail.addDown(16);
        tail.addNext(17);
    }

    public LinkedList<Integer> flatten() {
        LinkedList<Integer> ll = new LinkedList<>();
        Queue<Node> queue = new Queue<>();
        Node current;
        queue.push(head);

        while(!queue.isEmpty()){
            current=queue.pop();
            while(current!=null){
                ll.add(current.data);
                if(current.down!=null){
                    queue.push(current.down);
                }
                current=current.next;
            }
        }

        return ll;
    }

    public static class Node {
        Integer data;
        Node next;
        Node down;

        public Node(Integer data) {
            this.data = data;
            next = null;
            down = null;
        }

        public Node addNext(Integer data) {
            Node element = new Node(data);
            this.next = element;
            return element;
        }

        public Node addDown(Integer data) {
            Node element = new Node(data);
            this.down = element;
            return element;
        }
    }
}