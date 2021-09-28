package br.com.andersonsilva.calendar;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

public class Calendar {
    public static void main(String[] args) {
        VonageClient client = VonageClient.builder().apiKey("c9b22914").apiSecret("cpYjKB82toIWoqMb").build();
        TextMessage message = new TextMessage("Maps event",
                "5586988257359",
                "teste Api SMS API"
        );
        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }


    }
}
