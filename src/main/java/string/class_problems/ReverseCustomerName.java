public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        StringBuilder reversed = new StringBuilder(customerName);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}