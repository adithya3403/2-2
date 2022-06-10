#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
int main() {
    int fd[2], n;
    char buffer[100];
    pid_t p;
    pipe(fd);
    p = fork();
    if (p > 0) {
        printf("Parent Passing value to child\n");
        write(fd[1], "this is the data\n", 6);
    } else {
        printf("Child printing received value\n");
        n = read(fd[0], buffer, 100);
        write(1, buffer, n);
    }
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS$ gcc pipes.c -o pipes
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS$ ./pipes
Parent Passing value to child
Child printing received value
this i
*/