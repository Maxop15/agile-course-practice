package Deque.java;

public class Deque<Type> {
    private Type[] deque;
    private static int CurrentSize;
    private static int CurrentMaxSize;

    public Deque() {
        this.CurrentMaxSize = 100;
        this.CurrentSize = 0;
        this.deque = (Type[]) new Object[CurrentMaxSize];
    }

    public static int GetCurrentSize() {
        return CurrentSize;
    }

    public void PushHeadElement(Type Element) {
        this.IncreaseDeque();
        for (int i = this.CurrentSize; i > 0; i--) {
            this.deque[i] = this.deque[i - 1];
        }
        this.deque[0] = Element;
        this.CurrentSize++;
    }

    public void Clear() {
        this.CurrentSize = 0;
    }

    public Type PopHeadElement() {
        if (!this.IsEmpty()) {
            Type PopElement = this.deque[0];
            for (int i = 0; i < this.CurrentSize - 1; i++) {
                this.deque[i] = this.deque[i + 1];
            }
            this.CurrentSize--;
            return PopElement;
        }
        else return null;
    }

    public void PushTailElement(Type Element) {
        this.IncreaseDeque();
        this.deque[CurrentSize] = Element;
        this.CurrentSize++;
    }

    public Type PopTailElement() {
        if(!this.IsEmpty()) {
            return this.deque[--CurrentSize];
        }
        else return null;
    }

    public boolean IsEmpty() {
        return this.CurrentSize == 0;
    }

    private void IncreaseDeque() {
        if(this.CurrentMaxSize == this.CurrentSize) {
            this.CurrentMaxSize += 100;
            Type[] NewDeque = (Type[]) new Object[this.CurrentMaxSize];
            for (int i = 0; i < this.CurrentSize; i++) {
                NewDeque[i] = this.deque[i];
            }
            this.deque = NewDeque;
        }
    }
}
