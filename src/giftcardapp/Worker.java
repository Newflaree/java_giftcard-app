package giftcardapp;


public class Worker {
  private String run;
  private String dv;
  private String name;

  public Worker(
    String run,
    String dv,
    String name
  ) {
    this.run = run;
    this.dv = dv;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getRun() {
    return this.run;
  }

  public void setRun( String run ) {
    this.run = run;
  }

  public String getDv() {
    return this.dv;
  }

  public void setDv( String dv ) {
    this.dv = dv;
  }

  @Override
  public String toString() {
    return "Worker{" + " run=" + run + ", dv=" + dv + ", name=" + name + '}';
  }
}
