class D05 {
	
	int jump(List<Integer> memory){
		int idx = 0
		int cpt =0
		while(idx<memory.size()){
			int offset = memory[idx]
			memory.set(idx, memory.get(idx)+1)
			idx = idx + offset
			cpt++ 
		}
				
		return cpt
	}

	int jump2(List<String> memory){
		int idx = 0
		def cpt =0
		while(idx<memory.size()){
			def offset = memory[idx]
			if (offset<3)
				memory.set(idx, memory.get(idx)+1)
			else
				memory.set(idx, memory.get(idx)-1)
			idx = idx + offset
			cpt++ 
		}
				
		return cpt
	}
}