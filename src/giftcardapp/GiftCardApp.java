package giftcardapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author newflare
 */
public class GiftCardApp {
  public static void main(String[] args) {
    Scanner sc = new Scanner( System.in );
    Scanner data = new Scanner( System.in );

    Short option;

    String rut;
    String dv;
    String name;
    Date validity = null;
    int mount;

    SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
    Card card = null;

    do {
      System.out.println(
        "SISTEMA DE GESTIÓN DE GIFT CARD \n"
        + "Seleccione una opción: \n"
        + "1. Nueva Tarjeta \n"
        + "2. Realizar Compra \n"
        + "3. SALIR \n"
      );

      option = sc.nextShort();

      switch ( option ) {
        case 1:
          System.out.print( "Ingrese su RUT sin dígito verificador: " );
          rut = data.nextLine();

          System.out.print( "Ingrese dígito verificador: " );
          dv = data.nextLine();

          System.out.print( "Ingrese nombre: " );
          name = data.nextLine();

          Worker worker = new Worker( rut, dv, name );

          System.out.print( "Ingrese vigencia de la tarjeta (dd-mm-yyyy): " );
          {
            try {
              validity = format.parse( data.next() );
            } catch( ParseException ex ) {
              System.out.println( "La fecha ingresada no es válida." );
            }
          }

          System.out.print( "Ingrese monto de la tarjeta: " );
          mount = data.nextInt();

          card = new Card( mount, validity, worker );
          System.out.println( card );
          break;

        case 2:
          if ( card != null ) {
            System.out.print( "Ingrese monto de la compra: " );
            mount = data.nextInt();

            if ( card.validateValidity() && card.validPurchase( mount ) ) {
              card.setMount( card.getMount() - mount );
            } else {
              System.out.println( "Error al realizar la compra" );
            }

          } else {
            System.out.println( "No existe tarjeta" );
          }
          break;

        case 3:
          System.out.println( "Saliendo del sistema..." );
          return;

        default:
          System.out.println( "Opción no válida." );
          break;
      }

    } while( true );
  }
}
