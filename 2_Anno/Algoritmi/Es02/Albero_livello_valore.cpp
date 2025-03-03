struct tree{
    int val;
    tree* left;
    tree* right;
};

int function(tree* t, int level){
    if(t == nullptr){
        return 0;
    }else{
        return function(t->left, level+1) + function(t->right, level+1) + (t->val == level)? 1:0;
    }
}