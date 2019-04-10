package ch.bbw.ft.SpringBootTableCRUD;

public class Reservation {

  private long id;
  private String content;

  public Reservation(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public Reservation() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Reservation{" + "id=" + id + ", content=" + content + '}';
  }
}
