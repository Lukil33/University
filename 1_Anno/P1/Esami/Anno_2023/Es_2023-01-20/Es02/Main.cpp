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

void delete_list(list * &l) {
  if (l != NULL) {
    delete_list(l->next);
    delete l;
    l = NULL;
  }
}

void print_list(const list * l) {
  if (l != NULL) {
    std::cout << " " << l->info;
    print_list(l->next);
  }
  else
    std::cout << std::endl;
}

// NON MODIFICARE IL CODICE SOPRA


// Add hereafter the declaration of estrai
void estrai(const tree* root, list*& l1, list*& l2);
// Add here above the declaration of estrai

int main(int argc, char ** argv) {
  // NON MODIFICARE IL MAIN
  srand(unsigned(time(0)));
		//
		// Commentare la linea seguente per avere comportamento
		// non-deterministico
		//
		srand(0);
		tree * root = crea_tree(rand()%MAXSIZE);
		std::cout << "Initial tree content: ";
		print_tree(root); std::cout << std::endl;
  list * l1;
  list * l2;
  estrai(root, l1, l2);
  delete_tree(root);
		std::cout << "L1 =";
  print_list(l1);
		std::cout << "L2 =";
  print_list(l2);
  delete_list(l1);
  delete_list(l2);
  // NON MODIFICARE IL MAIN
}

// Add hereafter the definition of estrai
void estrai(const tree* root, list*& l1, list*& l2){
    if(root != nullptr){
        estrai(root->right, l1, l2);
        list* created=new list{root->info, nullptr};
        if(root->info%2){
            created->next=l2;
            l2=created;
        }else{
            created->next=l1;
            l1=created;
        }
        estrai(root->left, l1, l2);
    }
}
// Add here above the definition of estrai
