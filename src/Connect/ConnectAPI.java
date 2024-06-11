package Connect;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;
import com.google.gson.Gson;

public class ConnectAPI {
    public Currencies usage(String currency){
        String saveCurrencyRequest = "https://v6.exchangerate-api.com/v6/73633f1a67e03f01403407c5/latest/" + currency + "/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(saveCurrencyRequest))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Currencies.class);
    }
}