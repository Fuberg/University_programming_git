package sync;

public class U1901Bank {
    public int intTo;
    public int intFrom = 220;

    public synchronized void calc (int intTransaction, long lngTimeout) {
        System.out.println("Before : \nintTo : " + intTo + "\nintFrom : " + intFrom + "\n");
        Thread.currentThread().getName();
        intFrom = intFrom - intTransaction;
        try{
            Thread.sleep(lngTimeout);

        }catch (IllegalArgumentException e){
            System.out.println("Извините, значение задержки не может быть отрицательным! ");
        }catch(Exception ex){
            System.out.println("Другое исключение");
        }
        intTo = intTo + intTransaction;
        System.out.println("After : \nintTo : " + intTo + "\nintFrom : " + intFrom + "\n");
        Thread.currentThread().getName();
        System.out.println("Имя текущего потока : " + Thread.currentThread().getName());
    }

}
