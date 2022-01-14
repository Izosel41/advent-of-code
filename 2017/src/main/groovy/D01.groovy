class D01 {
	
	int captcha(String s) {
		int result
		result = 0
		//list is circular
		s = s+s.charAt(0)
		int[] arr = s.toCharArray()

		for (int i=1; i<arr.size(); i++){
			if (arr[i].is(arr[i-1]))
				result+= Character.getNumericValue(arr[i-1])
		}
		return result
	}
	
	int captcha2(String s) {
		int result = 0
		int[] arr = s.toCharArray()
		int shift = s.length()/2

		for (int i=0; i<shift; i++){
			if (arr[i].is(arr[i+shift]))
				result+= Character.getNumericValue(arr[i])*2
		}
		return result
	}
}
