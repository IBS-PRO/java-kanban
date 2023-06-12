package manager;

import task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomLinkedList {
    private final Map<Integer, Node<Task>> history = new HashMap<>();

    private Node<Task> first;
    private Node<Task> last;

    public void linkLast(Task task) {
        final Node node = new Node(last, task, null);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        history.put(task.getId(), node);
    }

    List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        Node node = first;
        while (node != null) {
            tasks.add((Task) node.task);
            node = node.next;
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
    }

    public void removeId(int id) {
        final Node node = history.remove(id);
        if (node == null) {
            return;
        }
        removeNode(node);
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