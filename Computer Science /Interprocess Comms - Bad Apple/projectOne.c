/**
 * Steve Meadows and Lauren Inman
 * CIS 452
 * Section 03
 * Winter '23
 * Project 1 - Bad Apple
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#define messageLength 100
#define parentNode 0

//global variables for signal
int pid, parent, child, node;

/**
 * myApple stuct 
 * object to be passed by each node
 * contains who the message is to, what the message says and also
 * contains info on which node is the bad apple.
*/
struct myApple {
  int intendedNode;
  char message[messageLength];
  int badApple;
};

/**
 * checkNode function checks unpacks the apple and identifies who the message is for
*/
bool checkNode(int myNode, int intendedNode){
    bool isForMe = true;
    if (myNode == intendedNode) {
        printf("Node:%d:[PID:%d] Hey, this message is for me!! :)\n", myNode, getpid());
        sleep(2);
        printf("Node:%d:[PID:%d] Returning this empty apple back to node 0!\n", myNode, getpid());
        return isForMe;
    } else { return !isForMe; } 
}

/**
 * badApple function called if the node is the bad apple. This function
 * takes the original message, scrambles up a randome string and sends it on to the 
 * next node.
*/
char* badApple(int numChar, int myNode, char *inStr){
    sleep(2);
    printf("Node:%d:[PID:%d] I'M THE BAD APPLE!\n", myNode, getpid());
    sleep(2);
    printf("Node:%d:[PID:%d] I HAVE DESTROYED YOUR MESSAGE!\n", myNode, getpid());
    sleep(2);
    printf("Node:%d:[PID:%d] I received [%s]...\n", myNode, getpid(), inStr);
    char * str = malloc(numChar * sizeof(char)); // allocates space for new string
    srand(time(NULL)); // rand() function initializer
    for (int i = 0; i < numChar - 1; i++){ // creates randome string the same length as the original
        str[i] = rand() % (122 - 97 + 1) + 97;
    }
    str[numChar-1] = 0; //returns string
    sleep(2);
    printf("Node:%d:[PID:%d] but I think I'll send [%s] instead!\n", myNode, getpid(), str);
    return str; 
}

/**
 * Signal Interrupt Handler
*/
void sigHandler (int sigNum) {
    pid = getpid();
    if (pid == parent){
        printf("Parent process interrupted. Node: 0 [PID: %d] has terminated.\n", pid);
    }
    else{
        printf("Child process interrupted. Node: %d [PID: %d] has terminated.\n", node, pid);
    }
    exit(0);
}

