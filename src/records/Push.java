package records;

public record Push(String deviceToken, String message) implements Notification {

    public Push {
        if (deviceToken == null || deviceToken.trim().isEmpty()) {
            throw new IllegalArgumentException("El token del dispositivo no puede ser nulo ni estar vacío");
        }
    }
}
