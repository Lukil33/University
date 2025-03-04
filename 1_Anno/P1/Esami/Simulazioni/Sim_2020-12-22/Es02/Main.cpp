#include <iostream>
using namespace std;

// Dichiarare qui sotto la funzione invert
void invert(char sequence[30], int dim);
void supportiv(char sequence[30], int dim, int counter);

int main () {
   char sequence[30];
   int dim;

   cout << "Dimensione: ";
   cin >> dim;
   cout << "Array: ";
   for (int i = 0; i < dim; i++) {
      cin >> sequence[i];      
   }
   
   invert(sequence, dim);

   cout << "Array invertito: ";
   for (int i = 0; i < dim; i++) {
      cout << sequence[i] << " ";      
   }
   cout << endl;
   
   return 0;
}


// Definire qui sotto la funzione invert
void invert(char sequence[30], int dim){
    int counter=0;
    supportiv(sequence, dim, counter);
}

void supportiv(char sequence[30], int dim, int counter){
    if(!(counter*2 >= dim)){
        char carattere=sequence[counter];
        sequence[counter]=sequence[dim-counter-1];
        sequence[dim-counter-1]=carattere;
        supportiv(sequence, dim, counter+1);
    }
}