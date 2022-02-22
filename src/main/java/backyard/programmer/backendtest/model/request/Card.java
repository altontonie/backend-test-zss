package backyard.programmer.backendtest.model.request;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Card {
    private String id;
    private Date expiry;

    public Card() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format( new Date()   );
        try {
            Date date = format.parse ( "2022-02-22" );
            this.expiry = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
