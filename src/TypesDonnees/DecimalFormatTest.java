package TypesDonnees;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DecimalFormatTest
{
    public static void main( String[] args )
    {

        // ==========================================================================================================
        // Formatage d'un nombre indépendamment des paramètres régionaux

        Double test1 = 123.456;

        // Provoque une erreur NumberFormatException avec les paramètres régionaux français
        //Double test = Double.parseDouble( new DecimalFormat( "##.####" ).format( test1 ) );
        // modif master

        // Fonctionne quels que soient les paramètres régionaux
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance( new Locale( "en", "US"));
        decimalFormat.applyPattern("##.####");
        Double test = Double.parseDouble(decimalFormat.format(test1));

        System.out.println( "Formatage d'un nombre indépendamment des paramètres régionaux : " +test );

        // ==========================================================================================================
        // Conversion en nombre d'une chaine de caractères représentant une valeur numérique au format français
        String strVal = "123,45";
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        try {
            Float fNumber = nf.parse(strVal).floatValue();
            System.out.println("Conversion de : " + strVal + " => " + fNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Conversion en nombre d'une chaine de caratères représenant une valeur numérique au format US
        System.out.println();
        System.out.println("Conversion en nombre d'une chaine de caratères représenant une valeur numérique au format US");
        strVal = "7,500,000";
        try {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            Double dNumber = numberFormat.parse(strVal).doubleValue(); // => 7500000.0
            System.out.println("Conversion de : " + strVal + " =>" + dNumber);
        } catch (ParseException e) {
            System.out.println(e.toString());
        }
    }
}
