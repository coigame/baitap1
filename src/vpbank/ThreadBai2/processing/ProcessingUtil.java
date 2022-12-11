package vpbank.ThreadBai2.processing;

import vpbank.ThreadBai2.Model.Msisdn;

public class ProcessingUtil {
    public static int toInt(String money){
        return Integer.parseInt(money);
    }
    public static boolean validWithdraw(int accountMoney, int Money){
        return accountMoney - Money >= 0;
    }

    public static boolean add(Msisdn customer, String money){
        int moneyHave = toInt(customer.getCurrentMoney());
        int moneyAdd = toInt(money);
        String moneyUpdate = String.valueOf(moneyAdd + moneyHave);
        customer.setCurrentMoney(moneyUpdate);
        return true;
    }
    public static boolean minus(Msisdn customer, String money){
        try {
            int moneyHave = toInt(customer.getCurrentMoney());
            int moneyMinus = toInt(money);
            if (validWithdraw(moneyHave, moneyMinus)) {
                String moneyUpdate = String.valueOf(moneyHave - moneyMinus);
                customer.setCurrentMoney(moneyUpdate);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static boolean transfer(Msisdn customerFrom, Msisdn customerTo, String money){
        if(minus(customerFrom, money)) {
            add(customerTo, money);
            return true;
        }else {
            return false;
        }
    }
}
