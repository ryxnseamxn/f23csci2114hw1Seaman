public class TwoRyanSeaman {
    public static void main(String[] args){
        int n = 0;
        if(args.length > 0){
            try {
                n = Integer.parseInt(args[0]);
                System.out.println("Parsed int: " + n);
            } catch (NumberFormatException e){
                System.out.println("Error, input is not a parsable to an integer.");
            }
        }
        int[] array = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(i==0){
                array[i] = 0;
            }else{
                array[i] = 1;
            }
        }
        for(int i = 3 ; i < n ; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        int maxWidth = Integer.toString(array[array.length -1]).length();
        for(int i = 0 ; i < n ; i++) {
            System.out.printf("%" + maxWidth + "d", array[i]);
            if ((i + 1) % 7 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}
