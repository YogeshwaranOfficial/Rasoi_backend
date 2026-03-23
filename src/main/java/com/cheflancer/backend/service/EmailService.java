package com.cheflancer.backend.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class EmailService {

    @Autowired private JavaMailSender mailSender;

    @Async
    public void sendOtpEmail(String toEmail, String otp, String actionType) {
        final String safeToEmail = Objects.requireNonNull(toEmail);
        final String safeOtp = Objects.requireNonNull(otp);
        final String fromEmail = "rasoi@gmail.com";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(fromEmail);
            helper.setTo(safeToEmail);

            // --- DYNAMIC CONTENT LOGIC ---
            String subject;
            String heading;
            String bodyText;

            if ("RESET".equalsIgnoreCase(actionType)) {
                subject = "Reset Your RasoiElite Password";
                heading = "Security: Password Reset";
                bodyText = "We received a request to reset your password. Use the verification code below to set a new password. If you didn't request this, please secure your account.";
            } else {
                subject = "Verify Your RasoiElite Account";
                heading = "Welcome to the Family!";
                bodyText = "Thank you for joining RasoiElite. To complete your registration and start exploring personalized chef experiences, please use the verification code below:";
            }

            helper.setSubject(subject);

            // Inject the dynamic variables into the HTML
            String htmlContent = 
                "<div style='font-family: Arial, sans-serif; max-width: 600px; margin: auto; border: 1px solid #eee; padding: 20px;'>" +
                "  <div style='text-align: center; margin-bottom: 20px;'>" +
                "    <h1 style='color: #EA580C; margin: 0;'>RASOI ELITE</h1>" +
                "    <p style='color: #6B7280; font-size: 14px;'>Experience the Flavor of Home</p>" +
                "  </div>" +
                "  <hr style='border: 0; border-top: 1px solid #eee;' />" +
                "  <div style='padding: 20px 0;'>" +
                "    <h2 style='color: #1F2937;'>" + heading + "</h2>" + // Dynamic Heading
                "    <p style='color: #4B5563; line-height: 1.6;'>" + bodyText + "</p>" + // Dynamic Body
                "    <div style='text-align: center; margin: 30px 0;'>" +
                "      <span style='background: #FFF7ED; border: 2px dashed #EA580C; color: #EA580C; font-size: 32px; font-weight: bold; padding: 15px 30px; letter-spacing: 5px; border-radius: 10px;'>" + safeOtp + "</span>" +
                "    </div>" +
                "    <p style='color: #9CA3AF; font-size: 12px; text-align: center;'>This code is valid for 10 minutes.</p>" +
                "  </div>" +
                "</div>";

            helper.setText(htmlContent, true); 
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Email delivery failed: " + e.getMessage());
        }
    }
}