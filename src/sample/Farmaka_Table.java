package sample;

import java.sql.Date;

public class Farmaka_Table {
    String id,name,type,stock,koaap,timessold;
    Date expdate;


    public Farmaka_Table(String id, String name, String type,Date expdate ,String stock, String koaap, String timessold ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.koaap = koaap;
        this.timessold = timessold;
        this.expdate = expdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getKoaap() {
        return koaap;
    }

    public void setKoaap(String koaap) {
        this.koaap = koaap;
    }

    public String getTimessold() {
        return timessold;
    }

    public void setTimessold(String timessold) {
        this.timessold = timessold;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }
}
