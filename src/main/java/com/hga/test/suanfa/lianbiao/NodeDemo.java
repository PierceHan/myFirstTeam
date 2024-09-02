package com.hga.test.suanfa.lianbiao;

public class NodeDemo {

    public static void main(String[] args) {
        Node head = getNodeHead();

        printNode(head, "1");
        head = reverseNode(head);
        printNode(head, "2");

        head = reverseNode(head);
        printNodeReverse(head);

        Node midNode = findMidNode(head);
        printNode("中间节点", midNode);
    }

    private static Node getNodeHead(){
        Node aNode = new Node(0);
        Node bNode = new Node(1);
        Node cNode = new Node(2);
        Node dNode = new Node(3);

        aNode.setNext(bNode);
        bNode.setNext(cNode);
        cNode.setNext(dNode);
        return aNode;
    }

    private static void printNode(String detail, Node node){
        if (node == null) {
            return;
        }
        System.out.println(detail + ":" + node.getValue());
    }

    /**
     * 寻找链表的中间节点。
     *
     * @param head 链表的头节点
     * @return 链表的中间节点
     */
    private static Node findMidNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }


    /**
     * 倒序打印列表
     *
     * @param node
     */
    private static void printNodeReverse(Node node){
        if (node == null) {
            return;
        }
        printNodeReverse(node.getNext());
        System.out.println(node.getValue());
    }


    /**
     * 反转链表，修改链表的顺序，使得链表中的节点按照相反的顺序排列。
     *
     * @param head 链表的头节点
     * @return 返回最新的头节点
     */
    private static Node reverseNode(Node head) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;
        Node nextNode = currentNode.getNext();
        currentNode.setNext(null);

        while (nextNode != null) {
            Node tempNode = nextNode.getNext();
            nextNode.setNext(currentNode);
            currentNode = nextNode;
            nextNode = tempNode;
        }

        head = currentNode;
        return head;
    }


    /**
     * 打印链表中的所有节点的值和指定的ID。
     *
     * @param head 链表的头节点
     * @param id   指定的ID
     */
    private static void printNode(Node head, String id) {
        if (head == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        Node currentNode = head;

        while (currentNode != null) {
            String nodeValue = currentNode.getValue().toString();
            sb.append(nodeValue).append("/").append(id).append("\n");
            currentNode = currentNode.getNext();
        }

        System.out.print(sb);
    }


}
