package NonoTheRobot

class PathFinderTest extends GroovyTestCase {
    void testFindPath() {
        Labyrinthe lab = Parser.ParseLabyrinthe(System.getProperty("user.dir") + "/resources/map2.txt")
        List<Vector2<Integer>> path = [new Vector2<>(1,1),new Vector2<>(1,2),new Vector2<>(1,3),
                                       new Vector2<>(2,3),new Vector2<>(3,3),new Vector2<>(3,2),
                                       new Vector2<>(4,2),new Vector2<>(5,2),new Vector2<>(5,1),
                                       new Vector2<>(6,1),new Vector2<>(7,1),new Vector2<>(7,2),
                                       new Vector2<>(7,3),new Vector2<>(8,3)]

        List<Vector2<Integer>> pathFound = new ArrayList<>()
        assert PathFinder.FindPath(lab, pathFound)
        for (int i=0; i < path.size(); i++) {
            assert path.get(i).equals(pathFound.get(i))
        }
    }
}
