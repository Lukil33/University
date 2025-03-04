#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

int strlen(char* word){
    int i=0;
    for(; word[i] != '\0'; i++){
    }
    return i;
}

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_file> <output_file>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Input error"<<endl;
        return -2;
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Output error"<<endl;
        input.close();
        return -2;
    }

    char word[101];
    int counter=0;
    char last_caracter;
    while(input>>word){
        if((counter == 0||last_caracter == '.'||last_caracter == '?'||last_caracter == '!') && (word[0]>='a' && word[0]<='z')){
            word[0]+='A'-'a';
            last_caracter=word[strlen(word)-1];
        }else{
            last_caracter=word[strlen(word)-1];
        }
        output<<word<<" ";
    }

    input.close();
    output.close();
    return 0;
}