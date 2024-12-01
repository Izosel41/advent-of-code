package aoc;

import java.util.ArrayList;
import java.util.List;

public class D20 {

    class Tile {
        Long id;
        char[][] image;

        public Tile (Long id, char[][] img){
            this.id = id;
            this.image = img;
        }
    }
    public Long arrangeTiles(List<String> input) {
        List<Tile> tiles = parseInput(input);
        Tile[][] image = match(tiles);

        return null;
    }

    private Tile[][] match(List<Tile> tiles) {
        
        return new Tile[0][];
    }

    private List<Tile> parseInput(List<String> input) {
        List<Tile> titles = new ArrayList<>();
        //image by image
        for(int i=0; i<input.size(); i=i+12){
            //one image
            Long id = Long.valueOf(input.get(i).substring(5,9));
            char[][] image = new char[10][10];
            for(int j=0; j<11; j++){
                image[j] = input.get(i+j).toCharArray();
            }
            titles.add(new Tile(id, image));
        }
        return titles;
    }
}
