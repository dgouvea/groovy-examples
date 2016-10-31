package example.basic

class Operator {

    int value

    Operator(int value) {
        this.value = value
    }

    Operator plus(int i) {
        new Operator(value + i)
    }

    Operator minus(int i) {
        new Operator(value - i)
    }

    Operator multiply(int i) {
        new Operator(value * i)
    }

    Operator div(int i) {
        new Operator((value / i).intValue())
    }

    Operator next() {
        new Operator(value + 1)
    }

    Operator previous() {
        new Operator(value - 1)
    }

    Operator negative() {
        new Operator(value * -1)
    }

    void leftShift(int i) {
        value += i
    }

}
