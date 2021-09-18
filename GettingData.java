// Packages to make URL request
import java.io.InputStream;
import com.google.gson.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GettingData {

    String currencyFrom = "USD";
    String currencyTo = "EUR";
    double currencyFromCode = 0.00;
    double currencyToCode = 0.00;
    double moneyInitialized = 1000.00;

    public JsonElement returnCode(String currencyCode) throws Exception {
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/d45b92e27aa87499e7e712c7/latest/USD";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
        JsonObject req_result = (JsonObject) jsonobj.get("conversion_rates");

        return (req_result.get(currencyCode));
    }

    public void getData () throws Exception {
        currencyFromCode =  Double.parseDouble((returnCode (currencyFrom)).toString());
        currencyToCode =  Double.parseDouble((returnCode (currencyTo)).toString());
    }

    public void exchangeRate() {
        double exchangeRate = currencyToCode / currencyFromCode;
        System.out.println (moneyInitialized * exchangeRate);
    }

    public static void main(String[] args) throws Exception {
        GettingData obj = new GettingData();

        obj.getData();
        obj.exchangeRate();




    }


}
