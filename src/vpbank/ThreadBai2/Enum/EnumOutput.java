package vpbank.ThreadBai2.Enum;

public enum EnumOutput {
        SUCCESS("EXECUTE SUCCESSFULLY"),
        FAILED("FAILED DUE TO ERROR");
        private String resultDetail;
        private EnumOutput(String resultDetail) {
            this.resultDetail = resultDetail;
        }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }
}
