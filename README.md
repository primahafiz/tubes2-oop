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
📦main
 ┣ 📂java
 ┃ ┣ 📂com
 ┃ ┃ ┣ 📂aetherwars
 ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┣ 📂Characters
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Character.java
 ┃ ┃ ┃ ┃ ┣ 📂Spells
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LvlSpell.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MorphSpell.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PtnSpell.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Spell.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜SwapSpell.java
 ┃ ┃ ┃ ┃ ┣ 📜Board.java
 ┃ ┃ ┃ ┃ ┣ 📜Card.java
 ┃ ┃ ┃ ┃ ┣ 📜CardReader.java
 ┃ ┃ ┃ ┃ ┣ 📜cardSlot.java
 ┃ ┃ ┃ ┃ ┣ 📜Deck.java
 ┃ ┃ ┃ ┃ ┣ 📜Hand.java
 ┃ ┃ ┃ ┃ ┣ 📜Player.java
 ┃ ┃ ┃ ┃ ┗ 📜Type.java
 ┃ ┃ ┃ ┣ 📂util
 ┃ ┃ ┃ ┃ ┣ 📜CSVReader.java
 ┃ ┃ ┃ ┃ ┣ 📜HandFullExp.java
 ┃ ┃ ┃ ┃ ┗ 📜InvalidException.java
 ┃ ┃ ┗ 📂gui
 ┃ ┃ ┃ ┗ 📂mainguiwindow
 ┃ ┃ ┃ ┃ ┣ 📜DrawController.java
 ┃ ┃ ┃ ┃ ┣ 📜FullHandController.java
 ┃ ┃ ┃ ┃ ┣ 📜guiController.java
 ┃ ┃ ┃ ┃ ┗ 📜mainGui.java
 ┃ ┗ 📜module-info.java
 ┗ 📂resources
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂gui
 ┃ ┃ ┃ ┗ 📂mainguiwindow
 ┃ ┃ ┃ ┃ ┣ 📜drawPhase.fxml
 ┃ ┃ ┃ ┃ ┣ 📜fullHand.fxml
 ┃ ┃ ┃ ┃ ┣ 📜gui.fxml
 ┃ ┃ ┃ ┃ ┣ 📜style.css
 ┃ ┃ ┃ ┃ ┣ 📜styleDrawPhase.css
 ┃ ┃ ┃ ┃ ┗ 📜styleFullHand.css