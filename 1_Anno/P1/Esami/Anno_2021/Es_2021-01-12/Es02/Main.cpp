#include <iostream>
#include <cstddef>

using namespace std;

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

void get_elements(char s[], int s_s, char* d1, const int md1_s, int& d1_s, char* d2, const int md2_s, int& d2_s);
void ausiliary(char s[], int s_s, int counter, char* d1, int& d1_s, const int md1_s, char* d2, int& d2_s, const int md2_s);

int main() {
  const int maxdim = 10;

  const int md1_s = maxdim;
  char d1[md1_s];
  int d1_s = 0;

  const int md2_s = maxdim;
  char d2[md2_s];
  int d2_s = 0;

  const int ms = maxdim;
  char s[ms];
  int s_s = 0;

  read_elements(s, ms, s_s);

  get_elements(s, s_s, d1, md1_s, d1_s, d2, md2_s, d2_s);


  print(s, s_s, "Source = ");
  print(d1, d1_s, "D1     = ");
  print(d2, d2_s, "D2     = ");

}

void get_elements(char s[], int s_s, char* d1, const int md1_s, int& d1_s, char* d2, const int md2_s, int& d2_s){
    ausiliary(s, s_s, 0, d1, d1_s, md1_s, d2, d2_s, md2_s);
}

void ausiliary(char s[], int s_s, int counter, char* d1, int& d1_s, const int md1_s, char* d2, int& d2_s, const int md2_s){
    if(s[counter] != '\0'){
        if(((s[counter]>='a')&&(s[counter]<='z'))&&(d1_s+1<md1_s)){
            d1[d1_s]=s[counter]+'A'-'a';
            d1_s+=1;
        }
        if(((s[counter]>='0')&&(s[counter]<='9'))&&(d2_s+1<md2_s)){
            d2[d2_s]='9'-(s[counter]-'0');
            d2_s+=1;
        }
        ausiliary(s, s_s, counter+1, d1, d1_s, md1_s, d2, d2_s, md2_s);
    }else{
        d1[d1_s+1]='\n';
        
        d2[d2_s+1]='\n';
    }
}