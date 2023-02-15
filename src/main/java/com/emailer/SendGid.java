package com.emailer;

import com.emailer.fields.Fields;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class SendGid {

    public void scannerInputs() {
        String dbTable; //To Email;

        String FromEmail; //Sending the Email Too

        String SUBJECT; //Subject Of Email

        String htmlfile; //Html Content Of email

        String plainTxt; //Plain Text Content of Email;

        Scanner sc = new Scanner(System.in); //New Input Scanner

        System.out.println("DataBaseTableName");
        dbTable = sc.nextLine();

        System.out.println("From Email");
        FromEmail =  sc.nextLine();

        System.out.println("Plain Text In Email");
        plainTxt =  sc.nextLine();

        System.out.println("Subject Of Email");
        SUBJECT = sc.nextLine();

        System.out.println("HTML File Location");
        htmlfile = sc.nextLine();
        createEmail(FromEmail, plainTxt, htmlfile, SUBJECT, dbOptions(dbTable));
    }

    public List<Fields> dbOptions(String table) {
        DbImply dbImply = new DbImply();
        List<Fields> field = dbImply.selectByTable(table);
        return field;
    }
    public static void createEmail(String f, String pT, String HTML, String Subject, List<Fields> dbTable) {
        for(Fields i : dbTable){
            try{
                Email from = new Email("test@example.com");
                String subject = "Sending with SendGrid is Fun";
                Email to = new Email(i.getTo());
                Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
                Mail mail = new Mail(from, subject, to, content);

                SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
                Request request = new Request();
                try {
                    request.setMethod(Method.POST);
                    request.setEndpoint("mail/send");
                    request.setBody(mail.build());
                    Response response = sg.api(request);
                    System.out.println(response.getStatusCode());
                    System.out.println(response.getBody());
                    System.out.println(response.getHeaders());
                } catch (IOException ex) {
                    throw ex;
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}

