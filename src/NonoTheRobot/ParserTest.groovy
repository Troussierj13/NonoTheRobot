package NonoTheRobot

import java.nio.file.Path

class ParserTest extends groovy.util.GroovyTestCase {
    void testParseLabyrinthe() {
        char [][] lab = [['0','0','0','0','0','0','0','0','0'],
                         [' ','D','0',' ','0',' ',' ',' ',' '],
                         [' ',' ','0',' ',' ',' ','0',' ','0'],
                         [' ',' ',' ',' ','0',' ','0',' ','A'],
                         ['0','0','0','0','0','0','0','0','0']]

        char [][] returnLab = Parser.ParseLabyrinthe(System.getProperty("user.dir") + "/resources/map2.txt").getCharLab()

        for (int y=0; y<lab.length; y++) {
            for (int x=0; x<lab[0].length; x++) {
                assert lab[y][x] == returnLab[x][y]
            }
        }
    }
}
