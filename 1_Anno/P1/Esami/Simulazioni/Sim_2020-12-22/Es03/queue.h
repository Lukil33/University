#ifndef QUEUE_H
#define QUEUE_H

struct node {
  long val;
  node *next;
};

struct queue {
  node *head;
  node *tail;
};


enum retval {FALSE = 0, TRUE = 1};


void   init    (queue &q);
void   enqueue (queue &q, long val);
retval dequeue (queue &q);
retval empty   (const queue &q);
retval first   (const queue &q, long &result);
void   print   (const queue &q);


#endif // QUEUE_H