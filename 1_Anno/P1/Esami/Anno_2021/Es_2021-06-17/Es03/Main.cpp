#include <iostream>
#include <cstdlib>

using namespace std;

struct nodo {
    int value;
    nodo* left;
    nodo* right;
};
typedef nodo* albero;


albero generaAlbero(int numeroDiNodi = 10);
void stampaAlbero(albero radice, int spazio=0);

albero creaAlberoDiRicercaBinario(albero alberoIniziale);
void ausiliary(albero alberoIniziale, albero& bst);
void StampaAlberoInOrdine(albero bst);
void deallocaAlbero(albero tree);
void killer(albero tree);

int main(int argc, char* argv[]) {

    // Se modificate la funzione "main", ricordarsi poi di ripristinare il codice originale


    albero alberoIniziale = generaAlbero();
    //stampaAlbero(alberoIniziale); // nel caso in cui possa essere utile, la funzione "stampaAlbero" stampa graficamente l'albero a video

    albero alberoBinario = creaAlberoDiRicercaBinario(alberoIniziale);
    cout << "L'albero di ricerca binario è: ";
    StampaAlberoInOrdine(alberoBinario);
    cout << endl;

    deallocaAlbero(alberoIniziale);
    deallocaAlbero(alberoBinario);

    return 0;
}


albero generaAlbero(int numeroDiNodi) {
    
    // Se modificate la funzione "generaAlbero", ricordarsi poi di ripristinare il codice originale

    srand(time(NULL));
    nodo* nodi[numeroDiNodi];

    cout << "L'albero iniziale è:";

    for (int i = 0; i<numeroDiNodi; i++) {
        nodi[i] = new nodo;
        nodi[i]->value = rand() % 10;
        nodi[i]->left = NULL;
        nodi[i]->right = NULL;
        cout << " " << nodi[i]->value;
    }
    cout << endl;

    for (int i = 0; (2*i + 1)<numeroDiNodi; i++) {
        nodi[i]->left = nodi[2*i + 1];
        if ((2*i + 2) < numeroDiNodi) {
            nodi[i]->right = nodi[(2*i + 2)];
        }
    }

    return nodi[0];
}

void stampaAlbero(albero radice, int spazio) {

    // Se modificate la funzione "stampaAlbero", ricordarsi poi di ripristinare il codice originale

    if (radice != NULL) {
        spazio ++;

        stampaAlbero(radice->right, spazio);

        for (int i = 1; i < spazio; i++) {
            cout<<"\t";
        }
        cout<<radice->value<<"\n";

        stampaAlbero(radice->left, spazio);
    }
}


/* 
 * Inserire qui la definizione di "creaAlberoDiRicercaBinario", "StampaAlberoInOrdine", 
 * "deallocaAlbero" e di eventuali altre funzioni ausiliarie.
 */

albero creaAlberoDiRicercaBinario(albero alberoIniziale){
    albero bts=nullptr;
    ausiliary(alberoIniziale, bts);
    return bts;
}
void ausiliary(albero alberoIniziale, albero& bst){
    if(alberoIniziale!=nullptr){
        if(alberoIniziale->value%2==1){
            nodo* created=new nodo{alberoIniziale->value, nullptr, nullptr};
            if(bst==nullptr){
                bst=created;
            }else{
                nodo* pointer=bst;
                while(((pointer->value >= created->value)&&(pointer->left != nullptr))||
                      ((pointer->value < created->value)&&(pointer->right != nullptr))){
                    if(pointer->value >= created->value){
                        pointer=pointer->left;
                    }else{
                        pointer=pointer->right;
                    }
                }
                if(pointer->value >= created->value){
                    pointer->left=created;
                }else{
                    pointer->right=created;
                }
            }
        }
        ausiliary(alberoIniziale->left, bst);
        ausiliary(alberoIniziale->right, bst);
    }
}

void StampaAlberoInOrdine(albero bst){
    if(bst != nullptr){
        StampaAlberoInOrdine(bst->left);
        cout<<bst->value<<" ";
        StampaAlberoInOrdine(bst->right);
    }
}

void deallocaAlbero(albero tree){
    killer(tree);
    nodo* pointer=tree;
    tree=nullptr;
    delete pointer;
}

void killer(albero tree){
    if((tree->left != nullptr) || (tree->right != nullptr)){
        if(tree->left != nullptr){
            killer(tree->left);
            if((tree->left->left == nullptr) && (tree->left->right == nullptr)){
                nodo* pointer=tree->left;
                tree->left=nullptr;
                delete pointer;
            }
        }
        if(tree->right != nullptr){
            killer(tree->right);
            if((tree->right->left == nullptr) && (tree->right->right == nullptr)){
                nodo* pointer=tree->right;
                tree->right=nullptr;
                delete pointer;
            }
        }
    }
}