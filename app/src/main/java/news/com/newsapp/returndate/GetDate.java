package news.com.newsapp.returndate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class GetDate {
    public static String formatNewsApiDate(String inputDate) {
        try {
            String inputDFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            String outputDFormat = "EEE, d MMM yyyy KK:mm";

            SimpleDateFormat inputFormat = new SimpleDateFormat(inputDFormat);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDFormat);


            java.util.Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return inputDate;
    }
}
