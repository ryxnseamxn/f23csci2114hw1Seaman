public class ThreeRyanSeaman {
    public static void main(String[] args){
        ThreeRyanSeaman instance = new ThreeRyanSeaman();
        int n = Integer.parseInt(args[0]);
        Boolean[] toSieve = new Boolean[n];
        for( int i = 0 ; i < toSieve.length ; i++){
            if(i == 0 || i == 1){
                toSieve[i] = false;
            }else{
                toSieve[i] = true;
            }
        }
        double startTime = System.nanoTime();
        toSieve = instance.eratosthenes(toSieve);
        double duration = System.nanoTime() - startTime;
        duration = duration / (60 * Math.pow(10, 9));
        System.out.println("Minutes: " + duration);
        int i = toSieve.length -1;
        int j = 0;
        while(j < 5){
            if(toSieve[i] == true){
                System.out.println(i);
                j++;
            }
            i--;
        }

    }

    public Boolean[] eratosthenes(Boolean[] booleans) {
        for(int i = 2 ; i < booleans.length ; i++){
            for(int j = i + 1; j < booleans.length ; j++){
                if(j%i==0){
                    booleans[j] = false;
                }
            }
        }
        return booleans;
    }

}
