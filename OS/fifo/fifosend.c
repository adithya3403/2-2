#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
int main() {
    int res, n;
    res = open("fifo", O_WRONLY);
    write(res, "message", 7);
    printf("sender process having pid %d sent the data\n", getpid());
}
