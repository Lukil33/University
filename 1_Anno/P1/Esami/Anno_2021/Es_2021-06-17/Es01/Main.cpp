#include <iostream>
#include <fstream>
using namespace std;

bool valid(char* word);
int strlen(char* word);

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_file> <output_file>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Imput error"<<endl;
        return -2;
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Output error"<<endl;
        input.close();
        return -2;
    }

    char word[101];
    while(input>>word){
        if(valid(word)){
            output<<word<<endl;
        }
    }

    input.close();
    output.close();
    return 0;
}

bool valid(char* word){
    int len=strlen(word);
    bool correct=true;

    if(word[0] == 'M'){
        if(word[len-1] != 'U'){
            correct=false;
        }
    }
    int counter=0;
    for(int i=0; word[i] != '\0'; i++){
        if(word[i]=='I'){
            counter++;
            if(word[i+1] == 'M'){
                correct=false;
            }
        }
    }
    if(counter != 0 && counter%2 == 0){
        correct=false;
    }
    return correct;
}

int strlen(char* word){
    int i=0;
    for(; word[i] != '\0'; i++){
    }
    return i;
}