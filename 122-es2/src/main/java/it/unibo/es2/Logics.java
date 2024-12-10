package it.unibo.es2;

public interface Logics {

    /**
     * 
     * @param elem
     * @return the new value a button should show after being pressed
     */
    String hit(Pair<Integer, Integer> elem);

    /**
     * 
     * @return wheter it is time to quit
     */
    boolean toQuit();
}
