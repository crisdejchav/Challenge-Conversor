package services;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;



public class ApiConection {
    private final String API_KEY = "13150e797d074141f286d1a8";
    private final String URL = "https://v6.exchangerate-api.com/v6/";

    public HashMap<String, Double> getCurrencyOf(String currency) throws IOException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(URL+API_KEY+"/latest/"+currency))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        String json = response.body();

        Gson gson = new Gson();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        Type type = new TypeToken<HashMap<String, Double>>() {}.getType();


        HashMap<String, Double> currencyMap = gson.fromJson(conversionRates, type);
        return currencyMap;
    }
}
