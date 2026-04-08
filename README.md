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