#include <iostream>
#include <fstream>
#include <cstring>
#include <cmath>
using namespace std;

double convert(char word[]);
double operation(double first_num, char sign, double second_num);

int main(int argc, char* argv[]){
    if(argc != 3){
        cerr<<"Error: ./a.out <input_file> <output_file>"<<endl;
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

    char word[11];
    char sign;
    while(input>>word){
        double first_num=convert(word);
        input>>sign;
        input>>word;
        double second_num=convert(word);
        output<<operation(first_num, sign, second_num)<<endl;
    }
    input.close();
    output.close();
    return 0;
}

double convert(char word[]){
    double ris=0;
    for(int i=0; i<int(strlen(word)); i++){
        if(word[i]>='0'&&word[i]<='9'){
            ris+=(word[i]-'0')*pow(17, strlen(word)-i-1);
        }else if(word[i]>='A'&&word[i]<='G'){
            ris+=((word[i]-'A')+10)*pow(17, strlen(word)-i-1);
        }
    }
    return ris;
}

double operation(double first_num, char sign, double second_num){
    switch(sign){
        case '+':
            return first_num+second_num;
            break;
        case '-':
            return first_num-second_num;
            break;
        case '*':
            return first_num*second_num;
            break;
        case '/':
            return first_num/second_num;
            break;
        case '^':
            return pow(first_num, second_num);
            break;
    }
    return 0;
}