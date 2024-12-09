package mainPackage;

public abstract class GameElementFactory {
    public abstract Map createMap();
    public abstract Bird createBird();
}

class DefaultGameElementFactory extends GameElementFactory {
    @Override
    public Map createMap() {
        Map map = new Map();
        map.formatMap();
        map.generatePipesForWholeMap();
        return map;
    }

    @Override
    public Bird createBird() {
        Bird bird = new Bird();
        bird.spawn(10, 1);
        return bird;
    }

}
