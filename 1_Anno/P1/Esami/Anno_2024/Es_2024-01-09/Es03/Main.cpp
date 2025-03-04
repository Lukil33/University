#include <iostream>
#include "lista.h"

using namespace std;

const int POS_AL_SECONDO = 2;
const int DIM_COLORI = 4;
const int MAX_BAMBINI = 10;

const char* nomi[18] = {"Marco", "Luca", "Anna", "Sabrina", "Veronica", "Simone", "Mario", "Luigi", "Antonio", "Francesca", "Giovanni", "Letizia", "Lucrezia", "Carolina", "Luca", "Annalisa", "Susanna", "Licia"};
const color colori[DIM_COLORI] = {rosso, verde, blu, giallo};

// Inserire QUI sotto la dichirazione delle funzioni coloraPartecipante e cerca.
nodo* cerca(nodo* L, char v[]);
nodo* coloraPartecipante(nodo* L, int durata, int sedia_rimossa);
// Inserire QUI sopra la dichirazione delle funzioni coloraPartecipante e cerca.

int main() {
    lista cerchio = NULL;
    
    unsigned int seed = time(NULL);
    // Commentare la riga sotto per non avere sempre lo stesso seed
    seed = 1703945587;
    std::cout << "Seed: " << seed << std::endl;
    srand(seed);
  

    int numero_bambini = rand() % MAX_BAMBINI + 2;
    for (int i = 0; i < numero_bambini; i++) {
        char* nome = (char*)nomi[rand() % 18];
        if (cerca(cerchio, nome) == NULL) {
            insert_in(cerchio, nome, 0);
        } else {
            i--;
        }
    }

    cout << "Ci sono " << size(cerchio) << " bambini nella lista." << endl;
    print(cerchio);

    int i = 0;
    int durata;
    bool finished = false;

    while (!empty(cerchio) && !finished) {
        cout << "-------------------------------------------------------------" << endl;
        cout << "Giro numero " << ++i << endl;
        
        cout << "La canzone durerà per " << (durata = rand() % 60 + 10) << " secondi." << endl;

        int sedia_rimossa = rand() % size(cerchio);
        cout << "Fermo il bambino alla sedia numero " << sedia_rimossa << "." << endl;

        lista eliminato = coloraPartecipante(cerchio, durata, sedia_rimossa);

        if (eliminato != NULL) {
            cout << eliminato->nome << " ha ricevuto il colore " << eliminato->colore << endl;
        } else {
            cout << "Tutti i bambini hanno un colore. Ho finito." << endl;
            finished = true;
        }
        print(cerchio);
    }

    cout << "-------------------------------------------------------------" << endl;
    cout << "Tutti i bambini hanno un colore. Ho finito." << endl;

    return 0;
}

// Inserire QUI la definizione delle funzioni coloraPartecipante e cerca.
nodo* cerca(nodo* L, char v[]){
    if(L != nullptr){
        nodo* starting_point=L;
        bool found=false;
        while((!found) && (L->next != starting_point)){
            if(strcmp(L->nome, v) == 0){
                found=1;
            }else{
                L=L->next;
            }
        }
        if(found){
            return L;
        }else{
            return NULL;
        }
    }else{
        return NULL;
    }
    
}

nodo* coloraPartecipante(nodo* L, int durata, int sedia_rimossa){
    if(L != nullptr){
        for(int j=0; j<durata; j++){
            for(int i=0; i<POS_AL_SECONDO; i++){
                L=L->next;
            }
        }

        nodo* starting_point=L;
        bool found=false;
        while((!found) && (L->next != starting_point)){
            if(L->colore == -1){
                found=1;
            }else{
                L=L->next;
            }
        }
        if(found){
            if(L->next != L){
                nodo* precedente=L;
                while(precedente->next != L){
                    precedente=precedente->next;
                }

                int i=0;
                L->colore=color(i);
                while(L->next->colore == L->colore || precedente->colore == L->colore){
                    i+=1;
                    L->colore=color(i);
                }
            }else{
                L->colore=color(0);
            }
        }else{
            cout<<"Tutti i bambini hanno un colore. Ho finito."<<endl;
            L=NULL;
        }
    }
    return L;
}