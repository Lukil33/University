#include<iostream>
#include<fstream>
#include<cstring>
#include<cmath>
using namespace std;

void rotate_array(char word[], int key);
void check(char word[]);
void end_word(char word[], char end[]);

int main(int argc, char * argv []) {
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

    int key;

    cout<<"Inserire un valore di shifting: ";
    cin>>key;

    char word[256];

    while(input>>word){
        int i=0;
        while((word[i] != '\0') && ((word[i]<'a' || word[i]>'z') && (word[i]<'A' || word[i]>'Z'))){
            output<<word[i];
            i++;
        }
        rotate_array(word, i);
        word[strlen(word)-i]='\0';

        char end[256]={};
        end_word(word, end);

        check(word);
        rotate_array(word, key);
        output<<word<<end<<" ";
    }

    input.close();
    output.close();
    return 0;
}

void rotate_array(char word[], int key){
    key=key%strlen(word);
    for(int g=0; g<key; g++){
        int temp;
        for(int i=0; i<int(strlen(word));i++){
            if(i==0){
                temp=word[0];
                word[i]=word[i+1];
            }else if(i==int(strlen(word)-1)){
                word[i]=temp;
            }else{
                word[i]=word[i+1];
            }
        }
    }
}

void check(char word[]){
    int i=0;
    while(word[i] != '\0'){
        if(word[i]>='A' && word[i]<='Z'){
            word[i]-='A'-'a';
        }
        i++;
    }
}

void end_word(char word[], char end[]){
    int i=strlen(word)-1;
    int g=0;
    while((i>=0) && (word[i]<'a' || word[i]>'z') && (word[i]<'A' || word[i]>'Z')){
        end[g]=word[i];
        i--;
        g++;
    }
    word[i+1]='\0';
}