/**
 * Counter to count of things.
 */
public class Counter {
    private int counter;

    /**
     * constructor.
     * @param counter keeps count.
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * add number to current count.
     * @param number to increase the counter.
     */
    void increase(int number) {
        counter += number;
    }

    /**
     *  subtract number from current count.
     * @param number to subtract.
     */
    void decrease(int number) {
        counter -= number;
    }

    /**
     * get current count.
     * @return value of counter.
     */
    int getValue() {
        return counter;
    }
}