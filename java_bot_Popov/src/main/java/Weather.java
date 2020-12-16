import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Weather {

    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + message +
                "&units=metric&appid=3a1a9d4742b516bd132181ba11fbcd4b");
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);

        JSONObject city = object.getJSONObject("city");
        String output = "\uD83C\uDFE2 " + city.getString("name") + " \uD83C\uDFE2" + '\n' + '\n';

        JSONArray getArray = object.getJSONArray("list");

        for (int i = 0; i < 10; i++) {
            JSONObject obj = getArray.getJSONObject(i);
            model.setDate((String) obj.get("dt_txt"));
            JSONObject main = obj.getJSONObject("main");
            model.setTemp(main.getDouble("temp"));
            model.setPressure(main.getDouble("pressure"));
            model.setHumidity(main.getDouble("humidity"));
            JSONArray wArray = obj.getJSONArray("weather");
            model.setDescription(wArray.getJSONObject(0).getString("description"));
            JSONObject wind = obj.getJSONObject("wind");
            model.setSpeed(wind.getDouble("speed"));
            output+= model.toString();
        }

        return output;

    }


}