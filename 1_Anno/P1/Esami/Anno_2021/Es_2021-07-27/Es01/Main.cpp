#include <iostream>
#include <fstream>
using namespace std;
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
    while(input>>word){
        bool valid=true;
        for(int i=0; (word[i] != '\0'); i++){
            if(i>=19){
                valid=false;
            }
            if(word[i]<'0'||word[i]>'9'){
                if((word[i] == '-')&&((i+1)%5==0)){
                }else{
                    valid=false;
                }
            }
        }
        if(valid){
            counter++;
        }
    }
    output<<counter;

    input.close();
    output.close();
    return 0;
}