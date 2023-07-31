package co.com.automatizacionApi.screenplay.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class Utilidades {
    public static <T> String obtenerJson(T objeto) {
        final Gson gson = new Gson();
        return gson.toJson(objeto);
    }

    public static Map convertirJsonMap(String objeto) {
        final Gson gson = new Gson();
        return gson.fromJson(objeto, Map.class);
    }
    public static Map<String, Object> parseResponse(String jsonResponse) {
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        return gson.fromJson(jsonResponse, mapType);
    }
}
