#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

bool is_valid(char word[]);
bool is_present(char archivio[][101], char parola[], int* occorrenze, int counter);

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_file> <output_file>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        return -2;
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Error during file opening"<<endl;
        input.close();
        return -2;
    }

    char archivio[101][101];
    int occorrenze[101];
    char parola[101];
    int counter=0;
    while(input>>parola){
        if(is_valid(parola)){
            if(is_present(archivio, parola, occorrenze, counter)){
            }else{
                strcpy(archivio[counter], parola);
                occorrenze[counter]=1;
                counter++;
            }
        }
    }

    for(int i=0; i<counter; i++){
        output<<archivio[i]<<": "<<occorrenze[i]<<endl;
    }

    input.close();
    output.close();
    return 0;
}

bool is_valid(char word[]){
    bool valid=true;
    for(int i=0; word[i] != '\0'; i++){
        if(!((word[i]>='a')&&(word[i]<='z'))){
            valid=0;
        }
    }
    return valid;
}

bool is_present(char archivio[][101], char parola[], int* occorrenze, int counter){
    bool presence=false;
    int i=0;
    while((i<counter)&&(!presence)){
        if(strcmp(archivio[i], parola) == 0){
            occorrenze[i]+=1;
            presence=true;
        }
        i++;
    }
    return presence;
}
