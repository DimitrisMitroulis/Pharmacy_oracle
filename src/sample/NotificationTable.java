package sample;

import java.sql.Date;

public class NotificationTable {
    String notid,nsubj;
    Date ndate;

    public NotificationTable(String notid, String nsubj,Date ndate) {
        this.notid = notid;
        this.nsubj = nsubj;
        this.ndate = ndate;
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public String getNotid() {
        return notid;
    }

    public void setNotid(String notid) {
        this.notid = notid;
    }

    public String getNsubj() {
        return nsubj;
    }

    public void setNsubj(String nsubj) {
        this.nsubj = nsubj;
    }


}
