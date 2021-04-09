package sample;

import java.sql.Date;

public class Farmaka_Table {
    String pid,pname,ptype,pstock,pkoaap,ptimessold;
    Date pexpdate;


    public Farmaka_Table(String pid, String pname, String ptype, Date pexpdate, String pstock, String pkoaap, String ptimessold) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pexpdate = pexpdate;
        this.pstock = pstock;
        this.pkoaap = pkoaap;
        this.ptimessold = ptimessold;
    }

    public String getPtimessold() {
        return ptimessold;
    }

    public void setPtimessold(String ptimessold) {
        this.ptimessold = ptimessold;
    }

    public Date getPexpdate() {
        return pexpdate;
    }

    public void setPexpdate(Date pexpdate) {
        this.pexpdate = pexpdate;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }


    public String getPstock() {
        return pstock;
    }

    public void setPstock(String pstock) {
        this.pstock = pstock;
    }

    public String getPkoaap() {
        return pkoaap;
    }

    public void setPkoaap(String pkoaap) {
        this.pkoaap = pkoaap;
    }
}
