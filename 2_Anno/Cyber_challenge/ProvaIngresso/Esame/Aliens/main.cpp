#include <stdio.h>
#include <iostream>
#include <vector>
#include <array>
#include <bits/stdc++.h>

using namespace std;

int decoder(char character){
    int res = 0;
    if(character >= 'a' && character <= 'z'){
        res += (int)(character-'a');
    }else if(character >= 'A' && character <= 'Z'){
        res += (int)(character-'A') + 26;
    }else{
        res += (int)(character-'0') + 52;
    }
    return res;
}

char encoder(int number){
    if(number >= 0 && number <= 25){
        return 'a'+number;
    }else if(number >= 26 && number <= 51){
        return 'A'+(number-26);
    }else{
        return '0'+(number-52);
    }
}

void swapOne(vector<vector<int>>& position){
    vector<int> temp = position[0];
    for(int i=60; i>=0; i--){
        position[i] = position[i+1];
    }
    position[61] = temp;
}

string execute_code(int N, vector<string> code){
    // WRITE YOUR CODE HERE
    vector<vector<int>> position;
    vector<int> temp;
    position.resize(62);
    int dimRes = 0;
    char lastElem;
    for(string command:code){
        if(command[0] == 'a'){
            position[decoder(command[4])].push_back(dimRes);
            dimRes += 1;
            lastElem = command[4];
        }else if(command[0] == 'd'){
            if(dimRes != 0){
                position[decoder(lastElem)].pop_back();
                dimRes -= 1;
            }
        }else if(command[0] == 's'){
            int positionF = decoder(command[5]);
            int positionS = decoder(command[7]);
            temp = position[positionF];
            position[positionF] = position[positionS];
            position[positionS] = temp;
            if(lastElem == command[5]){
                lastElem = command[7];
            }else if(lastElem == command[7]){
                lastElem = command[5];
            }
        }else if(command[0] == 'r'){
            string number = command.substr(4);
            for(int i=0; i<stoi(number) % 62; i++){
                swapOne(position);
            }
            lastElem = encoder((decoder(lastElem)+stoi(number))%62);
        }
    }

    string res;
    res.resize(dimRes);
    for(int i=0; i<(int)position.size(); i++){
        for(int pos:position[i]){
            res[pos] = encoder(i);
        }
    }

    return res;
}

int main(){
    freopen("input.txt", "r", stdin); // DECOMMENT IF YOU WANT TO READ FROM FILE
    freopen("output.txt", "w", stdout); // DECOMMENT IF YOU WANT TO WRITE TO FILE

    int N;
    vector<string> code;
    cin >> N;

    string s;
    getline(cin, s);

    for(int i = 0; i < N; i++){
        getline(cin, s);
        code.push_back(s);
    }

    cout << execute_code(N, code);

    return 0;
}