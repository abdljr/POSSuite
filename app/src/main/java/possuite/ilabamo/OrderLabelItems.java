package possuite.ilabamo;

public class OrderLabelItems {
    private int id;
    private String description;
    private double bill;
    private String timestamp;
    private String upd_ts;

    public OrderLabelItems(int id, String description, double bill, String timestamp, String upd_ts) {
        this.id = id;
        this.description = description;
        this.bill = bill;
        this.timestamp = timestamp;
        this.upd_ts = upd_ts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpd_ts() {
        return upd_ts;
    }

    public void setUpd_ts(String upd_ts) {
        this.upd_ts = upd_ts;
    }
}
