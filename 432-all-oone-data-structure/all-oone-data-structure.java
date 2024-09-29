class AllOne {
    private class Node {
        int count;
        LinkedHashSet<String> keys;
        Node prev, next;
        
        Node(int c) {
            count = c;
            keys = new LinkedHashSet<>();
        }
    }

    private Map<String, Node> keycount;
    private Node head, tail;

    public AllOne() {
        keycount = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    private Node addNode(Node curr, int count) {
        Node newnode = new Node(count);
        newnode.next = curr.next;
        newnode.prev = curr;
        curr.next.prev = newnode;
        curr.next = newnode;
        return newnode;
    }

    private void removeNode(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public void inc(String key) {
        if (!keycount.containsKey(key)) {
            if (head.next == tail || head.next.count != 1) {
                addNode(head, 1);
            }
            head.next.keys.add(key);
            keycount.put(key, head.next);
        } else {
            Node currnode = keycount.get(key);
            int currcount = currnode.count;
            if (currnode.next == tail || currnode.next.count != currcount + 1) {
                addNode(currnode, currcount + 1);
            }
            currnode.next.keys.add(key);
            keycount.put(key, currnode.next);
            currnode.keys.remove(key);
            if (currnode.keys.isEmpty()) {
                removeNode(currnode);
            }
        }
    }

    public void dec(String key) {
        if (!keycount.containsKey(key)) return;

        Node curNode = keycount.get(key);
        int curcount = curNode.count;

        curNode.keys.remove(key);

        if (curcount == 1) {
            keycount.remove(key);
        } else {
            if (curNode.prev == head || curNode.prev.count != curcount - 1) {
                addNode(curNode.prev, curcount - 1);
            }
            curNode.prev.keys.add(key);
            keycount.put(key, curNode.prev);
        }

        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }

    public String getMaxKey() {
        return (tail.prev == head || tail.prev.keys.isEmpty()) ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return (head.next == tail || head.next.keys.isEmpty()) ? "" : head.next.keys.iterator().next();
    }
}
