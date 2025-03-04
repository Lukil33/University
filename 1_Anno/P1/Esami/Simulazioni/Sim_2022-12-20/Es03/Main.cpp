#include <iostream>
#include <fstream>

using namespace std;

struct nodo {
    char value;
    nodo* left;
    nodo* right;
};
typedef nodo* albero;

void create_array(char argv[], char array[], int& dim_array);
void BubbleSort(char array[], int size);
nodo* place_recursively(char array[], int max, int min);
void dealloc(nodo* root);

void stampaAlbero(albero radice, int spazio=0);

int main(int argc, char* argv[]) {
    if(argc != 2){
        cerr<<"Error: ./a.out <input_file>"<<endl;
        return -1;
    }

    int dim_array=0;
    char array[27];
    create_array(argv[1], array, dim_array);
    BubbleSort(array, dim_array);

    nodo* root = place_recursively( array, dim_array, 0);

    stampaAlbero(root);

    dealloc(root);

    return 0;
}

void create_array(char argv[], char array[], int& dim_array){
    fstream input;
    input.open(argv, ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
       exit(1);
    }
    
    char carattere;
    while(input>>carattere){
        array[dim_array]=carattere;
        dim_array+=1;
    }

    input.close();
}

void BubbleSort(char array[], int size){
    for ( int pass = 0; pass < size - 1 ; ++pass ){
        for ( int j = 0; j < size - 1 - pass; ++j ){
            if (array[j] > array[j+1]){
                char ausiliary=array[j];
                array[j]=array[j+1];
                array[j+1]=ausiliary;
            }
        }
    }
}

nodo*  place_recursively(char array[], int max, int min){
    if(max >= min){
        int num=(max+min)/2;
        nodo* created=new nodo{array[num], nullptr, nullptr};
        created->left=place_recursively(array, num-1, min);
        created->right=place_recursively(array, max, num+1);
        return created;
    }else{
        return nullptr;
    }
}

void dealloc(nodo* root){
    if(root != nullptr){
        dealloc(root->left);
        dealloc(root->right);
        delete root;
    }
}

/** Stampa dell'albero */
void stampaAlbero(albero radice, int spazio){
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