package cobacoba;

import java.util.Scanner;

class Pilihan {
	public static boolean Yesorno(String pesan) {
		System.out.println("\n" + pesan + "\nJika Lanjut Masukkan (y)" + "\nJika Berhenti Masukan (n)");

		Scanner sc = new Scanner(System.in);
		String pilihan = sc.next();
		while (!pilihan.equalsIgnoreCase("Y") && !pilihan.equalsIgnoreCase("n")) {
			System.err.println("Pilihan Anda bukan Y ataupun N ");
			System.out.println("\n" + pesan + "(y/n)");
			pilihan = sc.next();
		}
		return pilihan.equalsIgnoreCase("y");
	}
}

class Node {
	int nilai;
	Node next;
	Node prev;
}

public class LinkedList2a {
	Node kepala;
	Node tail;

	public void SisipBelakang(int nilai) {
		Node node = new Node();
		node.nilai = nilai;
		node.next = null;
		if (kepala == null) {
			kepala = node;
		} else {
			Node n = kepala;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void SisipDepan(int nilai) {
		Node node = new Node();
		node.nilai = nilai;
		node.next = kepala;
		kepala = node;
	}

	public void SisipTengah(int nilai, int index) {
		Node node = new Node();
		node.next = null;
		node.nilai = nilai;
		if (kepala == null) {
			SisipDepan(nilai);
		} else {
			Node n = kepala;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}

	public void TampilData(boolean a) {
		Node x = null;
		if (a) {
			x = kepala;
		} else {
			x = tail;
		}
		System.out.print("[ ");
		while (x != null) {
			System.out.print(x.nilai + " ");
			if (a) {
				x = x.next;
			} else {
				x = x.prev;
			}
		}
		System.out.println("]");
	}

	public void sortList() {
		Node n = kepala;
		Node index = null;
		int temp;
		if (kepala == null) {
			return;
		} else {
			while (n != null) {
				index = n.next;
				while (index != null) {
					if (n.nilai < index.nilai) {
						temp = n.nilai;
						index.nilai = temp;
					}
					index = index.next;
				}
				n = n.next;
			}
		}
	}

	public void DeletAngkaDenganNilai(int nilai) {
		Node n = kepala;
		Node n1 = null;
		int count = 0;
		if (nilai == kepala.nilai) {
			kepala = kepala.next;
		} else {
			while (n.next != null) {
				n = n.next;
				if (nilai == n.nilai) {
					count++;
					break;
				}
				count++;
			}
			n = kepala;
			for (int i = 0; i < count - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
		}
	}

	public void DeletDepan() {
		kepala = kepala.next;
	}

	public void DeletBelakang() {
		if (kepala.next == null) {
			DeletDepan();
		} else {
			Node n = kepala;
			Node n1 = null;
			while (n.next.next != null) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;

		}
	}

	private static void programExit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		boolean ProgramRun = true;
		int pilihan1;
		int pilihan2;

		LinkedList2a op = new LinkedList2a();
		while (ProgramRun) {
			System.out.println("\n.: MENU :." + "\n 1. Tambah Data" + "\n 2. Hapus Data"+ "\n 3. Exit Program");

			System.out.print("Masukkan Pilihan :");
			pilihan1 = sc.nextInt();
			switch (pilihan1) {
			case 1:
				boolean dataRun = true;
				while (dataRun) {
					System.out.println("\n 1. Tambah Data Depan");
					System.out.println(" 2. Tambah Data Belakang");
					System.out.println(" 3. Tambah Data Tengah");
					System.out.println(" 4. Menu Utama");
					System.out.print("Masukkan Pilihan [1-4] :");
					pilihan2 = sc.nextInt();
					switch (pilihan2) {
					case 1:
						System.out.print("Masukkan Angka : ");
						x = sc.nextInt();
						op.SisipDepan(x);
						op.TampilData(true);
						break;
					case 2:
						System.out.print("Masukkan Angka : ");
						x = sc.nextInt();
						op.SisipBelakang(x);
						op.TampilData(true);
						break;
					case 3:
						System.out.print("Masukkan Angka : ");
						x = sc.nextInt();
						System.out.print("Masukkan Index : ");
						y = sc.nextInt();
						op.SisipTengah(x, y);
						op.TampilData(true);
						break;
					case 4:
						dataRun = Pilihan.Yesorno("Ingin tambah data lagi? ");
						break;
					}
				}
				break;
			case 2:
				boolean dataRun2 = true;
				while (dataRun2) {
					System.out.println("\n 1. Hapus Data Depan");
					System.out.println(" 2. Hapus Data Belakang");
					System.out.println(" 3. Hapus Data Tengah");
					System.out.println(" 4. Menu Utama");
					System.out.println(" Masukkan Angka [1-4]: ");
					pilihan2 = sc.nextInt();
					switch (pilihan2) {
					case 1:
						op.DeletDepan();
						op.TampilData(true);
						break;
					case 2:
						op.DeletBelakang();
						op.TampilData(true);
						System.out.println();
						break;
					case 3:
						System.out.print(" Masukkan Angka :");
						x = sc.nextInt();
						op.DeletAngkaDenganNilai(x);
						op.TampilData(true);
						break;
					case 4:
						dataRun2 = Pilihan.Yesorno("Ingin hapus data lagi? ");
						break;
					}
				}
				break;
			case 3:
				programExit();
				break;
			}
			ProgramRun = Pilihan.Yesorno("Apakah masih ingin memakai program ? ");
		}
	}
}