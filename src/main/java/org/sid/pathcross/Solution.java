package org.sid.pathcross;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
class Solution {

    private static final int Y_INC = 10_000;
    public boolean isPathCrossing(String path) {
        Set<Integer> position = new HashSet<>();

        char[] steps = path.toCharArray();
        int xPos = 0;
        int yPos = 0;
        position.add(0);

        for ( char step : steps) {
            switch (step ) {
                case 'N':
                    yPos+=Y_INC;
                    break;
                case 'W':
                    yPos-=Y_INC;
                    break;
                case 'E':
                    xPos++;
                    break;
                case 'W':
                    xPos--;
                    break;
            }
            if ( !position.add(xPos+yPos)) {
                return true;
            }
        }
        return false;
    }
}