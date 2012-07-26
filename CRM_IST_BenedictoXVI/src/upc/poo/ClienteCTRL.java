package upc.poo;

import java.util.ArrayList;
import java.text.*;
import java.util.*;

public class ClienteCTRL implements Comparator<Date>  {
    
///////////////////////////////////////////////////////////////////////////    
//* //OJO: ITALO, AMERICO: esto es sólo para probar el ordenamiento natural
    public static void main(String[] args) {
        ArrayList<Date> a = new ArrayList<Date>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //DateCompare compare = new DateCompare();
        ClienteCTRL compare = new ClienteCTRL();
        try {
            Date today = df.parse("2005-12-10");			
            Date another = df.parse("2003-19-31");
            Date three = df.parse("1991-10-01");
            Date cua = df.parse("1993-11-01");
            a.add(today);
            a.add(another);
            a.add(three);
            a.add(cua);
            Collections.sort(a, compare);
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int compare(Date one, Date two){
        return one.compareTo(two);
    }
//*/  
///////////////////////////////////////////////////////////////////////////
}

/*
class DateCompare implements Comparator<Date> {
    public int compare(Date one, Date two){
        return one.compareTo(two);
    }
}
*/