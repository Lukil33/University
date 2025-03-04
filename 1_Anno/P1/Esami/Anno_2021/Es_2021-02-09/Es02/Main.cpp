#include <iostream>
#include <cstddef>

using namespace std;

// Inserire qui la dichiarazione di get_elements
void get_elements(const char s[], int s_s, char*& d1, int& d1_s, char*& d2, int& d2_s);
void ausiliary(const char s[], int s_s, int contatore, char*& d1, int& d1_s, char*& d2, int& d2_s, char*& ris1, char*& ris2);
void strcpy(char* old, char* nev, int num);

void print(const char a[], const int s, const char * prefix) {
  cout << prefix;
  for (int i = 0; i < s; i++) {
    cout << a[i] << " ";
  }
  cout << endl;
}

void read_elements(char s[], const int ms, int & s_s) {
  char r = '\0';
  for (s_s = 0; ((s_s < ms) && (r != '\n')); ) {
    r = cin.get();
    if ((r != '\n') && (r != ' ')) s[s_s++] = r;
  }
}

int main() {
  const int maxdim = 10;

  char * d1;
  int d1_s = 0;

  char * d2;
  int d2_s = 0;

  const int ms = maxdim;
  char s[ms];
  int s_s = 0;

  read_elements(s, ms, s_s);
  print(s, s_s, "Source = ");

  get_elements(s, s_s, d1, d1_s, d2, d2_s);

  print(d1, d1_s, "D1     = ");
  print(d2, d2_s, "D2     = ");
    
  delete [] d1;
  delete [] d2;
}

// Inserire qui la definizione di get_elements e di eventuali altre
// funzioni ausiliarie
void get_elements(const char s[], int s_s, char*& d1, int& d1_s, char*& d2, int& d2_s){
    char* temp1=new char[0];
    char* temp2=new char[0];
    ausiliary(s, s_s, 0, temp1, d1_s, temp2, d2_s, d1, d2);
}

void ausiliary(const char s[], int s_s, int contatore, char*& d1, int& d1_s, char*& d2, int& d2_s, char*& ris1, char*& ris2){
    if(contatore==s_s){//caso base
        ris1=d1;
        ris2=d2;
    }else {
        if(s[contatore]>='a'&&s[contatore]<='z'){//caso lettera minuscola
            char letter=s[contatore]+'A'-'a';
            letter='Z'-(letter-'A');
            char* Nd1=new char[d1_s+1];
            strcpy(d1, Nd1, d1_s);
            Nd1[d1_s]=letter;

            delete[] d1;
            d1_s++;
            ausiliary(s, s_s, contatore+1, Nd1, d1_s, d2, d2_s, ris1, ris2);
        }else if(s[contatore]>='0'&&s[contatore]<='9'){//caso numero
            char number='9'-(s[contatore]-'0');
            char* Nd2=new char[d2_s+1];
            strcpy(d2, Nd2, d2_s-1);
            Nd2[d2_s]=number;

            delete[] d2;
            d2_s++;
            ausiliary(s, s_s, contatore+1, d1, d1_s, Nd2, d2_s, ris1, ris2);
        }else{//tutti gli altri casi
            ausiliary(s, s_s, contatore+1, d1, d1_s, d2, d2_s, ris1, ris2);
        }
    }
}

void strcpy(char* old, char* nev, int num){//reimplementazione strcpy (copia gli elementi prima del \0)
    if(num>=0){
        nev[num]=old[num];
        strcpy(old, nev, num-1);
    }
}