package geekbrains;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {

    public static void main(String[] args) throws Exception {
        String result = "";
        HttpGet get = new HttpGet("http://dataservice.accuweather.com/forecasts/v1/daily/5day/2206565"
                + "?apikey=4kLEHve4i2NDl9nx977kd5fxiKwwWwlF");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)){
            result = EntityUtils.toString(response.getEntity());
        }

        System.out.println(result);

        //

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse wr = objectMapper.readValue(result, WeatherResponse.class);

        if (wr != null && wr.DailyForecasts != null) {
            for (DailyForecast df : wr.DailyForecasts) {
                String toUser = "В городе Saint-Petersburg на дату "
                        + df.Date
                        + " ожидается "
                        + df.Day.IconPhrase
                        + ", температура - "
                        + df.Temperature.Maximum.Value
                        + df.Temperature.Maximum.Unit;
                System.out.println(toUser);
            }
        } else {
            System.out.println("Плохо");
        }
    }
}
