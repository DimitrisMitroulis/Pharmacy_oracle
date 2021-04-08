package sample;

public class Farmaka_Table {
    String pid,pname,ptype,pexpdate,pstock,pkoaap;

    public Farmaka_Table(String pid, String pname, String ptype, String pexpdate,  String pstock, String pkoaap) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pexpdate = pexpdate;
        this.pstock = pstock;
        this.pkoaap = pkoaap;
    }

    public String getPexpdate() {
        return pexpdate;
    }

    public void setPexpdate(String pexpdate) {
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
