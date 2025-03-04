#include<iostream>
#include<fstream>
#include<cstring>
#include<cmath>
using namespace std;

bool is_present(char find[], char letter);

int main(int argc, char * argv []) {
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
    cout<<"Inserire la sequenza di caratteri da cercare: ";
    cin.getline(find, 256);

    char riga[256];
    while(input.getline(riga, 256)){
        for(int i=0; i<strlen(riga); i++){
            if(is_present(find, riga[i])){
                cout<<riga[i];
            }
        }
        cout<<endl;
    }

    input.close();
    return 0;
}

bool is_present(char find[], char letter){
    bool is_valid=0;

    if(letter>='A' && letter<='Z'){
        letter+='a'-'A';
    }

    for(int i=0; i<strlen(find); i++){
        if(find[i]>='A' && find[i]<='Z'){
            find[i]+='a'-'A';
        }
        if(find[i] == letter){
            is_valid=1;
        }
    }
    return is_valid;
}