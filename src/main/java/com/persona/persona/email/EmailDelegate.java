package com.persona.persona.email;

import com.persona.persona.exception.FaildSendEmail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailDelegate {

    @Value("${app.sendgrid.key}")
    private String apiKey;

    @Value("${organization.from.email}")
    private String from;

    public void send(IEmail email) throws FaildSendEmail {

        Email to = new Email(email.getTo());
        Content content = new Content(email.getContent().getContentType(),
                email.getContent().getBody());
        String subject = email.getSubject();

        Mail mail = new Mail(new Email(from),subject,to,content);
        SendGrid sendGrid = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);

            if (response.getStatusCode() != 202){
                throw new FaildSendEmail("Failed to send email: " + response.getBody());
            }
        }catch (IOException | RuntimeException e){
            throw new FaildSendEmail(e.getMessage());
        }
    }
}
