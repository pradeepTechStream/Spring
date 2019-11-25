package com.techstream;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("Sending Email...");

        try {
            sendEmail();
            sendEmailWithAttachment();
        }
        catch (final MessagingException e) {
            e.printStackTrace();
        }
        catch (final IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }

    void sendEmail() throws MessagingException, IOException {

        final SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("pradeepmaurya560@gmail.com");
        msg.setTo("p.maurya@direction.biz", "g.yadav@direction.biz");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        this.javaMailSender.send(msg);

    }

    void sendEmailWithAttachment() throws MessagingException, IOException {

        final MimeMessage msg = this.javaMailSender.createMimeMessage();

        // true = multipart message
        final MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("p.maurya@direction.biz");
        helper.setReplyTo("g.yadav@direction.biz");
        helper.setSubject("Email Testing");
        helper.setText("<h1>Check attachment for image!</h1>", true);

        // FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        // Resource resource = new ClassPathResource("car.png");
        // InputStream input = resource.getInputStream();

        // ResourceUtils.getFile("classpath:android.png");

        helper.addAttachment("your_photo.png", new ClassPathResource("car.png"));
        this.javaMailSender.send(msg);

    }
}
