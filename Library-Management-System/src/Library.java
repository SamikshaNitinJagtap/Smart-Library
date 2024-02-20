import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    ArrayList<Book> book;

    public Library() {
        this.book= new ArrayList<>();
    }

    public void addBook(String title,String author){
        Book newBook = new Book(title,author);
        book.add(newBook);
        System.out.println("Book added successfully: " + newBook.title);
    }

    public void displayBooks(){
        int i=1;
        System.out.println("Available Books");
        for(Book books : book ){
            if(books.isAvailable){
                System.out.println(i + " " +books.title + " by " +books.author);
                i++;
            }
        }
    }

    public void borrowBook(String title){
        for (Book books: book){
            if(books.title.equalsIgnoreCase(title) && books.isAvailable){
                books.isAvailable=false;
                System.out.println("You have successfully borrowed: " + books.title);
                return;
            }

        }
        System.out.println("Book not available for borrowing: " + title);
    }

    public void returnBook(String title){
        for (Book books : book){
            if (books.title.equalsIgnoreCase(title) && !books.isAvailable){
                books.isAvailable=true;
                System.out.println("You have successfully returned: "+ books.title);
                return;
            }
        }
        System.out.println("Book not found or already returned: " + title);
    }
}
