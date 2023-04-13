# [ TUGAS PRAKTIKUM 2 PRAKTIKUM DPBO ]

## Identitas:
- NIM   : 2102313
- Nama  : Muhammad Kamal Robbani
- Kelas : C1'21

## Janji:
Saya [Muhammad Kamal Robbani] dengan nim 2102313 mengerjakan Tugas Praktikum 2 DPBO dalam mata kuliah 
[Desain Pemrograman Berorientasi Objek] untuk keberkahan-Nya maka saya tidak melakukan 
kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Requirements Soal:
Buatlah program Java yang terkoneksi dengan database MySQL. Berikut
spesifikasi program yang harus dibuat:
- Program bebas, kecuali program Mahasiswa dan Book Author
- Terdapat proses Create, Read, Update, dan Delete data
- Terdapat proses Autentikasi (Login, Register)
- Menggunakan minimal 2 tabel pada database
- Harus terdapat minimal 1 properti gambar pada class yang dibuat (gambar akan ditampilkan pada UI)
- Terdapat pergantian screen pada UI
- Terdapat button navigasi untuk beralih screen
- List data ditampilkan menggunakan card (JPanel)

## Desain Program:
![image](https://user-images.githubusercontent.com/101335350/231672365-687e7bb8-75ad-4429-a2e6-09192076b9e5.png)

## Alur Program:
- Masuk ke page Sign In.
  - (Sudah memiliki akun)
    - Mengisi field (username dan password).
    - Klik button 'sign in'.
    - Validasi akun.
    - Masuk ke page Daftar Album Musik.
  - (Belum memiliki akun)
    - Mengklik button 'sign up'.
    - Masuk ke page register.
    - Mengisi field (username dan password).
    - Klik button 'sign up'
    - Pindah ke page login, masuk ke step (Sudah memiliki akun).
- Masuk ke page List Album Musik, user dapat melakukan CURD:
  - (Create)
    - Mengisi data (nama album, pilih musisi dari dropdown, upload foto, tahun rilis album).
    - Klik button 'insert'.
    - Save foto album ke folder 'fotoAlbum' (jika user input gambar | kalau tidak pakai foto default).
    - Menjalankan query insert data into database.
    - END.
  - (Update)
    - Pilih data yang ingin di-update, lalu klik button 'manage'.
    - Update text button 'insert' => 'update'
    - Ubah data.
    - Klik button 'update'.
    - Hapus foto album sebelumnya (jika diubah).
    - Save foto album baru (jika diubah).
    - Menjalankan query save data into database.
    - END.
  - (Delete)
    - Pilih data yang ingin dihapus, lalu klik button 'manage'.
    - Set visibility button 'delete' => true.
    - Klik button 'delete'.
    - Hapus foto album sebelumnya (jika bukan foto default).
    - Menjalankan query delete data from database.
    - END.
- User dapat masuk ke page Musisi dengan mengklik button 'List Musisi'.
- Masuk ke page List Musisi, user dapat melakukan CURD:
  - (Create)
    - Mengisi data (nama musisi, lagu populer, upload foto musisi).
    - Klik button 'insert'.
    - Save foto album ke folder 'fotoAlbum' (jika user input gambar | kalau tidak pakai foto default).
    - Menjalankan query insert data into database.
    - END.
  - (Update)
    - Pilih data yang ingin di-update, lalu klik button 'manage'.
    - Update text button 'insert' => 'update'
    - Ubah data.
    - Klik button 'update'.
    - Hapus foto album sebelumnya (jika diubah).
    - Save foto album baru (jika diubah).
    - Menjalankan query save data into database.
    - END.
  - (Delete)
    - Pilih data yang ingin dihapus, lalu klik button 'manage'.
    - Set visibility button 'delete' => true.
    - Klik button 'delete'.
    - Hapus foto album sebelumnya (jika bukan foto default).
    - Menjalankan query delete data from database.
    - END.
- User dapat melakukan logout dengan mengklik button 'logout'.
- Masuk ke page Sign In.
    
## Dokumentasi:
- Sign In page:<br>
![SignInPage](https://user-images.githubusercontent.com/101335350/231650645-e543dbd6-47b2-48e1-9a75-578c110c6c99.png)
- Sign Up page:<br>
![SignUpPage](https://user-images.githubusercontent.com/101335350/231650692-a389e413-3e1a-458b-9945-f7ce4ad4995a.png)
- Musisi page:<br>
![MusisiPage](https://user-images.githubusercontent.com/101335350/231650734-576c89d3-f0ba-4abf-b885-91df3b954769.png)
- Album page:<br>
![AlbumPage](https://user-images.githubusercontent.com/101335350/231650758-de318551-b4ec-4951-ae3e-7bfe8b3d593d.png)
