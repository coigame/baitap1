package vpbank.ThreadBai2.Model;

import vpbank.ThreadBai2.Enum.EnumOutput;

public class Output {
    private String action;
    private String phoneNumberFrom;
    private String PhoneNumberTo;
    private String moneyAmount;
    private String startProcess;
    private String endProcess;
    private String Result;
    private String ResultDetail;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPhoneNumberFrom() {
        return phoneNumberFrom;
    }

    public void setPhoneNumberFrom(String phoneNumberFrom) {
        this.phoneNumberFrom = phoneNumberFrom;
    }

    public String getPhoneNumberTo() {
        return PhoneNumberTo;
    }

    public void setPhoneNumberTo(String phoneNumberTo) {
        PhoneNumberTo = phoneNumberTo;
    }

    public String getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(String moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getStartProcess() {
        return startProcess;
    }

    public void setStartProcess(String startProcess) {
        this.startProcess = startProcess;
    }

    public String getEndProcess() {
        return endProcess;
    }

    public void setEndProcess(String endProcess) {
        this.endProcess = endProcess;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(Boolean value) {
        if(value){
            Result = EnumOutput.SUCCESS.name();
        }else {
            Result = EnumOutput.FAILED.name();
        }
    }

    public String getResultDetail() {
        return ResultDetail;
    }

    public void setResultDetail(Boolean value) {
        if(value){
            ResultDetail = EnumOutput.SUCCESS.getResultDetail();
        }else {
            ResultDetail = EnumOutput.FAILED.getResultDetail();
        }
    }
}
