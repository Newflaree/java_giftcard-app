package giftcardapp;
import java.util.Date;


public class Card {
  private String code;
  private Short key;
  private int mount;
  private Date validity;
  private Worker worker;

  public Card(
    int mount,
    Date validity,
    Worker worker
  ) {
    this.code = GenerateCorrelative.generateCard();
    this.key = Short.valueOf(
      worker.getRun()
        .replace( ".", "" )
        .substring( 0, 4 ) 
    );

    this.mount = mount;
    this.validity = validity;
    this.worker = worker;
  }

  public Worker getWorker() {
    return this.worker;
  }

  public void setWorker( Worker worker ) {
    this.worker = worker;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode( String code ) {
    this.code = code;
  }

  public Short getKey() {
    return this.key;
  }

  public void setKey( Short key ) {
    this.key = key;
  }
  
  public int getMount() {
    return this.mount;
  }

  public void setMount( int mount ) {
    this.mount = mount;
  }

  public Date getValidity() {
    return this.validity;
  }

  public void setValidity( Date validity ) {
    this.validity = validity;
  }

  @Override
  public String toString() {
    return "code =" + code + "\nkey=" + key + "\nmount=" + mount + "\nvalidity=" + validity + "\nworker=" + worker + '}';
  }

  public boolean validPurchase( int mount ) {
    if ( mount < this.mount )
      return true;
    else
      return false;
  }

  public boolean validateValidity() {
    Date currentDate = new Date();

    if ( validity.before( currentDate ) )
      return false;
    else
      return true;
  }
}
