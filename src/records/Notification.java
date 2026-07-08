package records;

public sealed interface Notification permits Email, Push, SMS {

}
