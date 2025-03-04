using namespace std;
#include <iostream>
#include <cstdlib>

#include "queue.h"

void   init    (queue &q){
    queue q;
}

void   enqueue (queue &q, long val){
    node* created=new node{val, nullptr};
    if(empty(q)){
        q.head=created;
        q.tail=created;
    }else{
        q.tail->next=created;
        q.tail=created;
    }
}

retval dequeue (queue &q){
    if(empty(q)){
        return FALSE;
    }else{
        node* pointer=q.head;
        q.head=q.head->next;
        if(q.head == q.tail){
            q.tail=nullptr;
        }
        delete[] pointer;
    }
}

retval empty   (const queue &q){
    if((q.head == nullptr) && (q.tail==nullptr)){
        return FALSE;
    }else{
        return TRUE;
    }
}

retval first   (const queue &q, long &result){
    if(empty(q)){
        return FALSE;
    }else{
        result = q.head->val;
        return TRUE;
    }   
}

void   print   (const queue &q){
    node* pointer=q.head;
    while(pointer != nullptr){
        cout<<pointer->val<<" ";
        pointer=pointer->next;
    }
    cout<<endl;
}