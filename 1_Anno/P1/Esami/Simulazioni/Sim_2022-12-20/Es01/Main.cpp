#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

bool is_sniffer(char word[]);

int main(int argc, char **argv){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_fle> <output_file>"<<endl;
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

    char word[101];
    int num_sniffer=0;
    while(input>>word){
        if(is_sniffer(word)){
            num_sniffer+=1;
        }
    }
    output<<num_sniffer;

    input.close();
    output.close();
    return 0;
}

bool is_sniffer(char word[]){
    int valid=true;
    int i=0;
    for(; word[i] != '\0'; i++){
        if((i+1)%5 == 0){
            if(word[i] != '-'){
                valid=false;
            }
        }else if((word[i]<'0') || (word[i]>'9')){
            valid=false;
        }
    }
    if(i != 19){
        valid=false;
    }
    return valid;
}