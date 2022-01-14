class D06 {
	
	def int getCycleRealloc(List banks){
		def cycle = 0
		def keeper = []

		while(!keeper.contains(banks.join())){
			keeper.add(banks.join())
			realloc(banks)
			cycle++
			println "**********************"+ keeper
		}
		
		return cycle;
	}
	
	def void realloc(List<Integer>banks){
		def min = 0
		Integer tiles = banks.max()
		def bankSupplier  = banks.indexOf(tiles)
		def idx = 0
		bankSupplier==0?(idx=1):(idx=0)
		
		while(tiles>1){
			println banks
			banks.set(idx, banks.get(idx)+1)
			tiles--
			banks.set(bankSupplier, tiles)

			if(idx == banks.size()-1)
				idx=0
			else
				idx++
			if (bankSupplier==idx)
				idx++
		}
	}
}