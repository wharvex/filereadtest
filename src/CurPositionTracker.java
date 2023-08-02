import java.util.List;

public class CurPositionTracker {

  public final Position position;
  private boolean atLineEnd, atFileEnd;
  private final List<Integer> lineLengths;

  public CurPositionTracker(List<Integer> lineLengths) {
    this.lineLengths = lineLengths;
    this.position = new Position();
    this.setAtLineEnd();
    this.setAtFileEnd();
  }

  public boolean isAtLineEnd() {
    return atLineEnd;
  }

  public void setAtLineEnd() {
    this.atLineEnd = (this.position.getColNum() - 1) == this.getCurLineLength();
  }

  public List<Integer> getLineLengths() {
    return lineLengths;
  }

  public int getCurLineLength() {
    return this.getLineLengths().get(this.position.getLinNum() - 1);
  }

  public boolean isAtFileEnd() {
    return atFileEnd;
  }

  public void setAtFileEnd() {
    this.atFileEnd = this.getLineLengths().size() == this.position.getLinNum();
  }

  public boolean advancePosition() {
    if (this.isAtLineEnd() && this.isAtFileEnd()) {
      return false;
    }
    if (this.isAtLineEnd()) {
      this.position.setColNum(1);
      this.position.setLinNum(this.position.getLinNum() + 1);
    } else {
      this.position.setColNum(this.position.getColNum() + 1);
    }
    this.setAtLineEnd();
    this.setAtFileEnd();
    return true;
  }
}
