package ru.itis;

public class Main {

    public static void main(String[] args) {
        int[][][] mazeTemplate = {
                {
                        {-2, -2, -1, -2, -2},
                        {-1, -1, -1, -2, -2},
                        {-1, -2, -2, -1, -1},
                        {-2, -2, -2, -2, -2}
                },

                {
                        {-2, -2, -2, -1, -2},
                        {-2, -2, -1, -1, -1},
                        {-1, -2, -2, -2, -1},
                        {-1, -1, -1, -1, -1}
                },

                {
                        {-1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1},
                },


        };
        Maze maze = new Maze(mazeTemplate);
        Player player = new Player();
        Cell start = new Cell(3, 3, 2);
        Cell finish = new Cell(0, 1, 0);
        Path path = player.run(maze, start, finish);
        maze.showPath(path);
    }
}
