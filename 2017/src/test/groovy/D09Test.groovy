class D09Test extends GroovyTestCase {

    D09 day = new D09()

    void testGarbage() {
        def garbage = ["<>", "<random characters>", "<<<<>", "<{!>}>", "<!!>", "<!!!>>", "<{o\"i!a,<{i<a>"]
        garbage.each{line -> day.countGroup(line); assert( 0 == day.cpt)}
    }

    void testGroup(){
        def group = ["{}": 1, "{{{}}}": 3, "{{},{}}": 3, "{{{},{},{{}}}}" : 6, "{<{},{},{{}}>}": 1, "{<a>,<a>,<a>,<a>}" : 1, "{{<a>},{<a>},{<a>},{<a>}}": 5, "{{<!>},{<!>},{<!>},{<a>}}" : 2]
        group.each{line, value -> day.countGroup(line); assert( value == day.cpt)}
    }

    void testScore(){
        def group = ["{}": 1, "{{{}}}": 6, "{{},{}}": 5, "{{{},{},{{}}}}" : 16, "{<a>,<a>,<a>,<a>}" : 1, "{{<ab>},{<ab>},{<ab>},{<ab>}}" : 9, "{{<!!>},{<!!>},{<!!>},{<!!>}}":9, "{{<a!>},{<a!>},{<a!>},{<ab>}}" : 3]
        group.each{line, value -> println(line); day.countGroup(line); assert( value == day.score)}
    }

    void testDay091() {
        def line = Util.extractLines("D09.txt")
        day.countGroup(line)
        println "Day 09 1 -> " + day.score
    }

    void testRemove(){
        def remove = ["<>" : 0, "<random characters>" :17 , "<<<<>":3, "<{!>}>":2, "<!!>":0, "<!!!>>":0, "<{o\"i!a,<{i<a>": 10]
        remove.each{line, value -> println(line); day.countGroup(line); assert( value == day.removed)}
    }

    void testDay092() {
        def line = Util.extractLines("D09.txt")
        day.countGroup(line)
        println "Day 09 1 -> " + day.removed
    }
}
