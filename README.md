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
