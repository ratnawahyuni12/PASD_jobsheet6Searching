# PASD_jobsheet6Searching

6.2 — Percobaan Sequential Search
1. Jelaskan perbedaan method tampilDataSearch dan tampilPosisi pada class MahasiswaBerprestasi!
Jawaban: 
  - tampilPosisi hanya menampilkan posisi indeks tempat data ditemukan dalam array. Contoh output: "data mahasiswa dengan IPK :3.5 ditemukan pada indeks 2"
  - tampilDataSearch menampilkan detail lengkap data mahasiswa (nim, nama, kelas, ipk) yang ditemukan di posisi tersebut
Jadi tampilPosisi kasih tahu di mana, sedangkan tampilDataSearch kasih tahu siapa.
2. Jelaskan fungsi break pada kode program di bawah ini! 
if (listMhs[j].ipk == cari) {
    posisi = j;
    break;
}
Jawaban: break berfungsi untuk menghentikan loop secara paksa ketika data yang dicari sudah ditemukan. Jadi begitu IPK cocok ditemukan di indeks j, program langsung keluar dari for loop tanpa perlu mengecek elemen-elemen berikutnya. Ini membuat pencarian lebih efisien karena tidak perlu iterasi sampai akhir array.
3. Apa fungsi variabel pos atau indeks hasil pencarian dalam program sequential search?
Jawaban: Variabel pos berfungsi sebagai penanda posisi (indeks) tempat data yang dicari ditemukan di dalam array. Nilainya diinisialisasi -1 sebagai tanda bahwa data belum/tidak ditemukan. Jika data ditemukan, pos diisi dengan nilai indeks j saat itu. Nilai pos kemudian dikembalikan dan digunakan oleh tampilPosisi dan tampilDataSearch untuk mengakses data mahasiswa yang tepat.
4. Jika terdapat lebih dari satu data dengan nilai yang sama, hasil pencarian sequential search yang dibuat di atas akan menampilkan data ke berapa? Jelaskan.
Jawaban: Akan menampilkan data yang pertama kali ditemukan (indeks terkecil). Karena setelah data pertama yang cocok ditemukan, langsung ada perintah break yang menghentikan loop, sehingga data dengan IPK yang sama di indeks berikutnya tidak akan ikut dicek.
5. Berkaitan dengan pertanyaan nomor 2 di atas, apa yang terjadi jika perintah break dihapus dari kode di atas?
Jawaban: Jika break dihapus, loop akan terus berjalan sampai akhir array meskipun data sudah ditemukan. Akibatnya jika ada lebih dari satu data dengan IPK yang sama, nilai posisi akan terus ditimpa dengan indeks terakhir yang cocok. Sehingga yang ditampilkan bukan data pertama yang ditemukan, melainkan data terakhir yang memiliki IPK sama.

6.3 — Percobaan Binary Search
1.	Tunjukkan pada kode program yang mana proses divide dijalankan!
Jawaban: Proses divide ada pada baris:
         mid = (left + right) / 2;
Di sinilah array dibagi dua dengan menghitung titik tengah (mid) dari batas kiri (left) dan batas kanan (right).
2.	Tunjukkan pada kode program yang mana proses conquer dijalankan!
Jawaban: Proses conquer ada pada bagian rekursif:
return findBinarySearch(cari, left, mid - 1);  // cari di bagian kiri
// atau
return findBinarySearch(cari, mid + 1, right); // cari di bagian kanan
Di sinilah program memilih salah satu bagian (kiri atau kanan) dan menaklukkan sub-array tersebut dengan memanggil method yang sama secara rekursif.
3.	Apa fungsi left, right, dan mid?
Jawaban: 
  - left → batas indeks paling kiri dari bagian array yang sedang dicari
  - right → batas indeks paling kanan dari bagian array yang sedang dicari
  - mid → indeks tengah yang dihitung dari (left + right) / 2, digunakan untuk membandingkan nilai tengah dengan data yang dicari
4.	Jika data IPK yang dimasukkan tidak urut. Apakah program masih dapat berjalan? Mengapa demikian?
Jawaban: Program tetap bisa berjalan tanpa error, namun hasilnya tidak akurat. Binary search mengasumsikan data sudah terurut. jika tidak urut, proses pembagian kiri/kanan menjadi salah arah, sehingga data yang sebenarnya ada bisa dinyatakan tidak ditemukan.
5.	Jika IPK yang dimasukkan dari IPK terbesar ke terkecil (misal: 3.8, 3.7, 3.5, 3.4, 3.2) dan elemen yang dicari adalah 3.2. Bagaimana hasil dari binary search? Apakah sesuai? Jika tidak sesuai maka ubahlah kode program binary seach agar hasilnya sesuai
Jawaban: Hasilnya tidak sesuai / tidak ditemukan, karena kode binary search di atas mengasumsikan data terurut ASC (kecil ke besar). Jika data DSC (besar ke kecil), logika perbandingan harus dibalik.
Ubah method findBinarySearch menjadi:
int findBinarySearch(double cari, int left, int right) {
    int mid;
    if (right >= left) {
        mid = (left + right) / 2;
        if (cari == listMhs[mid].ipk) {
            return mid;
        } else if (listMhs[mid].ipk < cari) {  // dibalik dari > menjadi <
            return findBinarySearch(cari, left, mid - 1);
        } else {
            return findBinarySearch(cari, mid + 1, right);
        }
    }
    return -1;
}
6.	Jelaskan bagaimana binary search menentukan bahwa data yang dicari tidak ditemukan di dalam array.
Jawaban: Data dinyatakan tidak ditemukan ketika kondisi right >= left sudah tidak terpenuhi, artinya right < left. Ini terjadi ketika ruang pencarian sudah habis menyempit dan tidak ada elemen yang cocok. Pada kondisi ini method mengembalikan nilai -1 sebagai tanda data tidak ditemukan.
7.	Modifikasi program di atas yang mana jumlah mahasiswa yang diinputkan sesuai dengan masukan dari keyboard.
Jawaban: Ubah bagian deklarasi jumMhs di MahasiswaDemo20 dari nilai tetap 5 menjadi input dari user, dan sesuaikan ukuran array di MahasiswaBerprestasi20:

- Di MahasiswaDemo20.java, ubah:
// Sebelum
int jumMhs = 5;

// Sesudah
System.out.print("Masukkan jumlah mahasiswa: ");
int jumMhs = sc.nextInt();
sc.nextLine();

- Di MahasiswaBerprestasi20.java, ubah deklarasi array dari ukuran tetap menjadi dinamis:
// Sebelum
Mahasiswa20[] listMhs = new Mahasiswa20[5];

// Sesudah — constructor dengan parameter
Mahasiswa20[] listMhs;

MahasiswaBerprestasi20(int jumlah) {
    listMhs = new Mahasiswa20[jumlah];
}

- Dan di MahasiswaDemo20.java saat membuat objek list:
// Sebelum
MahasiswaBerprestasi20 list = new MahasiswaBerprestasi20();

// Sesudah — setelah input jumMhs
MahasiswaBerprestasi20 list = new MahasiswaBerprestasi20(jumMhs);