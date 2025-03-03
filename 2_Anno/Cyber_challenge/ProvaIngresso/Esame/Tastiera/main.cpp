#include <stdio.h>
#include <iostream>
#include <vector>
#include <array>

using namespace std;

string find_key(int L, string s){
    // WRITE YOUR CODE HERE
    vector<bool> status;
    status.resize(26,false);
    int countNotFound = 26;

    for(char letter:s){
        if(!status[(int)(letter-'a')]){
            countNotFound -= 1;
            status[(int)(letter-'a')] = true;
        }
    }

    char res = 'a';
    string a;
    for(int i=0; i<status.size(); i++){
        if(!status[i]){
            res += i;
            a.push_back(res);
        }
    }
    return a;
}

int main(){
    freopen("input.txt", "r", stdin); // DECOMMENT IF YOU WANT TO READ FROM FILE
    freopen("output.txt", "w", stdout); // DECOMMENT IF YOU WANT TO WRITE TO FILE

    int N;
    cin >> N;

    while(N--){
        int L;
        string s;

        cin >> L;
        cin >> s;
        cout << find_key(L, s) << endl;
    }

    return 0;
}