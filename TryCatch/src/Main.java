import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 14, 11, 5, 9, 32, 7, 11, 15, 11};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir indeks girin : ");

        int index = scanner.nextInt();

        try {
            int result = array[index];
            System.out.println("Belirtilen indeksteki eleman: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Hata: Geçersiz indeks");
        }
    }
}