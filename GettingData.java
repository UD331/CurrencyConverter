// Packages to make URL request
import java.io.InputStream;
import com.google.gson.*;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GettingData {
    public static String currencyFrom = "";
    public static String currencyTo = "";
    public static boolean action;
    double currencyFromCode = 0.00;
    double currencyToCode = 0.00;
    public static double moneyInitialized = 0;

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

    public double exchangeRate() {
        double exchangeRate = currencyToCode / currencyFromCode;
        return exchangeRate;
    }

    public static void main(String[] args) throws Exception {
        combobox box = new combobox();

    }


}

