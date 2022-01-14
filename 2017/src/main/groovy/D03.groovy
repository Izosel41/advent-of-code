class D03 {

	int spiralMemory(int square) {

		if (square== 1)
			return 0
		else{
			//spiralMaximum =n**2 where n mod 2 = 1
			def width = Math.sqrt(square).trunc()
			if(width%2==0)
				width++
			if(width**2<square)
				width+=2

			// gap from the middle
			int gap = -1
			def i =0
			//limits
			while(gap.is(-1)) {
				def max = width**2 - width*i
				def min = max - width

				if(square <= max && square >= min) {
					def middle = (max+ min +1)/2
					gap = Math.abs(middle - square)
				}
				i++
			}
			return (gap + (width+1)/2-1)
		}
	}

	int spiralMemory2(int square) {
		int value = 1
		Map<Coord, Integer> matrix = [[0, 0]:1]
		int width = 1
		int x =0
		int y =0
		//the first square is already set
		int sq=1
		//start with east side
		def side = Side.SOUTH

		//TODO refactor with enum functions instead of case
		while(square > value.intValue()) {
			sq++
			switch (side){
				case Side.EAST:
					y++
					if (sq==width){
						width++
						side++
						sq = 1
					}
					break
				case Side.NORTH:
					x--
					if (sq==width){
						side++
						sq = 1
					}
					break
				case Side.WEST:
					y--
					if (sq==width){
						side++
						sq = 1
					}
					break
				case Side.SOUTH:
					x++
					if (sq==width+1){
						width++
						side++
						sq = 1
					}
					break
			}
			value  = matrix[[x-1, y-1]]?:0
			value += matrix[[x-1, y]]?:0
			value += matrix[[x-1, y+1]]?:0

			value += matrix[[x, y-1]]?:0
			value += (matrix[[x, y+1]]?:0)

			value += matrix[[x+1, y-1]]?:0
			value += matrix[x+1, y]?:0
			value += (matrix[[x+1, y+1]]?:0)

			matrix << [[x, y]:value]
			println "["+x+","+y+"] : "+value
		}
		println "["+x+","+y+"] : "+value
		return value.intValue()
	}

}

class Coord{
	int x
	int y
}

enum Side {
	EAST, NORTH, WEST, SOUTH
}