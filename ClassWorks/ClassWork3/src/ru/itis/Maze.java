package ru.itis;

import java.util.Arrays;

public class Maze {
    //-1 is an empty space; -2 is a wall
    private int[][][] maze;

    public Maze(Maze other) {
        this(other.maze);
    }

    public Maze(int[][][] maze) {
        this.maze = new int[maze.length][maze[0].length][maze[0][0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.arraycopy(maze[i][j], 0, this.maze[i][j], 0, maze[i][j].length);
            }
        }
    }

    public Maze(int height, int length, int width) {
        this.maze = new int[height][length][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                Arrays.fill(this.maze[i][j], -1);
            }
        }
    }

    //does nothing if cell does not exist in maze or the value is invalid (<-2)
    public void setCellValue(Cell cell, int value) {
        if (doesCellExist(cell) && value >= -2) {
            maze[cell.z][cell.y][cell.x] = value;
        }
    }

    // returns -5 if cell does not exist in maze
    public int getCellValue(Cell cell) {
        if (doesCellExist(cell)) {
            return maze[cell.z][cell.y][cell.x];
        } else {
            return -5;
        }
    }

    private boolean doesCellExist(Cell cell) {
        return cell.x > -1 && cell.x < maze[0][0].length
                && cell.y > -1 && cell.y < maze[0].length
                && cell.z > -1 && cell.z < maze.length;
    }

    public void setWall(Cell cell) {
        setCellValue(cell, -2);
    }

    public void setEmpty(Cell cell) {
        setCellValue(cell, -1);
    }

    public void showPath(Path path) {
        CellIterator iterator = path.getIterator();
        int pathLength = 0;
        while (iterator.hasNext()) {
            pathLength++;
            iterator.next();
        }
        int[] tempStorage = new int[pathLength];
        int index = 0;
        iterator = path.getIterator();
        while (iterator.hasNext()) {
            Cell curCell = iterator.next();
            tempStorage[index] = getCellValue(curCell);
            setCellValue(curCell, index);
            index++;
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                for (int k = 0; k < maze[0][0].length; k++) {
                    if (maze[i][j][k] > -1) {
                        System.out.print(maze[i][j][k] + " ");
                    } else if (maze[i][j][k] == -1) {
                        System.out.print("o ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        index = 0;
        iterator = path.getIterator();
        while (iterator.hasNext()) {
            Cell curCell = iterator.next();
            setCellValue(curCell, tempStorage[index]);
            index++;
        }
    }
}

