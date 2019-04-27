package TypesDonnees;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatTest
{
    public static void main( String[] args )
    {
        // modif branch-3
        Double test1 = 123.456;

        // Provoque une erreur NumberFormatException avec les paramètres régionaux français
        //Double test = Double.parseDouble( new DecimalFormat( "##.####" ).format( test1 ) );

        // Fonctionne quels que soient les paramètres régionaux
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance( new Locale( "en", "US"));
        decimalFormat.applyPattern("##.####");
        Double test = Double.parseDouble(decimalFormat.format(test1));

        System.out.println( "test : " +test );
    }
}
