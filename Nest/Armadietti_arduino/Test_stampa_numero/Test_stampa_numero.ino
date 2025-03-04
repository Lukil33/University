/*
  Primo test per verificare che la password possa venir stampata tutta assieme
  Attualmente ho preso il codice da Blink e l'ho modificato

  The circuit:
  * LCD RS pin to digital pin 12
  * LCD Enable pin to digital pin 11
  * LCD D4 pin to digital pin 5
  * LCD D5 pin to digital pin 4
  * LCD D6 pin to digital pin 3
  * LCD D7 pin to digital pin 2
  * LCD R/W pin to ground
  * 10K resistor:
    * ends to +5V and ground
    * wiper to LCD VO pin (pin 3)

  to-do: aggiungere il controllo della password e stampare l'ultima password
*/

// include the library code:
#include <LiquidCrystal.h>
#include <string.h>

// initialize the library by associating any needed LCD interface pin
// with the arduino pin number it is connected to
const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
int max_giorno = 31;
int max_mese = 12;
int max_anno = 2025;

LiquidCrystal lcd(rs, en, d4, d5, d6, d7);
void bruteforce(int, int, int);
bool isNotCorrect(int, int, int);

void setup(){
  //set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  // Inizio il brutforcing partendo dall' 01/01/1981 (anno di fondazione del Faggio)
  bruteforce(1, 1, 1981);
}

void loop(){
  // Turn off the blinking cursor:
  lcd.noBlink();
  delay(3000);
  // Turn on the blinking cursor:
  lcd.blink();
  delay(3000);
}

void bruteforce(int giorno, int mese, int anno){
  bool over_the_limit = true;
  int counter = 0;
  while(over_the_limit && isNotCorrect(giorno, mese, anno)){

    // Aumento della data di 1
    giorno += 1;
    if(giorno > max_giorno){
      giorno -= max_giorno;
      mese += 1;
      if(mese > max_mese){
        mese -= max_mese;
        anno += 1;
        if(anno > max_anno){
          over_the_limit = false;
        }
      }
    }

    // Print per controllare che il programma stia andando
    counter += 1;
    if(!over_the_limit){
      lcd.clear();
      lcd.print("Overflow");
    }else if(counter % 372 == 0){
      lcd.print(".");
    }else if(counter > 3720){
      counter = 0;
      lcd.clear();
    }
    delay(1);
  }
  lcd.print(giorno);
  lcd.print("/");
  lcd.print(mese);
  lcd.print("/");
  lcd.print(anno);
}

bool isNotCorrect(int giorno, int mese, int anno){
  // Attualmente questa funzione controlla semplicemente se la data attuale è quella esatta
  return !(giorno == 1 && mese == 12 && anno == 2004);
}
