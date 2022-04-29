# Tugas Besar 2 IF2210 Permograman Berorientasi Objek

## Kelompok DoraemonSantuy
- Primanda Adyatma Hafiz (13520022)
- Hansel Valentino Tanoto (13520046)
- Lyora Felicya (13520073)
- Claudia (13520076)
- Nicholas Budiono (13520121)

## Requirement
JDK 17, Gradle 7.3.3, library JavaFx

## Cara Menjalankan Program
Masukkan command ```./gradlew run```

## Struktur program
📦main </br>
 ┣ 📂java </br>
 ┃ ┣ 📂com </br>
 ┃ ┃ ┣ 📂aetherwars </br>
 ┃ ┃ ┃ ┣ 📂model </br>
 ┃ ┃ ┃ ┃ ┣ 📂Characters </br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Character.java </br>
 ┃ ┃ ┃ ┃ ┣ 📂Spells </br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LvlSpell.java </br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MorphSpell.java </br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PtnSpell.java </br>
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Spell.java </br>
 ┃ ┃ ┃ ┃ ┃ ┗ 📜SwapSpell.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜Board.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜Card.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜CardReader.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜cardSlot.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜Deck.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜Hand.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜Player.java </br>
 ┃ ┃ ┃ ┃ ┗ 📜Type.java </br>
 ┃ ┃ ┃ ┣ 📂util </br>
 ┃ ┃ ┃ ┃ ┣ 📜CSVReader.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜HandFullExp.java </br>
 ┃ ┃ ┃ ┃ ┗ 📜InvalidException.java </br>
 ┃ ┃ ┗ 📂gui </br>
 ┃ ┃ ┃ ┗ 📂mainguiwindow </br>
 ┃ ┃ ┃ ┃ ┣ 📜DrawController.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜FullHandController.java </br>
 ┃ ┃ ┃ ┃ ┣ 📜guiController.java </br>
 ┃ ┃ ┃ ┃ ┗ 📜mainGui.java </br>
 ┃ ┗ 📜module-info.java </br>
 ┗ 📂resources </br>
 ┃ ┗ 📂com </br>
 ┃ ┃ ┗ 📂gui </br>
 ┃ ┃ ┃ ┗ 📂mainguiwindow </br>
 ┃ ┃ ┃ ┃ ┣ 📜drawPhase.fxml </br>
 ┃ ┃ ┃ ┃ ┣ 📜fullHand.fxml </br>
 ┃ ┃ ┃ ┃ ┣ 📜gui.fxml </br>
 ┃ ┃ ┃ ┃ ┣ 📜style.css </br>
 ┃ ┃ ┃ ┃ ┣ 📜styleDrawPhase.css </br>
 ┃ ┃ ┃ ┃ ┗ 📜styleFullHand.css </br>

## Screenshoot Aplikasi

### Tampilan awal
![image](https://user-images.githubusercontent.com/72249771/165944061-63e6d874-e9cb-44a4-994f-733ccd3c6c33.png)
### Mengambil kartu dari Deck
![image](https://user-images.githubusercontent.com/72249771/165944156-d07a90b6-ae6f-4717-8df4-a43241a05be0.png)
### Tampilan hover kartu
![image](https://user-images.githubusercontent.com/72249771/165944274-50d848f5-f84c-4b3d-8f4e-e450db653775.png)
### Menaruh kartu pada Board
![image](https://user-images.githubusercontent.com/72249771/165944403-605d12d4-182d-4c19-9372-d2646bc5c796.png)
### Melakukan attack card
![image](https://user-images.githubusercontent.com/72249771/165944557-c845df86-6c87-4668-8e02-42e6a6017a5d.png)
### Melakukan attack player
![image](https://user-images.githubusercontent.com/72249771/165944665-5f991e0b-9fda-4927-8e53-fedf73746e98.png)




