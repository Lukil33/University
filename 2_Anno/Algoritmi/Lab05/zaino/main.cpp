#include <iostream>
#include <fstream>
#include <vector>
#include <unordered_map>
using namespace std;

vector<pair<int,int>> pesoexp;
vector<pair<int,int>> memo;

int zaino(int, int);

int main(){
    ifstream in ("input.txt");
    ofstream out ("output.txt");

    int peso, n;
    in >> peso >> n;

    pesoexp.resize(n);

    for(int i=0; i<n; i++){
        int f,s;
        in >> f >> s;
        pesoexp[i].first = f;
        pesoexp[i].second = s;
    }

    out << zaino(peso,n);

    return 0;
}

int zaino_w(int C, int N, unordered_map<int,unordered_map<int,int>> &mat, int i){
    //cout << "C: " << C << " i: " << i << endl;
    if(i<0 || C<=0)
        return 0;
    
    int cache = mat[i][C];
    //cout << cache << endl;
    if(cache != 0)
        return cache;
    
    if(i==0){
        if(pesoexp[i].first<C){
            mat[i][C] = pesoexp[i].second;
            return pesoexp[i].second;
        }
        mat[i][C] = 0;
        return 0;
    }
    if(C<pesoexp[i].first){
        int m = zaino_w(C,N,mat,i-1); 
        mat[i][C] = m;
        return m;
    }
    
    int m_1 = zaino_w(C,N,mat,i-1);
    int m_2 = zaino_w(C-pesoexp[i].first,N,mat,i-1)+pesoexp[i].second;

    if(m_1>m_2){
        mat[i][C]=m_1;
        return m_1;
    }else{
        mat[i][C]=m_2;
        return m_2;
    }
}
int zaino(int C, int N){
    unordered_map<int,unordered_map<int,int>> mat;
    
    return zaino_w(C,N,mat,N-1);
}
