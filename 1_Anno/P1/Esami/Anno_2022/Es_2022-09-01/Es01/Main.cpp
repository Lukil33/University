#include <iostream>
#include <fstream>
using namespace std;

int strlen(char line[]);
void strcpy(char longer_line[], char line[]);

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_file> <output_file>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error duting file openng"<<endl;
        return -2;
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Error duting file openng"<<endl;
        input.close();
        return -2;
    }

    char line[256];
    int dim_longer_line=0;
    char longer_line[156];

    while(input.getline(line, 256)){
        if(strlen(line) >= dim_longer_line){
            dim_longer_line=strlen(line);
            strcpy(longer_line, line);
        }
        output<<strlen(line)<<endl;
    }

    output<<longer_line<<": "<<dim_longer_line<<endl;

    input.close();
    output.close();
    return 0;
}

int strlen(char line[]){
    int i=0;
    for(; line[i] != '\0'; i++){
    }
    return i;
}

void strcpy(char longer_line[], char line[]){
    int i=0;
    for(; line[i] != '\0'; i++){
        longer_line[i]=line[i];
    }
    longer_line[i+1]='\0';
}