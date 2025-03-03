#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int dim, rep;
vector<string> cat;
vector<int> res;

void read_input();

void check();

void controlloFinale();

int main(){
    read_input();

    check();

    controlloFinale();
    return 0;
}

void read_input(){
    ifstream in ("input.txt");

    in >> dim >> rep;

    cat.resize(rep+1);
    res.resize(rep,0);

    for(int i=0; i<rep+1; i++){
        for(int j=0; j<dim; j++){
            char carattere;
            in >> carattere;
            cat[i].push_back(carattere);
        }
    }
}

void check(){
    for(int i=0; i<rep; i++){
        for(int element = 0; element<dim; element++){
            if(cat[0][element] == cat[i+1][element]){
                res[i] += 1;
            }
        }
    }
}

void controlloFinale(){
    ifstream out ("output.txt");

    bool palle = true;
    for(int i=0; i<(int)res.size(); i++){
        int num;
        out >> num;
        if(res[i] != num){
            palle = false;
        }
    }
    cout<<"Corretto: "<<palle<<endl;
}