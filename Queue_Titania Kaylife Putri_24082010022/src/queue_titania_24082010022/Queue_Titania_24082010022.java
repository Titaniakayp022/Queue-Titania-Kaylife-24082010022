package queue_titania_24082010022;

import java.util.Scanner;

class Barang {

    String nama;
    int harga;
    Barang next;

    Barang(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        this.next = null;
    }
}

class Queue {

    Barang front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(String nama, int harga) {
        Barang baru = new Barang(nama, harga);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        System.out.println("Barang berhasil dimasukkan ke antrian..");
    }

    public Barang dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong! Tidak ada barang yang bisa diproses..");
            return null;
        }
        Barang temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        return temp;
    }

    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian Kosong!");
            return;
        }
        System.out.println("\nDaftar Antrian Pembelian");
        Barang temp = front;
        int total = 0;
        while (temp != null) {
            System.out.println("- " + temp.nama + " (Rp" + temp.harga + ")");
            total += temp.harga;
            temp = temp.next;
        }
        System.out.println("Total nilai antrian: Rp " + total);
    }
}

public class Queue_Titania_24082010022 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue antrian = new Queue();
        int pilihan;
        int totalPemasukan = 0;

        System.out.println("====================================");
        System.out.println(" Nama : Titania Kaylife Putri");
        System.out.println(" NPM  : 1234567890");
        System.out.println("====================================");

        do {
            System.out.println("\n=== MENU ANTRIAN PEMBELIAN ===");
            System.out.println("1. Masukkan Barang (Enqueue)");
            System.out.println("2. Proses Barang (Dequeue");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = input.nextInt();
            input.nextLine(); //membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Barang: ");
                    String nama = input.nextLine();
                    System.out.print("Harga Barang: Rp ");
                    int harga = input.nextInt();
                    antrian.enqueue(nama, harga);
                    break;
                case 2:
                    Barang diproses = antrian.dequeue();
                    if (diproses != null) {
                        System.out.println("Memproses barang: " + diproses.nama + " (Rp " + diproses.harga + ")");
                        totalPemasukan += diproses.harga;
                        System.out.println("Total pemasukan sementara: Rp " + totalPemasukan);
                    }
                    break;
                case 3:
                    antrian.tampilkanAntrian();
                    break;
                case 4:
                    System.out.println("Program selesai..");
                    System.out.println("Total pemsukan akhir: Rp " + totalPemasukan);
                    break;

                default:
                    System.out.println("Pilihan tidak valid..");
            }
        } while (pilihan != 4);
        input.close();
    }

}
