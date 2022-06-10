#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main(int argc, char* argv[]) {
    printf("Back to execv2.c\n");
    printf("PID of execv2.c = %d\n", getpid());
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS$ gcc execv2.c -o execv2
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS$ ./execv2
Back to execv2.c
PID of execv2.c = 91
*/