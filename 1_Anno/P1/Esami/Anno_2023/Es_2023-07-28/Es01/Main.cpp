#include <iostream>
#include <fstream>
#include<cstring>
using namespace std;

int main(int argc, char* argv[]){
    if(argc != 2){
        cerr<<"Error: ./a.out <input_fle>"<<endl;
        return -1;
    }

    fstream input;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        return -2;
    }

    char find[256];
    cout<<"Inserire la stringa da cercare: ";
    cin>>find;

    char word[256];

    while(input>>word){
        bool valid=1;
        for(int i=0; i<strlen(find); i++){
            if((find[i] != word[i]) && (find[i] != '*')){
                valid=0;
            }
        }
        if(strlen(find) != strlen(word)){
            valid=0;
        }
        if(valid){
            cout<<word<<endl;
        }
    }

    input.close();
    return 0;
}