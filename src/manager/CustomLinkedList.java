package manager;

import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomLinkedList {
    private final Map<Integer, CustomLinkedList.Node<Task>> mapToList = new HashMap<>();
    private int size = 0;
    private Node<Task> first;
    private Node<Task> last;

    public void linkLast(Task task) {
        if (mapToList.containsKey(task.getId())) {
            removeNode(mapToList.get(task.getId()));
        }
        final Node<Task> l = last;
        final Node<Task> newNode = new Node<>(l, task, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        mapToList.put(task.getId(), newNode);
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        for (Node<Task> newNode = first; newNode != null; newNode = newNode.next) {
            tasks.add(newNode.task);
        }
        return tasks;
    }

    public void removeNode(Node<Task> newNode) {
        Node<Task> next = newNode.next;
        Node<Task> prev = newNode.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            newNode.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            newNode.next = null;
        }
        newNode.task = null;
        size--;
    }

    public void removeId(int id) {
        if (mapToList.containsKey(id)) {
            removeNode(mapToList.get(id));
        }
    }

    private static class Node<T> {
        T task;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T task, Node<T> next) {
            this.task = task;
            this.next = next;
            this.prev = prev;
        }
    }
}