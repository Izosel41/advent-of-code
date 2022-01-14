class D02 {
	
	int checksum(List<String> lines) {
		lines.inject(0) { 
			total, it -> 
				def line = it.tokenize()*.toInteger()
				total+= line.max() -line.min()  
		}
	}
	
	int checksum2(List<String> lines) {
		lines.inject(0) {
			total, it ->
				def line = it.tokenize()*.toInteger().sort()
				def res = 0
				def i = 0
				while (res==0 && i <line.size){
					for (int j=i+1; j<line.size; j++){
						if (line.get(j) % (line.get(i))==0)
							res = line.get(j) / line.get(i)
					}
					i++
				}
				total+= res
		}
	}
}
