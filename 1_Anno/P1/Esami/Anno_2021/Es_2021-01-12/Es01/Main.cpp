#include <iostream>
#include <fstream>
using namespace std;

int strlen(char* word);
void strcpy(char archivio[101], char word[101]);

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_file> <output_file>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error during input opening"<<endl;
        return -2;
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Error during output opening"<<endl;
        input.close();
        return -2;
    }

    int contatore=0;
    char word[101];
    char archivio[10001][101];
    while(input>>word){
        int len=strlen(word);
        if(len%2 == 0){
            strcpy(archivio[contatore], word);
            contatore+=1;
        }
    }

    for(int i=contatore-1; i>=0; i--){
        output<<archivio[i]<<" ";
    }

    input.close();
    output.close();
    return 0;
}

int strlen(char* word){
    int i=0;
    while(word[i] != '\0'){
        i++;
    }
    return i;
}

void strcpy(char archivio[101], char word[101]){
    for(int i=0; word[i] != '\0'; i++){
        archivio[i]=word[i];
        archivio[i+1]='\0';
    }
}