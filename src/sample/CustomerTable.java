package sample;

public class CustomerTable {

    String cfname,clname,city,street,cemail,cid,stnumber,postalcode,cafmnumber;

    public CustomerTable(String cid, String cfname, String clname, String city, String street, String stnumber, String postalcode, String cemail, String cafmnumber) {
        this.cid = cid;
        this.cfname = cfname;
        this.clname = clname;
        this.city = city;
        this.street = street;
        this.stnumber = stnumber;
        this.postalcode = postalcode;
        this.cemail = cemail;
        this.cafmnumber = cafmnumber;
    }

    public String getCfname() {
        return cfname;
    }

    public void setCfname(String cfname) {
        this.cfname = cfname;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getStnumber() {
        return stnumber;
    }

    public void setStnumber(String stnumber) {
        this.stnumber = stnumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCafmnumber() {
        return cafmnumber;
    }

    public void setCcafmnumber(String cafmnumber) {
        this.cafmnumber = cafmnumber;
    }
}
