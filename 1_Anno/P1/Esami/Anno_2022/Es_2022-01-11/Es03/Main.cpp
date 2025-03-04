#include <iostream>
#include <fstream>

using namespace std;

struct nodo {
    int value;
    nodo* left;
    nodo* right;
};
typedef nodo* albero;

void create_array(char argv[], int array[], int& dim_array);
void strcpy(char* nuova, char* vecchia);

void bubble_sort(int * a, int dim_array);

nodo* recursive_tree_creation(int array[], int max, int min);

void dealloc(nodo* radice);

void stampaAlbero(albero radice, int spazio=0);

int main(int argc, char* argv[]) {
    if(argc != 2){
        cerr<<"Error: ./a.out <input_file>"<<endl;
        return -1;
    }

    int dim_array=0;
    int array[101];
    create_array(argv[1], array, dim_array);
    bubble_sort(array, dim_array);

    nodo* radice=nullptr;
    radice = recursive_tree_creation(array, dim_array-1, 0);

    stampaAlbero(radice, dim_array);
    
    dealloc(radice);
    return 0;
}

void create_array(char argv[], int array[], int& dim_array){
    fstream input;
    input.open(argv, ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        exit(1);
    }
    
    char number[101];
    while(input>>number){
        array[dim_array]=atoi(number);
        dim_array+=1;
    }

    input.close();
}
void strcpy(char* nuova, char* vecchia){
    int i=0;
    for(; vecchia[i-1] != '\0'; i++){
        nuova[i]=vecchia[i];
    }
}

void bubble_sort(int * a, int dim_array){
    int k, temp, i;
    do {
		k=0;
		for(i=0;i<dim_array-1;i++){
			if(a[i]>a[i+1]){
				temp=a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
				k=1;
			}
        }
	} while (k==1);
    

    for(int i=0; i<dim_array; i++){
        cout<<a[i]<<" ";
    }
    cout<<endl;
}

nodo* recursive_tree_creation(int array[], int max, int min){
    int num=(min+max)/2;
    nodo* created=new nodo{array[num], nullptr, nullptr};
    if(min < max){
        if(max-1 != min){
            created->left= recursive_tree_creation(array, num-1, min);
        }
        if(1){
            created->right= recursive_tree_creation(array, max, num+1);
        }
    }
    return created;
}

void dealloc(nodo* radice){
    if(radice != nullptr){
        dealloc(radice->left);
        dealloc(radice->right);
        delete radice;
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