/**
 * forkChildren function called by parent. This function forks the number of child nodes
 * needed and creates the number of pipes needed to pass an apple between neighber nodes.
*/
void forkChildren (int nChildren) {
    
    int i, status;
    pid_t pid;
    int fd[nChildren][2];

    // create a pipe for each node
    for (i=0; i < nChildren; i++) {

        // piping error
        if ( pipe(fd[i]) < 0){
            printf("failed pipe creation\n");
            exit(1);
        }
    }
    // create child processes (k-1 nodes)
    for (i = 0; i < nChildren-1; i++) {
        pid = fork();

        // forking error
        if (pid < 0 ){
            perror("fork error");          
            exit(1);
        }

        /* child process */ 
        else if (pid == 0) {
            char inStr[messageLength] = "";
            int inX, inNode;
            struct myApple inApple;
            printf("Child process [%d] created\n", getpid());
            sleep(1);
        
            for (int k=0; k < nChildren; k++){ // close all unused pipes
                for (int j = 0; j < 2; j++){
                    if((k == i && j == 0) ||  (k == (i + 1) && j == 1)){ // if child's read pipe, do nothing
                        ;
                    }
                    else if (k == (i + 1) && j == 1){ // if the child's write pipe, do nothing
                        ;
                    } 
                    else { // else, close all pipes
                        close(fd[k][j]);
                    }
                }
            }
        
            node = i + 1; // global node counter
            sleep(5);

            /** 
             * Child Read
            */
            while (1) { // While loop to ensure that processes don't close until sigint is called.
                bool forMe = false;
                bool noMoreBadApple = false;

                sleep(1);
                if (read(fd[i][0], &inApple, sizeof(inApple)) < 0 ) { // create child's write pipe
                    printf("Node:%d: [PID:%d]:", i+1, getpid());
                    perror(" Read Error");
                    exit(1);
                }
                
                sleep(2);
                printf("Node:%d:[PID:%d] I received the message: [%s] \n", i+1, getpid(), inApple.message);
                sleep(2);
                
                /**
                 * Child's check node function call
                */
                forMe = checkNode(node, inApple.intendedNode); 
                if (forMe) {
                    strcpy(inApple.message, inStr); // keeps message if intended for current node
                    inApple.badApple = -1; // removes need for bad apple
                }
                

                /**
                 * Child's bad apple function call
                */
                if(inApple.badApple == node){
                    int length = strlen(inApple.message); // captures the length of message
                    strcpy(inApple.message, badApple(length+1, node, inApple.message)); //function call 
                    noMoreBadApple = true;
                }

                /**
                 * Child logic block
                */
                sleep(2);
                if (!forMe && inApple.intendedNode > node && node == inApple.badApple){ // if message isn't for me, and I'm the bad apple
                    printf("Node:%d:[PID:%d] Sending along a nice crusty message for %d!\n", node, getpid(), inApple.intendedNode);
                }
                if (!forMe && inApple.intendedNode > node && !noMoreBadApple ){ // if message isn't for me and there's still a bad apple out there
                    printf("Node:%d:[PID:%d] This isn't for me though, sending it along for node %d\n", node, getpid(), inApple.intendedNode);
                }
                else if (!forMe && inApple.intendedNode < node ){ // if message already recieved
                    printf("Node:%d:[PID:%d] Message already picked up. Sending apple back to node 0.\n", node, getpid());
                }
                sleep(2);

                /**
                 * Child Write
                */
                int outNode = inApple.intendedNode; // copy of intendedNode
                int badApple = inApple.badApple; // copy of bad apple
                char str[messageLength]; // new char string initialized
                strcpy(str, inApple.message); // copy of message
                struct myApple apple = {outNode, "", badApple}; // apple copy initializer
                strcpy(apple.message, str); // copy of string into the apple's string field
                
                if (write(fd[i+1][1], &apple, sizeof(apple)) < 0 ) { // create parent's write pipe
                    printf("Node %d [PID:%d]: ", i+1, getpid());
                    perror("Write Error");
                    exit(1);
                }
            }
    
            // close read and write pipes
            close(fd[i+1][1]);
            close(fd[i][0]);
        }
    } 

    /* parent process */

    char* (*badApplePtr)(int, int, char*) = &badApple; // pointer to badApple function
    
    parent = getpid(); // global parent PID capture
    while (1) { // While loop to ensure that processes don't close until sigint is called.
        char inStr[messageLength] = "";
        int pIntendedNode, c, badApple = 0, node = parentNode;
        char input[messageLength];
        bool forMe = false;
        bool noMoreBadApple = false;

        sleep(1);
        srand(time(NULL));
        badApple = rand() % nChildren; // choses randome node to be the bad apple
        printf("\n");

        fputs("Which node would you like to send a message to?: ", stderr); 
        scanf("%d", &pIntendedNode);

        while((c = getchar()) != '\n' && c != EOF) ; // stdin flush after scanf

        fputs("What message would you like to send?: ", stderr);
        fgets(input, messageLength, stdin);

        // if user sends message to k+1, it makes sure the message goes to node 0
        if (nChildren == pIntendedNode){ pIntendedNode = 0;} 
        
        input[strlen(input)-1] = '\0'; // add null char to string end
        struct myApple apple = {pIntendedNode, "", badApple}; // new apple initializer
        strcpy(apple.message, input); // enters users message into apple

        i = 0;
        for (int k=0; k < nChildren; k++){ // close all unused pipes
            for (int j = 0; j < 2; j++){
                if(k == nChildren-1 && j == 0){ // if parents read pipe, do nothing
                    ;
                }
                else if (k == 0 && j == 1){ // if parent's write pipe, do nothing
                    ;
                } else { // else, close the rest of the pipes
                    close(fd[k][j]);
                }
            }
        }

        /**
         * Parents's check node function call
        */
        forMe = checkNode(parentNode, pIntendedNode);
        if(forMe) {
            strcpy(apple.message, inStr);
            apple.badApple = -1;
        }

        /**
         * Parent's bad apple function call
        */
        if(badApple == parentNode){
            int length = strlen(apple.message); //convert strlen() from unsigned long to int
            strcpy(apple.message,(*badApplePtr)(length+1, parentNode, apple.message)); 
        }

        /**
         * Parent's logic block
        */
        sleep(2);
        if (!forMe && apple.intendedNode > parentNode && parentNode == apple.badApple){
            printf("Node:%d:[PID:%d] Sending along a nice crusty message for %d!\n", parentNode, getpid(), apple.intendedNode);
        }
        else if (!forMe && apple.intendedNode > parentNode ){
            printf("Node:0:[PID:%d] Incoming apple! Sending %s to node %d\n", getpid(), apple.message,  apple.intendedNode); // begin maiden voyage
        }
        sleep(2);

        /**
         * Parent Write
        */
        if (write(fd[0][1], &apple, sizeof(apple)) < 0 ) { // create parent's write pipe
            perror("Node 0 Write Error");
            exit(1);
        }
        struct myApple inApple; // init new apple for storage

        /**
         * Parent Read
        */
        if (read(fd[nChildren-1][0], &inApple, sizeof(inApple)) < 0 ){ // create parent's read pipe
            perror("Node 0 Read Error");
            exit(1);
        }
        sleep(2);
        printf("Node:%d:[PID:%d] Thanks everyone. I got my apple back!\n", parentNode, getpid());
        sleep(2);
    }
    // close parent's read and write pipe
    close(fd[0][1]);
    close(fd[nChildren-1][0]);
    exit(0); 
}

int main () {
    signal(SIGINT, sigHandler); // sigint signal installer
    char input[messageLength];
    struct myApple apple;
    int nodes, c;

    fputs("How many nodes would you like to create?: ", stderr); 
    scanf("%d", &nodes);
    
    printf("\n");
    printf("Parent Process [%d] created\n", getpid());
    forkChildren (nodes); // parent forkChildren function call
    return 0;
}