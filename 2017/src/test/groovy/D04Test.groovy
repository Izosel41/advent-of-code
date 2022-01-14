class D04Test extends GroovyTestCase {
	
	D04 day = new D04()

    void testCheckphrases() {
		assert day.isUnique("aa bb cc dd ee") == true
        assert day.isUnique("aa bb cc dd aa") == false
        assert day.isUnique("aa bb cc dd aaa") == true
    }

	void testCheckphrases2() {
		assert day.isNotAnAnagram("abcde fghij") == true
        assert day.isNotAnAnagram("abcde xyz ecdab") == false
        assert day.isNotAnAnagram("a ab abc abd abf abj") == true
        assert day.isNotAnAnagram("iiii oiii ooii oooi oooo") == true
        assert day.isNotAnAnagram("oiii ioii iioi iiio") == false

    }
	
	void testItem() {
		def lines = Util.extractLines("D04.txt")
		assert(455 == day.checkUniqueInPhrases(lines))
        assert(186 == day.checkAnagramInPhrases(lines))
    }
}
