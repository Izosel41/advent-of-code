class D10Test extends GroovyTestCase {

    D10 day = new D10()

    void testPinch() {
        int[] list = 0..4
        int[] lengths = [3, 4, 1, 5]
        assert 12 == day.check(day.pinch(list, lengths, 1))
    }

    void testDay101() {
        int[] list = 0..255
        int[] lengths = [192,69,168,160,78,1,166,28,0,83,198,2,254,255,41,12]
        println day.check(day.pinch(list, lengths, 1))
    }

    void testKnotHashEmpty() {
        assert "a2582a3a0e66e6e86e3812dcb672a272" == day.knotHash("")
    }

    void testKnotHashAoC2017() {
        assert "33efeb34ea91902bb2f59c9920caa6cd" == day.knotHash("AoC 2017")
    }
    void testKnotHash123() {
        assert "3efbe78a8d82f29979031a4aa0b16a9d" == day.knotHash("1,2,3")
    }
    void testKnotHash124() {
        assert "63960835bcdc130f0b66d7ff4f6a5a8e" == day.knotHash("1,2,4")
    }

    void testToAscii() {
        assert [49,44,50,44,51] == day.toAscii("1,2,3")
    }

    void testDense(){
        assert 64 == day.dense([65,27,9,1,4,3,40,50,91,7,6,0,2,5,68,22])
    }

    void testToHex(){
        assert "4007ff" == day.toHex([64,7,255])
    }

    void testDay102() {
        println "Day 10.2 " + day.knotHash("192,69,168,160,78,1,166,28,0,83,198,2,254,255,41,12")
    }
}
