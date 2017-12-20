package sks.jakfromspace.medicloud;

/**
 * Coded by JAKfromSpace on 20-Dec-17 for Medicloud.
 */

class SingletonPatient {

    private String pID = "";
    private String dID = "";

    private static final SingletonPatient ourInstance = new SingletonPatient();
    static SingletonPatient getInstance() {
        return ourInstance;
    }
    private SingletonPatient() {
    }

    public void setpID(String id){
        this.pID = id;
    }
    public void setdID(String id){
        this.dID = id;
    }

    public String getpID(){
        return this.pID;
    }
    public String getdID(){
        return this.dID;
    }
}
