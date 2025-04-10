import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        boolean flag = true;

        while (flag) {

            System.out.println("1) Добавить книгу \n" +
                                "2) Посмотреть все книги в списке \n" +
                                 "3) Удалить книгу \n" +
                                  "4) Поиск книги \n" +
                                   "5) Выход");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    Book b1 = new Book();
                    System.out.println("Давай добавим книгу! \n" +
                            "Название книги: ");
                    b1.setTitle(sc.nextLine());
                    System.out.println("Автор книги: ");
                    b1.setAuthor(sc.nextLine());
                    System.out.println("Год издания книги: ");
                    b1.setYearOfPublication(sc.nextInt());
                    sc.nextLine();

                    books.add(b1);

                    System.out.println("Летс гооу!!! Ты добавил книгу: " + b1.toString());
                }
                    break;
                case "2": {
                    for (Book b : books) {
                        System.out.println(b.toString());
                    }
                    break;
                }
                case "3": {
                    System.out.println("Напиши название книги которую ты хочешь удалить со списка: ");
                    for (Book b : books) {
                        if (b.getTitle().equals(sc.nextLine())) {
                            books.remove(b);
                        }
                    }
                }
                    break;
                case "4": {
                        System.out.println("Какую книгу ты хочешь натйти?");
                        for (Book b : books) {
                            if (b.getTitle().equals(sc.nextLine())) {
                                b.toString();
                            } else {
                                System.out.println("Ох черт, походу такой книги нет(");
                            }
                        }
                    }
                    break;
                case "5": {
                    flag = false;
                }    break;
                default: {
                    System.out.println("Ну как так, тебе был дан список цифр Долбик!");
                }
                    break;
            }
        }
    }
}