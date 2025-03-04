#include <iostream>
#include <cstdlib>
#include "coda.h"

using namespace std;

int trovaIlVincitore(int n, int k);

int main(int argc, char * argv[]) {

    if (argc != 3) {
        cerr << "Usage: a./out <numeroDiAmici> <numeroDiSalti>" << endl;
        exit(0);
    }

    cout << "Il vincitore e' l'amico numero " << trovaIlVincitore(atoi(argv[1]), atoi(argv[2])) << endl;
}


// Implementare la funzione sottostante come da consegna:
// - 'numeroDiAmici' è il numero di amici, o anche chiamato 'n'
// - 'numeroDiSalti' è il numero di salti, o anche chiamato 'k' 
int trovaIlVincitore(int numeroDiAmici, int numeroDiSalti) {
    init();

    for(int i=1; i<=numeroDiAmici; i++){
        enqueue(i);
    }

    while(numeroDiAmici>1){
        for(int i=0; i<numeroDiSalti; i++){
            int scambia;
            first(scambia);
            enqueue(scambia);
            dequeue();
        }
        dequeue();
        numeroDiAmici-=1;
    }

    int vincitore;
    first(vincitore);
    deinit();
    return vincitore;
}