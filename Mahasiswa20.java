public class Mahasiswa20 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    // konstruktor default
    Mahasiswa20() {
    }

    // konstruktor berparameter (dibuat ada yang nama var parameter inputnya sama ada yang tidak)
    Mahasiswa20(String nm, String name, String kls, double ip) {
        nim = nm;
        nama = name;
        kelas = kls;
        ipk = ip;
    }

    void tampilInformasi() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Kelas: " + kelas);
        System.out.println("IPK: " + ipk);
    }
}