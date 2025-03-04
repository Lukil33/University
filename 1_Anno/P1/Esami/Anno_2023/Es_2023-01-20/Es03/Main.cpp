#include <iostream>
#include "pila.h"

using namespace std;

int * collidiAsteroidi(int asteroidi[], int numeroAsteroidi, int & numeroAsteroidiRimasti);

int main() {
    
    // Potete modificare l'array di asteroidi (e la sua
    // dimensione) per testare la vostra soluzione
    int asteroidi [] = {-6, 10, 5, 8, -9};
    int numeroAsteroidi = 5;


    int numeroAsteroidiRimasti;
    int * asteroidiRimasti = collidiAsteroidi(asteroidi, numeroAsteroidi, numeroAsteroidiRimasti);


    // La stampa dell'array dinamico degli
    // asteroidi rimasti avviene nel main
    for (int i = 0; i < numeroAsteroidiRimasti ; i++) {
        cout << asteroidiRimasti[i] << " ";
    }
    cout << endl;

    // La deallocazione dell'array dinamico 
    // degli asteroidi rimasti avviene nel main
    delete[] asteroidiRimasti;
}


// Implementare la funzione sottostante come da consegna:
// - ritornare un'array di interi allocato dinamicamente che 
//   contenga lo stato degli asteroidi dopo tutte le collisioni
// - assegnare a 'numeroAsteroidiRimasti' il numero di elementi 
//   nell'array ritornato
int * collidiAsteroidi(int asteroidi[], int numeroAsteroidi, int & numeroAsteroidiRimasti) {
    init();
    numeroAsteroidiRimasti=0;
    for(int i=0; i<numeroAsteroidi; i++){
        bool not_inserted=true;
        while(not_inserted){
            int primo_elemento;
            if(top(primo_elemento)){
                if((primo_elemento<0 && asteroidi[i]<0) || (primo_elemento>0 && asteroidi[i]>0) || (primo_elemento<0 && asteroidi[i]>0)){
                    not_inserted=false;
                    push(asteroidi[i]);
                    numeroAsteroidiRimasti+=1;
                }else{
                    if(primo_elemento<(asteroidi[i]*(-1))){
                        pop();
                        numeroAsteroidiRimasti-=1;
                    }else if(primo_elemento==(asteroidi[i]*(-1))){
                        pop();
                        numeroAsteroidiRimasti-=1;
                        not_inserted=false;
                    }else{
                        not_inserted=false;
                    }
                }
            }else{
                not_inserted=false;
                push(asteroidi[i]);
                numeroAsteroidiRimasti+=1;
            }
        }
    }

    int* res=new int[numeroAsteroidiRimasti];

    for(int i=numeroAsteroidiRimasti-1; i>=0; i--){
        int numero;
        top(numero);
        res[i]=numero;
        pop();
    }

    deinit();
    return res;
}
