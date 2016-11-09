show = { println it }
square_root = { Math.sqrt(it) }

def please(aciton) {
    [the: { what ->
        [of: { n -> aciton(what(n)) }]
    }]
}

please show the square_root of 100

please(show).the(square_root).of(100)