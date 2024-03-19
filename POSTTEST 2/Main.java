import java.util.ArrayList;
import java.util.Scanner;

class ChessPlayer {
    private String name;
    private int age;
    private int rating;
    private String preferredOpenings;

    public ChessPlayer(String name, int age, int rating, String preferredOpenings) {
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.preferredOpenings = preferredOpenings;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPreferredOpenings() {
        return preferredOpenings;
    }

    public void setPreferredOpenings(String preferredOpenings) {
        this.preferredOpenings = preferredOpenings;
    }

    public String toString() {
        return "Nama: " + name + ", Umur: " + age + ", Rating: " + rating + ", Pembuka Favorit: " + preferredOpenings;
    }
}

public class Main {
    private static ArrayList<ChessPlayer> players = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat datang dalam CheXProfiler!");

        while (true) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah profil");
            System.out.println("2. Lihat semua profil");
            System.out.println("3. Edit profil");
            System.out.println("4. Hapus profil");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan anda: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addPlayer();
                    break;
                case 2:
                    viewAllPlayers();
                    break;
                case 3:
                    updatePlayer();
                    break;
                case 4:
                    deletePlayer();
                    break;
                case 5:
                    System.out.println("Program akan keluar");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid, mohon coba lagi.");
            }
        }
    }

    private static void addPlayer() {
        System.out.println("\nMasukkan detail profil player:");

        System.out.print("Nama: ");
        String name = scanner.nextLine();

        System.out.print("Umur: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Rating: ");
        int rating = Integer.parseInt(scanner.nextLine());

        System.out.print("Pembuka Favorit: ");
        String preferredOpenings = scanner.nextLine();

        ChessPlayer player = new ChessPlayer(name, age, rating, preferredOpenings);
        players.add(player);
        System.out.println("Profil telah ditambahkan!");
    }

    private static void viewAllPlayers() {
        System.out.println("\nProfil player:");
        for (ChessPlayer player : players) {
            System.out.println(player);
        }
    }

    private static void updatePlayer() {
        System.out.println("\nMasukkan nama profil yang ingin di edit:");
        String name = scanner.nextLine();

        boolean found = false;
        for (ChessPlayer player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                System.out.println("Masukkan detail:");
                System.out.print("Nama: ");
                String newname = scanner.nextLine();
                player.setName(name);

                System.out.print("Umur: ");
                int age = Integer.parseInt(scanner.nextLine());
                player.setAge(age);

                System.out.print("Rating: ");
                int rating = Integer.parseInt(scanner.nextLine());
                player.setRating(rating);

                System.out.print("Pembuka Favorit: ");
                String preferredOpenings = scanner.nextLine();
                player.setPreferredOpenings(preferredOpenings);

                System.out.println("Profil player telah di edit!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Player not found!");
        }
    }

    private static void deletePlayer() {
        System.out.println("\nEnter the name of the player to delete:");
        String name = scanner.nextLine();

        boolean removed = players.removeIf(player -> player.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Player deleted successfully!");
        } else {
            System.out.println("Player not found!");
        }
    }
}
