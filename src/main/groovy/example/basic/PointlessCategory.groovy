package example.basic

@Category(Operator)
class PointlessCategory {

    Operator incrementMe() {
        this.value = this.value + 1
        this
    }
}
