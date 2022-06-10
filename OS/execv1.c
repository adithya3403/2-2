#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main(int argc, char* argv[]) {
    printf("PID of execv1.c = %d\n", getpid());
    char* args[] = {"Hello", "Welcome", NULL};
    execv("./execv2", args);
    printf("Back to execv1.c\n");
}


/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS$ gcc execv1.c -o execv1
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS$ ./execv1
PID of execv1.c = 85
Back to execv2.c
PID of execv2.c = 85
*/