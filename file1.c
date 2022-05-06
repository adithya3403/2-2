#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
int main(int argc, char* argv[]) {
    printf("PID of file1.c = %d\n", getpid());
    char* args[] = {"Hello", "Welcome", NULL};
    execv("./file2", args);
    printf("Back to file1.c");
    return 0;
}
