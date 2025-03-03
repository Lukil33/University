#include <stdio.h>
#include <iostream>
#include <vector>
#include <array>

using namespace std;

long long count_intervals(int N, vector<int> a){
    // WRITE YOUR CODE HERE
    return 0;
}

int main(){
    // freopen("input.txt", "r", stdin); // DECOMMENT IF YOU WANT TO READ FROM FILE
    // freopen("output.txt", "w", stdout); // DECOMMENT IF YOU WANT TO WRITE TO FILE

    int T;
    cin >> T;

    while(T--){
        int N;
        cin >> N;
        vector<int> a(N);

        for(auto &x : a) cin >> x;

        cout << count_intervals(N, a) << endl;
    }

    return 0;
}