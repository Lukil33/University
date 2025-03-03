#include <iostream>
#include <fstream>
#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

int numPlayer, numTask, numSub;
vector<pair<string,int>> task;
vector<vector<bool>> solved;
vector<tuple<int,int,int>> scb;

void read_input();

int main(){
    read_input();
    return 0;
}

void read_input(){
    ifstream in ("input.txt");

    in >> numPlayer >> numTask >> numSub;

    for(int i=0; i<numTask; i++){
        string cod;
        int point, id;
        in >> id >> cod >> point;
        task.push_back(make_pair(cod,point));
    }

    solved.resize(numPlayer,vector<bool>(numTask,false));

    for(int i=0; i<numPlayer; i++){
        scb.push_back(make_tuple(0,0,-(i+1)));
    }

    for(int i=0; i<numSub; i++){
        string cod;
        int time, idPlayer, idTask;
        in >> idPlayer >> idTask >> cod >> time;
        if(!solved[idPlayer-1][idTask-1]){
            if(task[idTask-1].first == cod){
                get<0>(scb[idPlayer-1]) += task[idTask-1].second;
                if(get<1>(scb[idPlayer-1]) < time){
                    get<1>(scb[idPlayer-1]) = time;
                }
                solved[idPlayer-1][idTask-1] = true;
            }
        }
    }

    sort(scb.begin(), scb.end());

    for(int i=scb.size()-1; i>=0; i--){
        cout<<-get<2>(scb[i])<<" "<<get<0>(scb[i])<<endl;
    }
}