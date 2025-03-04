#include <iostream>
#include "coda.h"
using namespace std;

struct node{
    int num;
    node* left;
    node* right;
};

static node* lista_inizio;
static node* lista_fine;
static int len_f1;

int len_lista(){
    int i=0;
    node* pointer=lista_inizio;
    while(pointer != nullptr){
        pointer=pointer->right;
        i++;
    }
    return i;
}

void init(){
    lista_inizio=nullptr;
    lista_fine=nullptr;
    len_f1=0;
}

// inserimento di un elemento nella sotto-coda con meno elementi
bool enqueue(int number){
    if(len_lista()>=11){
        return 0;
    }else{
        node* created=new node{number, nullptr, nullptr};
        if((lista_inizio == nullptr) || (len_f1==0)){
            if((len_f1==0) && (len_lista() != 0)){
                created->right=lista_inizio;
                lista_inizio->left=created;
            }
            lista_inizio=created;
            len_f1+=1;
        }else if(lista_fine == nullptr || (len_f1==len_lista())){
            if(len_f1 == 1){
                lista_inizio->right=created;
                created->left=lista_inizio;
            }else{
                lista_fine->right=created;
                created->left=lista_fine;
            }
            lista_fine=created;
            
        }else{
            node* pointer=lista_inizio;
            for(int i=1; i<len_f1; i++){
                pointer=pointer->right;
            }
            created->right=pointer->right;
            created->left=pointer->right->left;
            pointer->right=created;
            created->right->left=created;
            if(len_lista()-1-len_f1>=len_f1){
                len_f1+=1;
            }
        }
        return 1;
    }
}

// assegna al parametro (passato per riferimento) il valore del primo elemento della sotto-coda del primo sportello
bool firstS1(int& result){
    if((lista_inizio != nullptr) && (len_f1 > 0)){
        result=lista_inizio->num;
        return 1;
    }else{
        return 0;
    }
}

// assegna al parametro (passato per riferimento) il valore del primo elemento della sotto-coda del secondo sportello
bool firstS2(int& result){
    if((lista_fine != nullptr) && (len_f1 != len_lista())){
        result=lista_fine->num;
        return 1;
    }else{
        return 0;
    }
}

// rimuove il primo elemento della sotto-coda del primo sportello
bool dequeueS1(){
    if(len_f1 > 0){
        node* pointer=lista_inizio;
        len_f1-=1;
        lista_inizio=lista_inizio->right;
        lista_inizio->left=nullptr;
        delete pointer;
        return 1;
    }else{
        return 0;
    }
}

// rimuove il primo elemento della sotto-coda del secondo sportello
bool dequeueS2(){
    if(len_f1 < len_lista()){
        node* pointer=lista_fine;
        lista_fine=lista_fine->left;
        lista_fine->right=nullptr;
        delete pointer;
        return 1;
    }else{
        return 0;
    }
}

// de-inizializza la coda e dealloca eventuale memoria dinamica, se necessario
void deinit(){
    while(lista_inizio != nullptr){
        node* pointer=lista_inizio;
        lista_inizio=lista_inizio->right;
        delete[] pointer;
    }
}

// stampa a video tutti gli elementi delle due sotto-code
void print(){
    cout<<"S1: ";
    node* pointer=lista_inizio;
    for(int i=0; i<len_f1; i++){
        cout<<pointer->num<<" ";
        pointer=pointer->right;
    }
    cout<<endl;
    cout<<"S2: ";
    pointer=lista_fine;
    for(int i=len_f1; i<len_lista(); i++){
        cout<<pointer->num<<" ";
        pointer=pointer->left;
    }
    cout<<endl;
}