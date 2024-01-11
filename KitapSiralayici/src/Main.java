import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Book> bookSetByName = new TreeSet<>();
        bookSetByName.add(new Book("B Book", 260, "Yazar 1", "2021"));
        bookSetByName.add(new Book("A Book", 400, "Yazar 2", "2023"));
        bookSetByName.add(new Book("D Book", 435, "Yazar 3", "2020"));
        bookSetByName.add(new Book("C Book", 128, "Yazar 4", "2021"));
        bookSetByName.add(new Book("L Book", 500, "Yazar 5", "2022"));

        System.out.println("İsme göre sıralanmış kitaplar :");
        for (Book book : bookSetByName) {
            System.out.println(book);
        }

        Set<Book> bookSetByPageCount = new TreeSet<>((book1, book2) -> Integer.compare(book1.getPageCount(), book2.getPageCount()));
        bookSetByPageCount.addAll(bookSetByName);

        System.out.println("\nSayfa sayısına göre sıralanmış kitaplar :");
        for (Book book : bookSetByPageCount) {
            System.out.println(book);
        }
    }
}

class Book implements Comparable<Book> {
    private String title;
    private int pageCount;
    private String author;
    private String publishDate;

    public Book(String title, int pageCount, String author, String publishDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title = '" + title + '\'' +
                ", pageCount = " + pageCount +
                ", author = '" + author + '\'' +
                ", publishDate = '" + publishDate + '\'' +
                '}';
    }
}