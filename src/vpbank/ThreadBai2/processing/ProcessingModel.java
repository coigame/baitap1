package vpbank.ThreadBai2.processing;

import vpbank.ThreadBai2.Model.Messages;
import vpbank.ThreadBai2.Model.Output;

public class ProcessingModel {
    public static Output outputCreate(boolean value, Messages messages){
        Output output = new Output();
        output.setAction(messages.getAction());
        if(messages.getAction().equals("transfer")) {
            output.setPhoneNumberFrom(messages.getPhoneNumberFrom());
        }
        output.setMoneyAmount(messages.getMoney());
        output.setPhoneNumberTo(messages.getPhoneNumberTo());
        output.setResult(value);
        output.setResultDetail(value);
        return output;
    }

    public static Messages messageCreate(String[] message){
        Messages messages = new Messages();
        if (message.length == 4) {
            messages.setAction(message[0]);
            messages.setPhoneNumberFrom(message[1]);
            messages.setPhoneNumberTo(message[2]);
            messages.setMoney(message[3]);
        }else{
            messages.setAction(message[0]);
            messages.setPhoneNumberTo(message[1]);
            messages.setMoney(message[2]);
        }
        return messages;
    }
}
