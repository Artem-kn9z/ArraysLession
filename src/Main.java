import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        boolean flag = true;
        boolean found;

        Book book1 = new Book("J","K",2015);
        Book book2 = new Book("F","M",1976);
        Book book3 = new Book("A","N",1999);
        Book book4 = new Book("C","L",2001);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        while (flag) {

            System.out.println("1) Добавить книгу \n" +
                               "2) Посмотреть все книги в списке \n" +
                               "3) Отсортировать книги по ... \n" +
                               "4) Удалить книгу \n" +
                               "5) Поиск книги \n" +
                               "6) Посмотреть книги от 2000 года публикации \n"+
                               "7) Выход");

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
                       books.forEach(System.out::println);
//                        for (int i = 0; i < books.size(); i++) {
//                            System.out.println((i+1) + ") " + books.get(i));
//                        }
                    }
                    break;

                case "3":
                    books = choiceSort(books);
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

                        books.stream()
                                .filter(book -> book.getTitle().toLowerCase().contains(searchBook.toLowerCase()))
                                .findFirst().ifPresent(System.out::println);

                        /*for (Book b : books) {
                            if (b.getTitle().toLowerCase().contains(searchBook.toLowerCase())) {
                                System.out.println("Вот книга по запросу: " + b);
                                found = true;
                            }
                        }*/

                        if( !books.stream()
                                .filter(book -> book.getTitle().toLowerCase().contains(searchBook.toLowerCase())).findFirst().isPresent()) {
                            System.out.println("Ох черт, походу такой книги нет(");
                        }
                    break;

                case "6":
                        books.stream().filter(book -> book.getYearOfPublication()>2000).forEach(System.out::println);
                    break;

                case "7":
                    flag = false;
                    break;

                default:
                    System.out.println("Ну как так, тебе был дан список цифр Долбик!");
                    break;
            }
        }
    }
    public static ArrayList<Book> choiceSort(ArrayList<Book> books) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выбери по чём сортируем:");
        System.out.println("1) По названию. \n" +
                           "2) По автору. \n" +
                           "3) По году издания?");

        String choiceSort = scan.nextLine();

        ArrayList<Book> sortedBooks = new ArrayList<>();

        switch (choiceSort) {
            case "1":
                sortedBooks = books.stream()
                                .sorted(Comparator.comparing(Book::getTitle))
                                .collect(Collectors.toCollection(ArrayList::new));
//                Collections.sort(books);
                break;
            case "2":
                sortedBooks = books.stream()
                        .sorted(Comparator.comparing(Book::getAuthor))
                        .collect(Collectors.toCollection(ArrayList::new));
//                Collections.sort(books, new BookAuthorComparator());
                break;
            case "3":
                sortedBooks = books.stream()
                        .sorted(Comparator.comparing(Book::getYearOfPublication))
                        .collect(Collectors.toCollection(ArrayList::new));
//                Collections.sort(books, new BookYOPComparator());
                break;

            default:
                System.out.println("1, 2 или 3 ебобо!");
                break;
        }

        if(sortedBooks.isEmpty()){
            System.out.println("Список книг пуст.");
        }else {
            sortedBooks.forEach(System.out::println);
//            for (int i = 0; i < books.size(); i++) {
//                System.out.println((i+1) + ") " + books.get(i));
//            }
        }
        return sortedBooks;
    }
}