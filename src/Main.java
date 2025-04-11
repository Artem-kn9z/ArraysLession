import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        boolean flag = true;
        boolean found;

        Book book1 = new Book("J","K",1999);
        Book book2 = new Book("F","M",1999);
        Book book3 = new Book("A","N",1999);
        Book book4 = new Book("C","L",1999);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        while (flag) {

            System.out.println("1) Добавить книгу \n" +
                                "2) Посмотреть все книги в списке \n" +
                                 "3) Отсортировать книги по названию \n" +
                                  "4) Удалить книгу \n" +
                                   "5) Поиск книги \n" +
                                    "6) Выход");

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

                    System.out.println("Выбери по чём сортируем:");
                    System.out.println("1) По названию. \n" +
                                        "2) По автору. \n" +
                                         "3) По году издания?");
                    switch (sc.nextInt()) {
                        case 1:
                            Collections.sort(books);
                            break;
                        case 2:
                            Collections.sort(books, new BookAuthorComparator());
                            break;
                        case 3:
                            Collections.sort(books, new BookYOPComparator());
                            break;

                        default:
                            System.out.println("1, 2 или 3 ебобо!");
                            break;
                    }

                    if(books.isEmpty()){
                        System.out.println("Список книг пуст.");
                    }else {
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i+1) + ") " + books.get(i));
                        }
                    }
                    break;

                case "4":
                    System.out.println("Напиши название книги которую ты хочешь удалить со списка: ");
                    String titleToRemove = sc.nextLine();
                    found = false;

                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getTitle().equalsIgnoreCase(titleToRemove)) {
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

                case "5":
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

                case "6":
                    flag = false;
                    break;

                default:
                    System.out.println("Ну как так, тебе был дан список цифр Долбик!");
                    break;
            }
        }
    }
}