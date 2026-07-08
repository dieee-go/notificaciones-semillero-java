package records;

public record Push(String phoneNumber, String message) implements Notification {

    public Push {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("El número telefónico debe tener exactamente 10 dígitos");
        }
    }
}
