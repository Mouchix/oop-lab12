package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

public class LogicsImpl implements Logics{

    private final Map<Pair<Integer, Integer>, String> map = new HashMap<>();
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                map.put(new Pair<Integer,Integer>(i, j), " ");
            }
        }
    }

    @Override
    public String hit(Pair<Integer, Integer> elem) {
        if(map.get(elem).equals(" ")) {
            map.put(elem, "*");
            return "*";
        }

        map.put(elem, " ");
        return " ";
    }

    @Override
    public boolean toQuit() {
        for (int i = 0; i < this.size; i++) {
            int countColum = 0;
            int countLine = 0;
            for(int j = 0; j < this.size; j++) {
                if(map.get(new Pair<Integer,Integer>(i, j)).equals("*")) {
                    countColum ++;
                }

                if(map.get(new Pair<Integer,Integer>(j, i)).equals("*")) {
                    countLine ++;
                }
            }

            if(countColum == this.size || countLine == this.size) {
                return true;
            }
        }

        return false;
    }

}
