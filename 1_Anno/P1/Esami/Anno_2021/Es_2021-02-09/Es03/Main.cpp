#include <iostream>
#include <cstdlib>

struct nodo {
    int valore;
    nodo* nodoPrecedente;
    nodo* nodoSuccessivo;
};
typedef nodo* lista;

using namespace std;


void inizializza (int arrayDiInteri [], int dimensioneArray);
void stampaLista (lista nodoCorrente);
lista creaLista(int arrayDiInteri[], int dimensioneArray);
nodo* creaNodo (int cartaDaInserire);

lista rimuoviNodiAlternati (nodo* nodoIniziale);
void deallocaLista(lista nodoIniziale);

int main() { 

    int dimensioneArray = 8;
    int arrayDiInteri[dimensioneArray];
    inizializza(arrayDiInteri, dimensioneArray);

    lista nodoIniziale = creaLista(arrayDiInteri, dimensioneArray);

    cout << "Lista iniziale: ";
    stampaLista(nodoIniziale);

    nodoIniziale = rimuoviNodiAlternati(nodoIniziale);

    cout << "Risultato: ";
    stampaLista(nodoIniziale);
    deallocaLista(nodoIniziale);

    return 0;
}


void inizializza (int arrayDiInteri [], int dimensioneArray) {
    
    srand(time(NULL));

    for (int i = 0 ; i < dimensioneArray ; i++) {
        arrayDiInteri[i] = i % 3;
    }

    int contatore = dimensioneArray;
    while (contatore > 1) {
       int indice = rand() % contatore;
       contatore--;
       int temp = arrayDiInteri[contatore];
       arrayDiInteri[contatore] = arrayDiInteri[indice];
       arrayDiInteri[indice] = temp;
    }
}

nodo* creaNodo (int nodoDaInserire) {
    nodo* nodoAttuale = new nodo;
    nodoAttuale->valore = nodoDaInserire;
    nodoAttuale->nodoPrecedente = NULL;
    nodoAttuale->nodoSuccessivo = NULL;
    return nodoAttuale;
}

lista creaLista(int arrayDiInteri[], int dimensioneArray){
    lista List=nullptr;
    for(int i=0; i<dimensioneArray; i++){
        nodo* created=new nodo{arrayDiInteri[i], nullptr, nullptr};
        if(List == nullptr){
            List=created;
        }else{
            nodo* pointer=List;
            while(pointer->nodoSuccessivo != nullptr){
                pointer=pointer->nodoSuccessivo;
            }
            pointer->nodoSuccessivo=created;
            created->nodoPrecedente=pointer;
        }
    }
    return List;
}

void stampaLista(lista nodoCorrente) {
    while (nodoCorrente != NULL) {
        cout << nodoCorrente->valore << " ";
        nodoCorrente = nodoCorrente->nodoSuccessivo;
    }
    cout << endl;
}

void deallocaLista(lista nodoCorrente) {
    while (nodoCorrente != NULL) {
        nodo* temp = nodoCorrente;
        nodoCorrente = nodoCorrente->nodoSuccessivo;
        delete temp;
    }
}



lista rimuoviNodiAlternati(nodo* nodoCorrente) {
    int modifiche=1;
    lista nodoIniziale=nodoCorrente;
    while(modifiche != 0){
        modifiche=0;
        while((nodoCorrente->nodoSuccessivo != nullptr) && (nodoCorrente->nodoSuccessivo->nodoSuccessivo != nullptr)){
            if(nodoCorrente->valore == nodoCorrente->nodoSuccessivo->nodoSuccessivo->valore){
                //eliminazione primo nodo
                nodo* pointer=nodoCorrente;
                nodoCorrente=nodoCorrente->nodoSuccessivo;
                if(pointer == nodoIniziale){
                    nodoIniziale=pointer->nodoSuccessivo;
                    nodoIniziale->nodoPrecedente=nullptr;
                }else{
                    pointer->nodoPrecedente->nodoSuccessivo=pointer->nodoSuccessivo;
                    pointer->nodoSuccessivo->nodoPrecedente=pointer->nodoPrecedente;
                }
                delete pointer;
                //eliminazione secondo nodo
                nodo* puntatore=nodoCorrente->nodoSuccessivo;
                if(puntatore->nodoSuccessivo == nullptr){
                    nodoCorrente->nodoSuccessivo=nullptr;
                }else{
                    puntatore->nodoPrecedente->nodoSuccessivo=puntatore->nodoSuccessivo;
                    puntatore->nodoSuccessivo->nodoPrecedente=puntatore->nodoPrecedente;
                }
                delete puntatore;
                modifiche++;
            }else{
                nodoCorrente=nodoCorrente->nodoSuccessivo;
            }
        }
        nodoCorrente=nodoIniziale;
    }
    return nodoIniziale;
}
