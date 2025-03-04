#include<iostream>
#include<fstream>
#include<cstring>
using namespace std;

void rotate_array(char word[], int key);
bool string_compare(char find[], char word[]);

int main(int argc, char * argv []) {
    if(argc != 2){
        cerr<<"Error: ./a.out <input_fle>"<<endl;
        exit(1);
    }

    fstream input;
    input.open(argv[1], ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        exit(2);
    }

    int key;
    cout<<"Inserire il valore di shifting: ";
    cin>>key;
    char find[256];
    cout<<"Inserire la sequenza da trovare: ";
    cin>>find;

    for(int i=0; i<strlen(find); i++){
        if(find[i]>='A' && find[i]<='Z'){
            find[i]+='a'-'A';
        }
    }

    rotate_array(find, key);

    char word[256];
    int occorrenze=0;

    while(input>>word){
        if(string_compare(find, word)){
            occorrenze+=1;
        }
    }

    cout<<occorrenze<<endl;

    input.close();
    return 0;
}

void rotate_array(char word[], int key){
    key=key%strlen(word);
    for(int g=0; g<key; g++){//ripete il ciclo k volte
        int temp;
        for(int i=strlen(word)-1; i>=0; i--){//ruota di uno a destra
            if(i==0){
                word[i]=temp;
            }else if(i==strlen(word)-1){
                temp=word[i];
                word[i]=word[i-1];
            }else{
                word[i]=word[i-1];
            }
        }
    }
}

bool string_compare(char find[], char word[]){
    bool valid=0;
    for(int i=0; i<strlen(word); i++){
        if(word[i]==find[0]){
            bool is_valid=1;
            for(int g=0; g<strlen(find); g++){
                if(word[g+i]!=find[g]){
                    is_valid=0;
                }
            }
            if(is_valid){
                valid=1;
            }
        }
    }
    return valid;
}