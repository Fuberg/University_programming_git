package sync;

public class U1901Thread extends Thread {
    public U1901Bank bankWork;
    int intTrans;
    long lngSleep;

    public U1901Thread(U1901Bank bWork, int iTrans, long lSleep){
        this.bankWork = bWork;
        this.intTrans = iTrans;
        this.lngSleep = lSleep;

    }

    public void run(){
        bankWork.calc(intTrans, lngSleep);
    }
}
