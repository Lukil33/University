#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

int main(int argc, char* argv[]){
    if(argc != 4){
        cerr<<"Error: ./a.out <input_file> <input_file> <output_file>"<<endl;
        return -1;
    }
    fstream input, order, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        return -2;
    }
    order.open(argv[2], ios::in);
    if(order.fail()){
        cerr<<"Error during file opening"<<endl;
        input.close();
        return -2;
    }
    output.open(argv[3], ios::out);
    if(output.fail()){
        cerr<<"Error during file opening"<<endl;
        input.close();
        order.close();
        return -2;
    }

    int dim_archivio;
    input>>dim_archivio;
    char archivio[dim_archivio][101];
    char word[101];
    for(int i=0; i<dim_archivio; i++){
        input>>word;
        strcpy(archivio[i], word);
    }

    int position;
    while(order>>position){
        if((position < dim_archivio) && (position >= 0)){
            output<<archivio[position]<<" ";
        }else{
            output<<"MISSING ";
        }
    }

    input.close();
    order.close();
    output.close();
    return 0;
}