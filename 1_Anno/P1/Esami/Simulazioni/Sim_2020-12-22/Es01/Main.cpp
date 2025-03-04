#include <iostream>
#include <iomanip>
using namespace std;

// Inserire qui sotto la dichiarazione delle funzioni
float seno_iperbolico(double x, int nmax, double epsilon);
float sin(double x, int nmax, double epsilon, int i, float sinh);
int fattoriale(int num);
double pow(double x, int esponente);
float mod(float num);

int main () {
  double epsilon, x;
  int nmax;

  cout << "Inserisci il massimo numero di termini dell'approssimazione nmax: ";
  cin >> nmax;
  cout << "Inserisci l'errore massimo epsilon: ";
  cin >> epsilon;

  char c;
  do {
    cout << "Inserisci il valore x in cui vuoi calcolare sinh(x): ";
    cin >> x;
    cout << "L'approssimazione di sinh(x) e': " << setprecision(10) 
         << seno_iperbolico(x, nmax, epsilon) << endl;
    cout << "Continuare (s/n)? ";
    cin >> c;
  } while(c != 'n' && c != 'N');

  return(0);
}

// Inserire qui sotto la definizione delle funzioni
float seno_iperbolico(double x, int nmax, double epsilon){
    float sinh=x;
    int i=0;
    return (sinh + sin(x, nmax, epsilon, i+1, sinh));
}

float sin(double x, int nmax, double epsilon, int i, float sinh){
    float n_sinh=(pow(x, (2*i)+1))/fattoriale((2*i)+1);
    if(i == nmax){
        return n_sinh;
    }
    if(mod(n_sinh-sinh)<(epsilon*mod(sinh))){
        return n_sinh;
    }
    return (n_sinh + sin(x, nmax, epsilon, i+1, n_sinh));
}

float mod(float num){
    if(num<0){
        num*=-1;
    }
    return num;
}

double pow(double x, int esponente){
    int risultato=1;
    while(esponente>0){
        risultato*=x;
        esponente--;
    }
    return risultato;
}

int fattoriale(int num){
    int risp=1;
    while(num > 0){
        risp*=num;
        num--;
    }
    return risp;
}