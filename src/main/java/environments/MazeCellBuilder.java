package environments;

public interface MazeCellBuilder<CellType extends MazeCell> {

    CellType build();
    CellType build(int id, int i, int j, String open);

}
