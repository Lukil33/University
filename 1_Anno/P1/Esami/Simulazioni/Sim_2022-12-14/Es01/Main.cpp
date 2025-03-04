#include <iostream>
#include <fstream>
using namespace std;

bool ultima(char* word);

int main(int argc, char **argv){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_fle> <output_file>"<<endl;
        exit(1);
    }

    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        exit(2);
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Error during file opening"<<endl;
        input.close();
        exit(2);
    }

    //da controllare
    char word[256];
    bool Maiuscolo=true;

    while(input>>word){
        if(Maiuscolo){
            int i=0;
            while((word[i]<'a'||word[i]>'z')&&(word[i]<'A'||word[i]>'Z')){
                i+=1;
            }
            word[i]=word[i]-('a'-'A');
        }
        Maiuscolo=ultima(word);
        output<<word<<" ";
    }
    //fine da controllare

    input.close();
    output.close();
    return 0;
}

bool ultima(char* word){
    int i=0;
    while(word[i] != '\0'){
        i+=1;
    }
    i--;
    if((word[i] == '.')||(word[i] == '?')||(word[i] == '!')){
        return 1;
    }else{
        return 0;
    }
}