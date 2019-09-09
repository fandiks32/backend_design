package exercise;

public class IQueue<T> implements Queue<T> {

  private Stack<T> forward;
  private Stack<T> reverse;

  IQueue() {
    forward = new Stack<T>();
    reverse = new Stack<T>();
  };

  IQueue(Stack<T> f, Stack<T> r) {
    forward = f;
    reverse = r;
  }

  public T head() {
    if (reverse.isEmpty()) {
      forward2reverse();
    }
    return reverse.head;
  }

  public Queue<T> enQueue(T t) {
    return new IQueue<T>(this.forward.push(t), this.reverse);
  }

  public Queue<T> deQueue() {
    if (isEmpty()) {
      return new IQueue<T>();
    } else if (!reverse.isEmpty()) {
      return new IQueue<T>(this.forward, this.reverse.tail);
    } else {
      return new IQueue<T>(new Stack<T>(), forward.reversing().tail);
    }
  }

  public boolean isEmpty() {
    return forward.isEmpty() && reverse.isEmpty();
  }

  // private ----

  private void forward2reverse() {
    reverse = forward.reversing();
    forward = new Stack<T>();
  }

  private class Stack<T> {
    public T head;
    public Stack<T> tail;
    public Integer size;

    private Stack(T t, Stack<T> tail) {
      this.head = t;
      this.tail = tail;
      this.size = tail.size + 1;
    }

    private Stack() {
      this.head = null;
      this.tail = null;
      this.size = 0;
    }

    public Stack<T> push(T t) {
      return new Stack<T>(t, this);
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public Stack<T> reversing() {
      Stack<T> stack = new Stack<T>();
      Stack<T> walker = this;
      while (!walker.isEmpty()) {
        stack = stack.push(walker.head);
        walker = walker.tail;
      }
      return stack;
    }
  }
}