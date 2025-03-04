#include<iostream>
#include<cstdlib>
#include<fstream>
using namespace std;

// La funzione non va modificata, pena l'annullamento dell'esercizio
void sort_array(int * array, int len_array) {
  for (int i=0; i<len_array; i++) {
    for (int j=i+1; j<len_array; j++) {
      if (array[i] > array[j]) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
      }
    }
  }
}

int main(int argc, char * argv []) {
    if(argc != 4){
        cerr<<"Error: ./a.out <input_file> <DIM> <N>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    output.open("output.txt", ios::out);
    if(input.fail()){
        cerr<<"Error in file opening"<<endl;
        return -2;
    }
    if(output.fail()){
        cerr<<"Error in file opening"<<endl;
        input.close();
        return -2;
    }

    int DIM=atoi(argv[2]);
    int top=atoi(argv[3]);
    int voti[DIM];
    int num;
    for(int i=0; i<DIM; i++){
        input>>num;
        voti[i]=num;
    }
    sort_array(voti, DIM);

    for(int i=DIM-1, g=0; g<top; g++, i--){
        output<<voti[i]<<endl;
    }

    input.close();
    output.close();
    return 0;
}
