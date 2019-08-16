import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.json.simple.JSONObject;

public class Controller {

    public static String dateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = new Date();
        return formatter.format(date);
    }

    public static int id() {
        Random rand = new Random();
        int x = rand.nextInt(1000);
        return x;
    }


    public JSONObject jsonObject(String name, String job) {
        JSONObject json = new JSONObject();
        json.put("id", Controller.id());
        json.put("name", name);
        json.put("job", job);
        json.put("date", Controller.dateFormat());
        return json;
    }
}
