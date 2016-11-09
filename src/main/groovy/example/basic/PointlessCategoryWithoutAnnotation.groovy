package example.basic

class PointlessCategoryWithoutAnnotation {

    static Operator incrementMe(Operator operator) {
        operator.value = operator.value + 1
        operator
    }
}
