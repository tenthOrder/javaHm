package ru.itis;

public class Player {
    //returns empty path if there is no path froms start to finish
    Path run(Maze maze, Cell start, Cell finish) {
        Path path = new Path();
        if (start.equals(finish)) {
            path.add(start);
            return path;
        }
        Maze changed = new Maze(maze);
        CellQueue queue = new CellQueueLinkedListImpl();
        queue.enqueue(start);
        changed.setCellValue(start, 0);
        Cell curCell;
        do {
            curCell = queue.dequeue();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        Cell curNeighbour = new Cell(curCell.x + i, curCell.y + j, curCell.z + k);
                        //check that curNeighbour exists and empty
                        if (changed.getCellValue(curNeighbour) == -1) {
                            changed.setCellValue(curNeighbour, changed.getCellValue(curCell) + 1);
                            queue.enqueue(curNeighbour);
                        }
                    }
                }
            }
        } while (!queue.isEmpty() && !curCell.equals(finish));
        if (!curCell.equals(finish)) {
            return path;
        }
        while (!curCell.equals(start)) {
            path.addBegin(curCell);
            int curPathIndex = changed.getCellValue(curCell);
            boolean foundPrev = false;
            for (int i = -1; i <= 1 && !foundPrev; i++) {
                for (int j = -1; j <= 1 && !foundPrev; j++) {
                    for (int k = -1; k <= 1 && !foundPrev; k++) {
                        Cell curNeighbour = new Cell(curCell.x + i, curCell.y + j, curCell.z + k);
                        if (changed.getCellValue(curNeighbour) == changed.getCellValue(curCell) - 1) {
                            curCell = curNeighbour;
                            foundPrev = true;
                        }
                    }
                }
            }
        }
        path.addBegin(start);
        return path;
    }
}
