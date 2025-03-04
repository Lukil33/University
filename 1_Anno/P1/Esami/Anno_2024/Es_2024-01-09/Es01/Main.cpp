#include <iostream>
#include <fstream>
using namespace std;

void elaborariga(char str[], int num[], int& ris);
int converti(int b[], int n);
int pow(double base, double esponente);
int somma(int a[], int n=13);

int main(){
    fstream input, output;
    input.open("inputdati.txt", ios::in);
    if(input.fail()){
        cerr<<"Error during file opening"<<endl;
        return -2;
    }
    output.open("outputcheck.txt", ios::out);
    if(output.fail()){
        cerr<<"Error during file opening"<<endl;
        input.close();
        return -2;
    }
    
    char str[127];
    int ris;

    while(input>>str){
        int num[13]={};
        elaborariga(str, num, ris);
        if(ris == somma(num)){
            output<<ris<<endl;
        }else{
            output<<"Errore"<<endl;
        }
    }

    input.close();
    output.close();
    return 0;
}

void elaborariga(char str[], int num[], int& ris){
    int i=0;
    int depth_num=0;
    int n=0;
    int b[8];
    while(str[i] != ';'){
        if(str[i] == '1' || str[i] == '0'){
            b[n]=str[i]-'0';
            n+=1;
        }else{
            num[depth_num]=converti(b, n);
            n=0;
            depth_num+=1;
        }
        i+=1;
    }
    ris=converti(b, n);
}

int converti(int b[], int n){
    int res=0;
    for(int i=0; i<n; i++){
        res+=b[i]*pow(2, n-1-i);
    }
    return res;
}

int pow(double base, double esponente){
    double ris=1;
    while(esponente>0){
        ris*=base;
        esponente--;
    }
    return ris;
}

int somma(int a[], int n){
    int sum=0;
    for(int i=0; i<n; i++){
        sum+=a[i];
    }
    return sum;
}