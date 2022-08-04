#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
int main() {
    char buffer[100];
    int res = open("fifo1", O_RDONLY);
    int n = read(res, buffer, 100);
    printf("Reader process %d started\n", getpid());
    printf("Data received by receiver %d is: %s\n", getpid(), buffer);
}
