package records;

public record Email(String email, String subject, String message) implements Notification {

    public Email {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Formato de correo electrónico inválido");
        }
    }
}
