class D04 {

	int checkUniqueInPhrases(List<String> lines){
		return lines.stream().filter {isUnique(it)}.count()
	}
	
	int checkAnagramInPhrases(List<String> lines){
		return lines.stream().filter {isNotAnAnagram(it)}.count()
	}

	boolean isUnique(String phrase){
		def res = false
		def tokens = phrase.tokenize()
		def distincts = tokens.stream().distinct().toArray()
		return tokens.size()== distincts.size()
	}

	boolean isNotAnAnagram(String phrase){
		def res = true
		//sort all the characters of each word to check if there is any anagram
		def words = phrase.tokenize()*.split('')*.sort()
		
		for (word in words) {
			if (words.count(word)>1)
				res = false
		} 
		
		return res
	}
}