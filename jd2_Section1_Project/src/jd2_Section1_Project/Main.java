package jd2_Section1_Project;

import java.util.Scanner;

public class Main {
	static UserTransactions userTransaction = new UserTransactions();
	static FilmTransactions filmTransaction = new FilmTransactions();
	static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int choice = 0;
		int transactionType = 0;
		//exampleDatas();
		do {
			printMenu();
			System.out.print("Seçiminiz: ");
			choice = scanner.nextInt(); // \n
			switch (choice) {
			case 1: {
				if (userTransaction.checkItemList()) {
					System.out.println("--------------------------------");
					System.out.print("User name : ");
					String name = scanner.next();

					System.out.print("User password : ");
					String password = scanner.next();

					userTransaction.login(name, password);
					System.out.println("--------------------------------");
				}
				break;
			}
			case 2:
			case 3: {
				System.out.println("--------------------------------");
				printTransactions();
				System.out.println("--------------------------------");
				System.out.print("işlem tipi seçin : ");
				transactionType = scanner.nextInt();
				if (transactionType == 4) {
					if (choice == 2)
						addUserTransaction();
					if (choice == 3)
						addFilmTransaction();
				} else if (transactionType == 5) {
					if (choice == 2 && userTransaction.checkItemList())
						removeUserTransaction();
					if (choice == 3 && filmTransaction.checkItemList())
						removeFilmTransaction();
				} else if (transactionType == 6) {
					if (choice == 2 && userTransaction.checkItemList())
						searchUserTransaction();
					if (choice == 3 && filmTransaction.checkItemList())
						searchFilmTransaction();
				} else if (transactionType == 7) {
					if (choice == 2 && userTransaction.checkItemList())
						userTransaction.printListData();
					if (choice == 3 && filmTransaction.checkItemList())
						filmTransaction.printListData();
				}
				break;
			}
			case -1: {
				System.out.println("İyi günler");
				break;
			}
			default:
				break;
			}
		} while (choice != -1);
	}

	private static void printMenu() {
		System.out.println("\n##### Menu #####");
		System.out.println(" 1: Kullanıcı girişi");
		System.out.println(" 2: Kullanıcı ile ilgili işlemler");
		System.out.println(" 3: Film ile ilgili işlemler");
		System.out.println("-1: Kullanıcı çıkışı");
	}

	private static void printTransactions() {
		System.out.println("4: ekleme");
		System.out.println("5: silme");
		System.out.println("6: isim arama");
		System.out.println("7: listeleme");
	}

	private static void exampleDatas() {
		String[] actors = { "ali", "Veli" };
		Film film = new Film(1, "titanic", "director", actors, MovieType.RomCom, "description", "releaseDate");
		User user = new User(1, "name", "password", "email");
		userTransaction.addData(user);
		filmTransaction.addData(film);
	}

	private static void addUserTransaction() {
		System.out.print("User ID : ");
		long id = scanner.nextLong();

		System.out.print("User name : ");
		String name = scanner.next();

		System.out.print("User password : ");
		String password = scanner.next();

		System.out.print("User email : ");
		String email = scanner.next();
		User user = new User(id, name, password, email);

		if (userTransaction.addData(user)) {
			System.out.println("işlem başarılı :)\n");
		} else {
			System.out.println("işlem başarısız :(\n");
		}
	}

	private static void removeUserTransaction() {
		System.out.print("User ID  for remove: ");
		long id = scanner.nextLong();
		if (userTransaction.removeData(id)) {
			System.out.println("işlem başarılı...\n");
		} else {
			System.out.println("kullanıcı bulunamadı");
		}

	}

	private static void searchUserTransaction() {

		System.out.print("User name for search: ");
		String name = scanner.next();
		User user = (User) userTransaction.searchDataByName(name);
		if (user == null)
			System.out.println("kullanıcı bulunamadı");
		else
			System.out.println(user);
		System.out.println("-------------------");
	}

	private static void searchFilmTransaction() {
		System.out.print("Film name for search: ");
		String name = scanner.next();
		Film film = (Film) filmTransaction.searchDataByName(name);
		if (film == null)
			System.out.println("Film bulunamadı");
		else
			System.out.println(film);
		System.out.println("-------------------");

	}

	private static void removeFilmTransaction() {
		System.out.print("Film ID  for remove: ");
		long id = scanner.nextLong();
		if (filmTransaction.removeData(id)) {
			System.out.println("işlem başarılı...\n");
		} else {
			System.out.println("film bulunamadı");
		}

	}

	private static void addFilmTransaction() {
		System.out.print("Film ID : ");
		long id = scanner.nextLong();

		System.out.print("Film name : ");
		String name = scanner.next();

		System.out.print("Film director  : ");
		String director = scanner.next();

		System.out.print("Film actors with commas(,) : ");
		String[] actors = scanner.next().split(",");
		MovieType movieType;
		do {
			System.out.println(java.util.Arrays.asList(MovieType.values()));
			System.out.print("Film type(1-2-3)  : ");
			int type = scanner.nextInt();
			movieType = MovieType.fromId(type);
		} while (movieType == null);

		System.out.print("Film description : ");
		String description = scanner.next();

		System.out.print("Film release Date : ");
		String releaseDate = scanner.next();
		Film film = new Film(id, name, director, actors, movieType, description, releaseDate);

		if (filmTransaction.addData(film)) {
			System.out.println("işlem başarılı :)\n");
		} else {
			System.out.println("işlem başarısız :(\n");
		}

	}

}
