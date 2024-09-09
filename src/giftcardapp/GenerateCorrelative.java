package giftcardapp;


public class GenerateCorrelative {
  public static String generateCard() {
    String number = "";
    int num;

    for ( int i = 0; i < 16; i++ ) {
      num = (int)Math.ceil( Math.random() * 9 );
      number = number + num;
    }

    return number;
  }
}
