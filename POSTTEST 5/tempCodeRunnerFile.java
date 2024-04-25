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

class ProfessionalChessPlayer extends ChessPlayer {
    private int tournamentWins;

    public ProfessionalChessPlayer(String name, int age, int rating, String preferredOpenings, int tournamentWins) {
        super(name, age, rating, preferredOpenings);
        this.tournamentWins = tournamentWins;
    }

    public int getTournamentWins() {
        return tournamentWins;
    }

    public void setTournamentWins(int tournamentWins) {
        this.tournamentWins = tournamentWins;
    }

    @Override
    public String toString() {
        return super.toString() + ", Turnamen yang dimenangkan: " + tournamentWins;
    }
}

class ChessCoach extends ChessPlayer {
    private int coachingExperience;
    private String specialization;

    public ChessCoach(String name, int age, int rating, String preferredOpenings, int coachingExperience, String specialization) {
        super(name, age, rating, preferredOpenings);
        this.coachingExperience = coachingExperience;
        this.specialization = specialization;
    }

    public int getCoachingExperience() {
        return coachingExperience;
    }

    public void setCoachingExperience(int coachingExperience) {
        this.coachingExperience = coachingExperience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pengalaman Melatih: " + coachingExperience + " tahun, Spesialisasi: " + specialization;
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
        System.out.println("\nMasukkan jenis profil yang ingin ditambahkan (1: Kasual, 2: Profesional, 3: Coach): ");
        int playerType = Integer.parseInt(scanner.nextLine());
    
        System.out.println("\nMasukkan detail profil player:");
    
        System.out.print("Nama: ");
        String name = scanner.nextLine();
    
        System.out.print("Umur: ");
        int age = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Rating: ");
        int rating = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Pembuka Favorit: ");
        String preferredOpenings = scanner.nextLine();
    
        switch (playerType) {
            case 1:
                addPlayer(name, age, rating, preferredOpenings);
                break;
            case 2:
                System.out.print("Jumlah Turnamen yang dimenangkan: ");
                int tournamentWins = Integer.parseInt(scanner.nextLine());
                addPlayer(name, age, rating, preferredOpenings, tournamentWins);
                break;
            case 3:
                System.out.print("Pengalaman Melatih (tahun): ");
                int coachingExperience = Integer.parseInt(scanner.nextLine());
                System.out.print("Spesialisasi: ");
                String specialization = scanner.nextLine();
                addPlayer(name, age, rating, preferredOpenings, coachingExperience, specialization);
                break;
            default:
                System.out.println("Jenis profil tidak valid!");
                break;
        }
    }
    
    private static void addPlayer(String name, int age, int rating, String preferredOpenings) {
        ChessPlayer player = new ChessPlayer(name, age, rating, preferredOpenings);
        players.add(player);
        System.out.println("Profil Pemain telah ditambahkan!");
    }
    
    private static void addPlayer(String name, int age, int rating, String preferredOpenings, int tournamentWins) {
        ProfessionalChessPlayer professionalPlayer = new ProfessionalChessPlayer(name, age, rating, preferredOpenings, tournamentWins);
        players.add(professionalPlayer);
        System.out.println("Profil Pemain telah ditambahkan!");
    }
    
    private static void addPlayer(String name, int age, int rating, String preferredOpenings, int coachingExperience, String specialization) {
        ChessCoach coach = new ChessCoach(name, age, rating, preferredOpenings, coachingExperience, specialization);
        players.add(coach);
        System.out.println("Profil Coach telah ditambahkan!");
    }
    
    
    private static void viewAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("Tidak ada profil yang tersimpan.");
            return;
        }
    
        System.out.println("\nProfil player:");
        for (ChessPlayer player : players) {
            if (player instanceof ProfessionalChessPlayer) {
                System.out.println("Role: Profesional");
            } else if (player instanceof ChessCoach) {
                System.out.println("Role: Coach");
            } else {
                System.out.println("Role: Kasual");
            }
            System.out.println(player);
        }
    }
    
    
    
    private static void updatePlayer() {
        System.out.println("\nMasukkan nama profil yang ingin diedit:");
        String name = scanner.nextLine();
    
        boolean found = false;
        for (ChessPlayer player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                System.out.println("Masukkan detail:");
                System.out.print("Nama: ");
                String newName = scanner.nextLine();
                player.setName(newName);
    
                System.out.print("Umur: ");
                int age = Integer.parseInt(scanner.nextLine());
                player.setAge(age);
    
                System.out.print("Rating: ");
                int rating = Integer.parseInt(scanner.nextLine());
                player.setRating(rating);
    
                System.out.print("Pembuka Favorit: ");
                String preferredOpenings = scanner.nextLine();
                player.setPreferredOpenings(preferredOpenings);
    
                if (player instanceof ProfessionalChessPlayer) {
                    ProfessionalChessPlayer professionalPlayer = (ProfessionalChessPlayer) player;
                    System.out.print("Jumlah Turnamen yang dimenangkan: ");
                    int tournamentWins = Integer.parseInt(scanner.nextLine());
                    professionalPlayer.setTournamentWins(tournamentWins);
                } else if (player instanceof ChessCoach) {
                    ChessCoach coach = (ChessCoach) player;
                    System.out.print("Pengalaman Melatih (tahun): ");
                    int coachingExperience = Integer.parseInt(scanner.nextLine());
                    coach.setCoachingExperience(coachingExperience);
                    System.out.print("Spesialisasi: ");
                    String specialization = scanner.nextLine();
                    coach.setSpecialization(specialization);
                }
    
                System.out.println("Profil player telah diedit!");
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Profil tidak ditemukan!");
        }
    }
    
    private static void deletePlayer() {
        System.out.println("\nMasukkan nama profil yang ingin dihapus:");
        String name = scanner.nextLine();
    
        boolean removed = players.removeIf(player -> player.getName().equalsIgnoreCase(name));
    
        if (removed) {
            System.out.println("Profil dihapus!");
        } else {
            System.out.println("Profil tidak ditemukan!");
        }
    }
    
}
