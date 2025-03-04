#include <iostream>
#include <fstream>
#include<cstring>
#include<cmath>
using namespace std;

int encode(char* word){
    int res=0;
    for(int i=0; i<strlen(word); i++){
        if(word[i]>='0' && word[i]<='9'){
            res+=(word[i]-'0')*pow(36, strlen(word)-1-i);
        }else if(word[i]>='a' && word[i]<='z'){
            res+=(word[i]-'a'+10)*pow(36, strlen(word)-1-i);
        }
    }
    return res;
}

int lunghezza_str(int num){
    int i=0;
    while(num>0){
        num/=36;
        i++;
    }
    cout<<"Lunghezza str: "<<i<<endl;
    return i;
}

void decode(char* word, int num){
    int counter=lunghezza_str(num)-1;
    while(num > 0){
        int ultimo_char= num%36;
        cout<<ultimo_char<<" - ";
        num/=36;
        if(ultimo_char < 10){
            word[counter]='0'+ultimo_char;
        }else{
            word[counter]='a'+(ultimo_char-10);
        }
        cout<<word[counter]<<endl;
        counter--;
    }
}

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Errore: ./a.out <input_fil> <output_file>"<<endl;
        return -1;
    }
    fstream input, output;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error in input opening"<<endl;
        return -2;
    }
    output.open(argv[2], ios::out);
    if(output.fail()){
        cerr<<"Error in output opening"<<endl;
        input.close();
        return -2;
    }

    int key;

    do{
        cout<<"Inserire la chiave di criptazione: ";
        cin>>key;

        if(key>=10000000){
            cout<<"Chiave inserita troppo grande"<<endl;
        }
    }while(key>=10000000);

    char word[5];
    

    while(input>>word){
        if(strlen(word) == 5){
            word[4] = '\0';
        }else{
            word[strlen(word)] = '\0';
        }
        int encoded=encode(word);
        encoded+=key;
        decode(word, encoded);
        output<<word<<" ";
    }

    input.close();
    output.close();
    return 0;
}