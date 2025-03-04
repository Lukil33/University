#include <iostream>
#include "pila.h"


using namespace std;


/**
 * Ricordare che il file "pila.h" contiene la definizione della struct "cella" (qui sotto riportata)
 * 
 * struct cella {
 *   int indiceRiga;
 *   int indiceColonna;
 * };
 */
void risolviLabirinto(int [][5], int, int);
void ausiliary(int [][5], int, int, int, int, bool&);

int main(int argc, char* argv[]) {

    // Se modificate la funzione "main", ricordarsi poi di ripristinare il codice originale  

    // E' possibile modificare la matrice per effettuare dei test   
    int labirinto[5][5] = {
        { 1, 0, 1, 1, 0 },
        { 1, 1, 1, 0, 1 },
        { 0, 1, 0, 1, 1 },
        { 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1 }
    };

    // E' possibile modificare la cella di arrivo per effettuare dei test (la cella di partenza invece è sempre [0,0])   
    cout<<"Percorso: ";
    risolviLabirinto(labirinto, 4, 4);
   
    return 0;
}

void risolviLabirinto(int matrix[][5], int end_column, int end_row){
    bool arrivato=false;
    init();
    int column=0;
    int row=0;
    ausiliary(matrix, column, row, end_column, end_row, arrivato);
    while((matrix[0][0] != 0) && (!arrivato)){
        
    }
    if(arrivato){
        while(!vuota()){
            cella pointer;
            top(pointer);
            cout<<"["<<pointer.indiceColonna<<", "<<pointer.indiceRiga<<"] ";
            pop();
        }
    }
    cout<<endl;
    deinit();
}

void ausiliary(int matrix[][5], int column, int row, int end_column, int end_row, bool& arrivato){
    if((column==end_column)&&(row==end_row)){
        arrivato=true;
    }else{
        matrix[column][row]=2;
        if((matrix[column+1][row] == 1) && (column+1<5)){
            cella pointer;
            pointer.indiceColonna=column+1;
            pointer.indiceRiga=row;
            push(pointer);
            ausiliary(matrix, column+1, row, end_column, end_row, arrivato);
            if(arrivato){
                return;
            }
            pop();
        }
        if((matrix[column-1][row] == 1) && (column-1>=0)){
            cella pointer;
            pointer.indiceColonna=column-1;
            pointer.indiceRiga=row;
            push(pointer);
            ausiliary(matrix, column-1, row, end_column, end_row, arrivato);
            if(arrivato){
                return;
            }
            pop();
        }
        if((matrix[column][row+1] == 1) && (row+1<5)){
            cella pointer;
            pointer.indiceColonna=column;
            pointer.indiceRiga=row+1;
            push(pointer);
            ausiliary(matrix, column, row+1, end_column, end_row, arrivato);
            if(arrivato){
                return;
            }
            pop();
        }
        if((matrix[column][row-1] == 1) && (row-1>=0)){
            cella pointer;
            pointer.indiceColonna=column;
            pointer.indiceRiga=row-1;
            push(pointer);
            ausiliary(matrix, column, row-1, end_column, end_row, arrivato);
            if(arrivato){
                return;
            }
            pop();
        }
        matrix[column][row]=0;
    }
}