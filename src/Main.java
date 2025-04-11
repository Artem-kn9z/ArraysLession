import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        boolean flag = true;
        boolean found;

        while (flag) {

            System.out.println("1) Добавить книгу \n" +
                                "2) Посмотреть все книги в списке \n" +
                                 "3) Удалить книгу \n" +
                                  "4) Поиск книги \n" +
                                   "5) Выход");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    Book b1 = new Book();
                    System.out.println("Давай добавим книгу!");

                    System.out.println("Название книги: ");
                    b1.setTitle(sc.nextLine());
                    System.out.println("Автор книги: ");
                    b1.setAuthor(sc.nextLine());
                    System.out.println("Год издания книги: ");
                    b1.setYearOfPublication(sc.nextInt());
                    sc.nextLine();

                    books.add(b1);

                    System.out.println("Летс гооу!!! Ты добавил книгу: " + b1.toString());
                    break;

                case "2":
                    if(books.isEmpty()){
                        System.out.println("Список книг пуст.");
                    }else {
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i+1) + ") " + books.get(i));
                        }
                    }
                    break;

                case "3":
                    System.out.println("Напиши название книги которую ты хочешь удалить со списка: ");
                    String titleToRemove = sc.nextLine();
                    found = false;

                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getTitle().equals(titleToRemove)) {
                            books.remove(i);
                            System.out.println("Книга удалена");
                            found = true;
                            break;
                        }
                    }

                    if(!found) {
                        System.out.println("Такой книги не найдено");
                    }
                    break;

                case "4":
                        System.out.println("Какую книгу ты хочешь натйти?");
                        String searchBook = sc.nextLine();
                        found = false;

                        for (Book b : books) {
                            if (b.getTitle().toLowerCase().contains(searchBook.toLowerCase())) {
                                System.out.println("Вот книга по запросу: " + b);
                                found = true;
                            }
                        }

                        if(!found) {
                            System.out.println("Ох черт, походу такой книги нет(");
                        }
                    break;

                case "5":
                    flag = false;
                    break;

                default:
                    System.out.println("Ну как так, тебе был дан список цифр Долбик!");
                    break;
            }
        }
    }
}