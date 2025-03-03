#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

void read_input();
void write_output();

void move();
void scan();
void transform();
void reset();


int row, col, mov;
vector<vector<char>> map;
vector<vector<int>> count;

int main(){
    read_input();

    move();

    write_output();
    return 0;
}

void read_input(){
    ifstream in ("input.txt");

    in >> row >> col >> mov;

    map.resize(row);
    count.resize(row);

    for(int x = 0; x < row; x++){
        for(int y = 0; y < col; y++){
            char carattere;
            in >> carattere;
            map[x].push_back(carattere);
            count[x].push_back(0);
        }
    }
}

void move(){
    for(; mov > 0; mov--){
        scan();
        transform();
        reset();
    }
}

void scan(){
    for(int x = 0; x < row; x++){
        for(int y = 0; y < col; y++){
            if(map[x][y] != '.'){
                // Scusami me del futuro, questo codice è una merda
                for(int i=-1; i<2; i++){
                    if(x+i >= 0 && x+i < row){
                        for(int j=-1; j<2; j++){
                            if(y+j >= 0 && y+j < col && !(i == 0 && j == 0)){
                                count[x+i][y+j] += 1;
                            }
                        }
                    }
                }
            }
        }
    }
}

void transform(){
    for(int x = 0; x < row; x++){
        for(int y = 0; y < col; y++){
            if(map[x][y] == '.' && count[x][y] > 4){
                map[x][y] = '+';
            }else if(map[x][y] == '+'){
                if(count[x][y] > 4){
                    map[x][y] = '*';
                }else if(count[x][y] < 4){
                    map[x][y] = '.';
                }
            }else if(map[x][y] == '*'){
                if(count[x][y] > 4){
                    map[x][y] = '+';
                }else if(count[x][y] < 4){
                    map[x][y] = '.';
                }
            }
        }
    }
}

void reset(){
    for(int x = 0; x < row; x++){
        for(int y = 0; y < col; y++){
            count[x][y] = 0;
        }
    }
}

void write_output(){
    ofstream out ("output.txt");
    for(int x = 0; x < row; x++){
        for(int y = 0; y < col; y++){
            out<<map[x][y];
        }
        out<<endl;
    }
}