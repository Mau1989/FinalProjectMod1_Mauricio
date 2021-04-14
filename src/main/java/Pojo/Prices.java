package Pojo;

public class Prices {
    private String ID;
    private String USD;
    private String EUR;
    private String PND;

    public Prices(String _ID, String _USD, String _EUR, String _PND){
        this.setID(_ID);
        this.setUSD(_USD);
        this.setEUR(_EUR);
        this.setPND(_PND);
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getEUR() {
        return EUR;
    }

    public void setEUR(String EUR) {
        this.EUR = EUR;
    }

    public String getPND() {
        return PND;
    }

    public void setPND(String PND) {
        this.PND = PND;
    }
}

