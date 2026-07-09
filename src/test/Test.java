package test;

import java.util.Arrays;
import java.util.Scanner;
import records.Email;
import records.Notification;
import records.Push;
import records.SMS;

public class Test {

    public static Email addEmail(Scanner scanner) {

        System.out.print("Ingresa el email: ");
        String email = scanner.nextLine();
        System.out.print("Ingresa el asunto: ");
        String subject = scanner.nextLine();
        System.out.print("Ingresa el mensaje: ");
        String message = scanner.nextLine();

        return new Email(email, subject, message);
    }

    public static SMS addSMS(Scanner scanner) {
        System.out.println("Ingresa el número telefónico: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Ingresa el mensaje: ");
        String message = scanner.nextLine();
        return new SMS(phoneNumber, message);
    }

    public static Push addPush(Scanner scanner) {
        System.out.println("Ingresa el token de dispositivo: ");
        String deviceToken = scanner.nextLine();
        System.out.println("Ingresa el mensaje: ");
        String message = scanner.nextLine();
        return new Push(deviceToken, message);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numEmail = 0, numSms = 0, numPush = 0, opc;
        Notification[] notifications = new Notification[0];

        do {
            System.out.print("""
                    
                    ========= MENÚ PRINCIPAL =========
                    1. Añadir notificación Email
                    2. Añadir notificación SMS
                    3. Añadir notificación Push
                    4. Finalizar e imprimir resumen
                    ==================================
                    Ingresa el número de opción:\s""");

            opc = Integer.parseInt(scanner.nextLine());

            try {
                Notification nuevaNotificacion = switch (opc) {
                    case 1 ->
                        addEmail(scanner);
                    case 2 ->
                        addSMS(scanner);
                    case 3 ->
                        addPush(scanner);
                    case 4 -> {
                        if (notifications.length == 0) {
                            System.out.println("Aún no se han agregado notificaciones");
                        }
                        yield null;
                    }
                    default -> {
                        System.out.println("Opción inválida. Intenta de nuevo.");
                        yield null;
                    }
                };
                if (nuevaNotificacion != null) {
                    notifications = Arrays.copyOf(notifications, notifications.length + 1);
                    notifications[notifications.length - 1] = nuevaNotificacion;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opc != 4);

        for (Notification notif : notifications) {
            switch (notif) {
                case Email email ->
                    numEmail++;
                case SMS sms ->
                    numSms++;
                case Push push ->
                    numPush++;
            }
        }

        System.out.println("========= RESUMEN =========");
        System.out.println("Correos enviados: " + numEmail);
        System.out.println("SMS enviados: " + numSms);
        System.out.println("Push enviados: " + numPush);
        System.out.println("Total: " + notifications.length);
    }
}
