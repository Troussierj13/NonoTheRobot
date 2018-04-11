package NonoTheRobot

class LabyrintheTest extends GroovyTestCase {

    boolean[][] tab = [
            [1,1,1,1,1,1],
            [1,0,0,1,0,1],
            [1,0,0,0,1,1],
            [1,0,0,0,1,0]
            ]
    Labyrinthe lab = new Labyrinthe("testlab", tab, new Vector2<Integer>(1,1), new Vector2<Integer>(2,3))
    void testNextStep() {
        assert lab.NextStep(null)[0].equals(new Vector2<>(1,1))
        assert lab.NextStep(new Vector2<Integer>(1,4)).empty
        def neib1 = lab.NextStep(new Vector2<Integer>(1,1))
        assert neib1.size() == 2 //"[[2, 1], [1, 2]]"
        assert neib1.contains(new Vector2<>(2,1))
        assert neib1.contains(new Vector2<>(1,2))
        def neib2 = lab.NextStep(new Vector2<Integer>(2,2))
        assert neib2.size() == 4
        assert neib2.contains(new Vector2<>(3,2))
        assert neib2.contains(new Vector2<>(1,2))
        assert neib2.contains(new Vector2<>(2,3))
        assert neib2.contains(new Vector2<>(2,1))
    }

    void testIsFinish() {
        assert !lab.isFinish(new Vector2<Integer>(1,1))
        assert !lab.isFinish(new Vector2<Integer>(2,1))
        assert lab.isFinish(new Vector2<Integer>(2,3))
    }

    void testToString() {
    }

    void testGetCharLab() {
        assert lab.getCharLab() == [['0','0','0','0','0','0'],
                                    ['0','D',' ','0',' ','0'],
                                    ['0',' ',' ','A','0','0'],
                                    ['0',' ',' ',' ','0',' ']]
    }

    void testGetName() {
        assert lab.getName() == "testlab"
    }
}
