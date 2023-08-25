package com.example.paic.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Utils {

    /**
     * Método que lanza una excepción la condición del predicado se cumple. Ejem:
     * AlterObjects.ifTrueThrow(Objeto,Object::isNull, BusinessException)
     *
     * @param value             objeto a evaluar.
     * @param predicate         condición.
     * @param exceptionSupplier suplidor de la excepción
     * @param <T>               tipo generico.
     * @since 2.0
     */
    public static <T> void ifTrueThrow(
            T value, Predicate<T> predicate, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (predicate.test(value)) {
            throw exceptionSupplier.get();
        }
    }

    /**
     * Método para pasar un dato de fehca al formato timestamp
     *
     * @param value - Parmámetro de tipo Object
     * @return
     * @throws Exception
     */
    public static Timestamp toTimestamp(Object value) throws Exception {
        try {
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
            Date date = formato.parse(value.toString());

            return new Timestamp(date.getTime());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    /**
     * Método para pasar un dato de fehca al formato timestamp
     *
     * @param value - Parmámetro de tipo Object
     * @return
     * @throws Exception
     */
    public static Timestamp toTimestamp2(Object value) throws Exception {
        try {
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date date = formato.parse(value.toString());

            return new Timestamp(date.getTime());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Método para obtener la fecha actual.
     *
     * @return
     */
    public static Timestamp getToday() {
        return new Timestamp(new Date().getTime());
    }


    public static String encriptar(String id, int maxLength) throws NoSuchAlgorithmException {
        // Cree una instancia de MessageDigest usando SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Obtenga los bytes del ID y calcule el hash
        byte[] hashBytes = digest.digest(id.getBytes());

        // Convierta los bytes hash a una cadena hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        // Truncar la cadena hexadecimal a la longitud deseada
        return hexString.substring(0, Math.min(hexString.length(), maxLength));
    }
}
