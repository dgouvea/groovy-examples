package example.basic

class Pojo {

    String name

    String getName() {
        'Get ' + this.name
    }

    void setName(String name) {
        String[] names = name.split(" ")
        this.name = names[0] + " " + names[-1]
    }

}
