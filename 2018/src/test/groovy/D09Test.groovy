class D09Test extends GroovyTestCase{
    D09 day = new D09()

    void testScoreSimple(){
        assert 32 == day.score(9, 25)
    }

    void testScoreExamples(){
        assert 8317 == day.score(10, 1618)
        assert 146373 == day.score(13, 7999)
        assert 2764 == day.score(17, 1104)
        assert 54718 == day.score(21, 6111)
        assert 37305 == day.score(30, 5807)
    }

    void testScoreOne(){
        println day.score(471, 72026)
    }
}
