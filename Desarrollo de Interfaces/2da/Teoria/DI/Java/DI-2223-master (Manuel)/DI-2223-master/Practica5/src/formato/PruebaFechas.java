/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Manu
 */
public class PruebaFechas {
    public static void main(String[] args)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        Date d = new Date();
        //usamos el método "format" de SimpleDateFormat para aplicar el formato 
        // definido (en sdf) a la fecha que devuelve Date en d, que viene con hora
        System.out.println(sdf.format(d));
        
        String s = "25-10-2022";
        // ahora lo hacemos al revés, queremos convertir un formato corto a uno largo
        // con el método "parse", que devuelve un formato de fecha completo
        try
        {
            d = sdf.parse(s);
        }
        catch (ParseException ex)
                {
                    System.out.println("Error con la fecha");
                }
        // como parse devuelve un formato de Date, debemos convertirlo a string:
        System.out.println(d.toString());
    }
    
}
