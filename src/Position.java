public class Position {

  private int linNum, colNum;

  public Position() {
    this.linNum = this.colNum = 1;
  }

  public int getLinNum() {
    return linNum;
  }

  public void setLinNum(int linNum) {
    this.linNum = linNum;
  }

  public int getColNum() {
    return colNum;
  }

  public void setColNum(int colNum) {
    this.colNum = colNum;
  }
}
