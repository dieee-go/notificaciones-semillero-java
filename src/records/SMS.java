package records;

public record SMS(String deviceToken, String message) implements Notification {

    public SMS {
        if (deviceToken == null || deviceToken.trim().isEmpty()) {
            throw new IllegalArgumentException("El token del dispositivo no puede ser nulo ni estar vacío");
        }
    }
}
