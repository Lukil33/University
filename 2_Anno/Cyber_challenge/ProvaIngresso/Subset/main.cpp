#include <iostream>
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int function(vector<int>, int, int);
void insertOrdered(vector<int>&, int);
int binarySearch(vector<int>, int, int, int);

int main(){
    ifstream in ("input.txt");
    
    int rep;
    in >> rep;
    vector<int> vec;
    vector<int> res;

    for(int i=0; i<rep; i++){

        int casi, diff;
        in >> casi >> diff;

        for(int i=0; i<casi; i++){
            int elem;
            in >> elem;
            vec.push_back(elem);
        }

        res.push_back(function(vec,casi,diff));
        vec.clear();
    }

    ifstream out ("output.txt");
    bool check = true;
    for(auto elem:res){
        int num;
        out>>num;
        if(num != elem){
            check = false;
        }
        cout<<num<<" - "<<elem<<endl;
    }

    cout<<"Risposta: "<<check<<endl;
    return 0;
}

int function(vector<int> vec, int casi, int diff){
    vector<vector<int>> subset;
    for(int elem:vec){
        int inserted = false;
        for(vector<int>& sub:subset){
            if(sub.front()+diff >= elem && sub.back()-diff <= elem){
                insertOrdered(sub, elem);
                inserted = true;
            }
        }
        if(!inserted){
            vector<int> newsub = {elem};
            subset.push_back(newsub);
        }
    }

    /*for(int x=0; x<(int)subset.size(); x++){
        for(int y=0; y<(int)subset[x].size(); y++){
            cout<<subset[x][y]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;*/

    int res = 0;
    for(int x=0; x<(int)subset.size(); x++){
        for(int y=0; y<(int)subset.size(); y++){
            if(x < y){
                if((subset[x].front() > subset[y].back() || subset[y].front() > subset[x].back()) && ((int)(subset[x].size()+subset[y].size()) > res)){
                    res = subset[x].size()+subset[y].size();
                }
            }
        }
        subset[x].clear();
    }
    return res;
}

void insertOrdered(vector<int>& sub, int elem){
    if(sub.front() == sub.back()){
        int num = sub.front();
        if(elem > sub.front()){
            sub.push_back(elem);
        }else{
            sub.clear();
            sub.push_back(elem);
            sub.push_back(num);
        }
    }else{
        sub.insert(sub.begin()+binarySearch(sub,elem,0,sub.size()-1), elem);
    }
}

int binarySearch(vector<int> vec, int elem, int low, int high){
    if(high <= low){
        if(elem > vec[low]){
            return low+1;
        }else{
            return low;
        }
    }else{
        int mid = (low + high)/2;
        if(elem == vec[mid]){
            return mid + 1;
        }else if(elem > vec[mid]){
            return binarySearch(vec,elem,mid + 1,high);
        }else{
            return binarySearch(vec,elem,low,mid - 1);
        }
    }
}