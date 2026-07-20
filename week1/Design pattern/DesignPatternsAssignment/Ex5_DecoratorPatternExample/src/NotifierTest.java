public class NotifierTest {
    public static void main(String[] args) {
        System.out.println("-- Email only --");
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Server restarted");

        System.out.println();
        System.out.println("-- Email + SMS --");
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSms.send("Deployment finished");

        System.out.println();
        System.out.println("-- Email + SMS + Slack --");
        Notifier allChannels = new SlackNotifierDecorator(
                new SMSNotifierDecorator(new EmailNotifier()));
        allChannels.send("Production incident detected!");
    }
}
