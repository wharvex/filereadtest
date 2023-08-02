import java.util.List;

public class Lexer {

  private final List<String> lines;

  private int linNum, colNum;

  public Lexer(List<String> lines) {
    this.lines = lines;
    this.linNum = 1;
    this.colNum = 1;
  }

  public List<String> getLines() {
    return this.lines;
  }

  public String getLine(int idx) {
    return this.getLines().get(idx);
  }

  public String getCurLine() {
    return this.getLine(this.getLinNum() - 1);
  }

  public char getCurChar() {
    return this.getCurLine().charAt(this.getColNum() - 1);
  }

  public int getCurLineLen() {
    return this.getCurLine().length();
  }

  public boolean atLineEnd() {
    return this.getCurLineLen() == this.getColNum() - 1;
  }

  public void resetColNum() {
    this.setColNum(1);
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

  public void incrLinNum() {
    this.setLinNum(this.getLinNum() + 1);
  }

  public void incrColNum() {
    this.setColNum(this.getColNum() + 1);
  }

  public int getNumLines() {
    return this.getLines().size();
  }

  public void lex() {
    CurPositionTracker curPositionTracker = new CurPositionTracker(
        this.getLines().stream().map(String::length).toList());
    do {
      if (curPositionTracker.isAtLineEnd()) {
        System.out.println("EOL");
      } else {
        System.out.println(this.getLines().get(curPositionTracker.position.getLinNum() - 1)
            .charAt(curPositionTracker.position.getColNum() - 1));
      }
    } while (curPositionTracker.advancePosition());
  }

}
