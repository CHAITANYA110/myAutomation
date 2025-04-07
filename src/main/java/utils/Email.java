package utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class Email {
    public static void sendEmailWithReport(String reportPath) {
        final String fromEmail = "chaitanyaa292@gmail.com";  // Sender Email
        final String password = "hurxsjqnlvpbpxop"; // Use App Password for Gmail
        final String toEmail = "canand.xrmn3@gmail.com";  // Receiver Email

        // SMTP Server Properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");  // Gmail SMTP Server
        props.put("mail.smtp.port", "587");             // Port (587 for TLS, 465 for SSL)
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS security

        // Authenticate Sender
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create Email Message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Automation Test Report");

            // Attach Report File
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hi,\n\nPlease find the attached Automation Test Report.\n\nBest Regards,\nAutomation Team");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            //String reportPath = System.getProperty("user.dir") + "/reports/AutomationReport.html"; // Path to your report
            File file = new File(reportPath);
            if (!file.exists()) {
                System.out.println("❌ Report file not found: " + reportPath);
                return;
            }
            attachmentPart.attachFile(file);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send Email
            javax.mail.Transport.send(message);
            System.out.println("✅ Email Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
