package com.example.myapplication;

public class Space {
    private int row;
    private int col;
    private int libertiesCount;
    private int connectionCount;
    private Space leftSpace;
    private Space rightSpace;
    private Space topSpace;
    private Space bottomSpace;
    private int state;
    //board

    public Space(int row, int col, int libertiesCount, int connectionCount, Space topSpace, int state,
                 Space bottomSpace, Space rightSpace, Space leftSpace) {
        if (row > 9 || col > 9) {
            throw new IllegalArgumentException("");
        }
        this.row = row;
        this.col = col;
        this.topSpace = board.getSpace(row + 1, col);
        this.bottomSpace = board.getSpace(row - 1, col);
        this.leftSpace = board.getSpace(row, col + 1);
        this.rightSpace = board.getSpace(row, col - 1);
        this.state = state;
        if ((this.getState() == 1 || this.getState() == 2)
                && (this.getState() == topSpace.getState())) {
            connectionCount += 1;
        }
        if ((this.getState() == 1 || this.getState() == 2)
                && (this.getState() == bottomSpace.getState())) {
            connectionCount += 1;
        }
        if ((this.getState() == 1 || this.getState() == 2)
                && (this.getState() == rightSpace.getState())) {
            connectionCount += 1;
        }
        if ((this.getState() == 1 || this.getState() == 2)
                && (this.getState() == leftSpace.getState())) {
            connectionCount += 1;
        }

        if ((this.getState() == 1 && topSpace == null) ||
                ((this.getState() == 2) && topSpace == null)) {
            libertiesCount += 1;
        }
        if ((this.getState() == 1 && bottomSpace == null) ||
                ((this.getState() == 2) && bottomSpace == null)) {
            libertiesCount += 1;
        }
        if ((this.getState() == 1 && rightSpace == null) ||
                ((this.getState() == 2) && rightSpace == null)) {
            libertiesCount += 1;
        }
        if ((this.getState() == 1 && leftSpace == null) ||
                ((this.getState() == 2) && leftSpace == null)) {
            libertiesCount += 1;
        }
    }

    public Space getTopSpace() {
        return topSpace;
    }

    public Space getBottomSpace() {
        return bottomSpace;
    }

    public Space getRightSpace() {
        return rightSpace;
    }

    public Space getLeftSpace() {
        return leftSpace;
    }

    public int getLibertiesCount() {
        return libertiesCount;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public int getState() {
        return state;
    }

    public void setTopSpace(Space topSpace) {
        this.topSpace = topSpace;
    }

    public void setBottomSpace(Space bottomSpace) {
        this.bottomSpace = bottomSpace;
    }

    public void setRightSpace(Space rightSpace) {
        this.rightSpace = rightSpace;
    }

    public void setLeftSpace(Space leftSpace) {
        this.leftSpace = leftSpace;
    }

    public void setState(int state) {
        this.state = state;
    }
}
