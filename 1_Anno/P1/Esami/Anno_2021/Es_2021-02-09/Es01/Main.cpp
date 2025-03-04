#include <iostream>
#include <fstream>
using namespace std;

void strcpy(char archivio[], char word[]){
    int i=0;
    for(; word[i] != '\0'; i++){
        archivio[i]=word[i];
    }
    archivio[i+1]='\0';
}

int strlen(char* word){
    int i=0;
    for(; word[i] != '\0'; i++){
    }
    return i;
}

bool check(char word[],char archivio[][101], int i){
    if(i<0){
        return false;
    }
    bool controllo=true;
    if(strlen(word) != strlen(archivio[i-1])){
        controllo=false;
    }
    for(int g=0; word[g] != '\0'; g++){
        char letter=word[g];
        if(letter>='A'&&letter<='Z'){
            letter=letter+'a'-'A';
        }
        if(letter != archivio[i-1][g]){
            controllo= false;
            
        }
    }
    if(controllo){
        return true;
    }else{
        return check(word, archivio, i-1);
    }
}

int main(int argc, char* argv[]){
    if(argc != 4){
        cerr<<"Input error"<<endl;
        return 1;
    }
    fstream messaggio, vocabolario, output;
    messaggio.open(argv[1], ios::in);
    vocabolario.open(argv[2], ios::in);
    output.open(argv[3], ios::out);
    
    int i=0;
    char archivio[1000][101];
    char word[101];
    while(vocabolario>>word){
        if(i<1000){
            strcpy(archivio[i], word);
            i++;
        }
    }

    while(messaggio>>word){
        if(check(word, archivio, i)){
            for(int f=0; word[f] != '\0'; f++){
                output<<'X';
            }
            output<<" ";
        }else{
            output<<word<<" ";
        }
    }

    messaggio.close();
    vocabolario.close();
    output.close();
    return 0;
}