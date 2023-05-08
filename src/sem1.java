public class sem1 {

    private static int arrayLength(int[] array){
        if(array.length < 5){
            return -1;
        }
        return array.length;
    }
    public static void main(String[] args) throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6};
        int length = arrayLength(array);
        if(length>0){
            System.out.println("Length of array should be more than 5");
        } else {
            System.out.printf("Length of array: %d", length);
        }
    }
}
