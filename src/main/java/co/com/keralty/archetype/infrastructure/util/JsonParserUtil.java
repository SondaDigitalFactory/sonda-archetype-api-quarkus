package co.com.keralty.archetype.infrastructure.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.Instant;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class JsonParserUtil {

    private JsonParserUtil() {
    }

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> List<T> parsearLista(List<Object> lista, Class<T> clase) {
        return lista.stream()
                .map(item -> convertirObjeto(item, clase))
                .toList();
    }

    private static <T> T convertirObjeto(Object item, Class<T> clase) {
        if (item instanceof Map<?, ?> map) {
            Map<String, Object> stringMap = convertirAMapDeStrings(map);
            Map<String, Object> normalizado = normalizarClaves(stringMap);
            // Convertir timestamps a LocalDate solo en campos de fecha
            convertirFechasEnMap(normalizado);
            return MAPPER.convertValue(normalizado, clase);
        }
        return MAPPER.convertValue(item, clase);
    }

    private static Map<String, Object> convertirAMapDeStrings(Map<?, ?> map) {
        Map<String, Object> resultado = new LinkedHashMap<>();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() instanceof String key) {
                resultado.put(key, entry.getValue());
            }
        }
        return resultado;
    }

    private static Map<String, Object> normalizarClaves(Map<String, Object> map) {
        Map<String, Object> normalizado = new LinkedHashMap<>(map);
        map.forEach((clave, valor) -> normalizado.putIfAbsent(aCamelCase(clave), valor));
        return normalizado;
    }

    private static void convertirFechasEnMap(Map<String, Object> map) {
        map.replaceAll((clave, valor) -> {
            if (valor instanceof Number num && clave != null && clave.toUpperCase().contains("DATE")) {
                long timestamp = num.longValue();
                if (timestamp > 10000000000L) {
                    return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
                }
            }
            return valor;
        });
    }

    private static String aCamelCase(String str) {
        if (str == null || str.isEmpty()) return str;
        String[] partes = str.toLowerCase().split("_");
        return partes[0] + IntStream.range(1, partes.length)
                .mapToObj(i -> capitalizar(partes[i]))
                .collect(Collectors.joining());
    }

    private static String capitalizar(String str) {
        return str.isEmpty() ? str : str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

