#include <stdio.h>
#include <iostream>
#include <vector>
#include <array>

using namespace std;

long long find_sum_of_times(int N, int M, vector<int> t, vector<int> f, vector<int> emails){
    // WRITE YOUR CODE HERE
    long long res = 0;

    long long maxTime = 0;
    int pos = 0;
    for(int i=0; i<N; i++){
        if(t[i] > maxTime){
            maxTime = t[i];
            pos = i;
        }
    }

    int time = res;
    for(int elem=pos; elem<N; elem++){
        if(time%t[elem]){
            time += t[elem]-(time%t[elem]);
        }
        time +=f[elem];
    }
    res += time*M;
    cout<<res/2<<endl;

    for(int start:emails){
        int time = start;
        for(int elem=0; elem<pos; elem++){
            if(time%t[elem]){
                time += t[elem]-(time%t[elem]);
            }
            time +=f[elem];
        }
        time += t[pos]-(time%t[pos]);
        res += time;
    }
    return res;
}

int main(){
    freopen("input.txt", "r", stdin); // DECOMMENT IF YOU WANT TO READ FROM FILE
    freopen("output.txt", "w", stdout); // DECOMMENT IF YOU WANT TO WRITE TO FILE

    int N, M;
    cin >> N >> M;
    vector<int> t(N), f(N), emails(M);

    for(auto& x : t) cin >> x;
    for(auto& x : f) cin >> x;
    for(auto& x : emails) cin >> x;

    cout << find_sum_of_times(N, M, t, f, emails);

    return 0;
}