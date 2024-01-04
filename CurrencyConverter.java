import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;

public class CurrencyConverter {
    public static void main(String[] args) {
        String apiEndPoint = "https://api.currencyapi.com/v3/latest?base_currency=USD&currencies[]=EUR&currencies[]=INR";
        String apiKey = "cur_live_8MwBsvmr4ccjGhGLXkekSCZpZhwbGnvm1l11xHcv";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiEndPoint))
                .header("apikey", apiKey)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

                JsonObject metaData = jsonResponse.getAsJsonObject("meta");
                String lastUpdatedAt = metaData.get("last_updated_at").getAsString();
                System.out.println("Last Updated At: " + lastUpdatedAt);

                JsonObject currencyData = jsonResponse.getAsJsonObject("data");
                for (String currencyCode : currencyData.keySet()) {
                    JsonObject currency = currencyData.getAsJsonObject(currencyCode);
                    String code = currency.get("code").getAsString();
                    double value = currency.get("value").getAsDouble();
                    System.out.println("Currency Code: " + code + ", Value: " + value);
                }
            } else {
                System.out.println("HTTP Request failed: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}