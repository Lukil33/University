#include <iostream>
#include <cstdlib>
#include <ctime>

#define MAXVALUE 100
#define MAXSIZE 100

// NON MODIFICARE IL CODICE SOTTO FINO A "NON MODIFICARE IL CODICE SOPRA"
struct list {
  int info;
  list * next;
};

struct tree {
  int info;
  tree * left;
  tree * right;
};

void insert(tree * & result, const int num) {
		if (result == NULL) {
				result = new tree;
				*result = {num, NULL, NULL};
		} else if (result->info > num) {
				insert(result->left, num);
		} else {
				insert(result->right, num);
		}
}

tree * crea_tree(const int num) {
		tree * result = NULL;
		for(int i = 0; i < num; i++) {
				insert(result, rand()%MAXVALUE);
		}
		return result;
}

void print_tree(const tree * root){
		if (root != NULL) {
				print_tree(root->right);
				std::cout << " " << root->info;
				print_tree(root->left);
  }
}

void delete_tree(tree * & root) {
  if (root != NULL) {
    delete_tree(root->left);
    delete_tree(root->right);
    delete root;
    root = NULL;
  }
}

void print_array(const int l[], const int l_size) {
  for(int i = 0; i < l_size; i++)
    std::cout << " " << l[i];
  std::cout << std::endl;
}

// NON MODIFICARE IL CODICE SOPRA

// Add hereafter the declaration of estrai
void estrai(const tree* root, int*& l1, int& l1_size, int*& l2, int& l2_size);
void count_node(const tree* root, int& l1_size, int& l2_size);
// Add here above the declaration of estrai

// NON MODIFICARE IL MAIN
int main(int argc, char ** argv) {
  srand(unsigned(time(0)));
		//
		// Commentare la linea seguente per avere comportamento
		// non-deterministico
		//
		srand(0);
		tree * root = crea_tree(rand()%MAXSIZE);
		std::cout << "Initial tree content: ";
		print_tree(root); std::cout << std::endl;
  int * l1;
  int l1_size;
  int * l2;
  int l2_size;
  estrai(root, l1, l1_size, l2, l2_size);
  delete_tree(root);
		std::cout << "L1 =";
  print_array(l1, l1_size);
		std::cout << "L2 =";
  print_array(l2, l2_size);
  delete [] l1;
  delete [] l2;
}
// NON MODIFICARE IL MAIN

// Add hereafter the definition of estrai
void count_node(const tree* root, int& l1_size, int& l2_size){
    if(root != nullptr){
        count_node(root->left, l1_size, l2_size);
        if(root->info%2){
            l2_size+=1;
        }else{
            l1_size+=1;
        }
        count_node(root->right, l1_size, l2_size);
    }
}

void insert_number(const tree* root, int*& l1, int& l1_size, int& counter_1, int*& l2, int& l2_size, int& counter_2){
    if(root != nullptr){
        insert_number(root->left, l1, l1_size, counter_1, l2, l2_size, counter_2);
        if(root->info%2){
            l2[counter_2]=root->info;
            counter_2+=1;
        }else{
            l1[counter_1]=root->info;
            counter_1+=1;
        }
        insert_number(root->right, l1, l1_size, counter_1, l2, l2_size, counter_2);
    }
}

void estrai(const tree* root, int*& l1, int& l1_size, int*& l2, int& l2_size){
    count_node(root, l1_size, l2_size);
    l1=new int[l1_size];
    l2=new int[l2_size];
    int counter_1=0;
    int counter_2=0;
    insert_number(root, l1, l1_size, counter_1, l2, l2_size, counter_2);
}
// Add here above the definition of estrai
