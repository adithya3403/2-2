#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
int main() {
    int res, n;
    res = open("fifo", O_WRONLY);
    write(res, "message", 7);
    printf("sender process having pid %d sent the data\n", getpid());
}


// adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/os/fifo$ gcc fifosend.c -o fifosend
// adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/os/fifo$ gcc fiforecv.c -o fiforecv
// adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/os/fifo$ ./fifosend & ./fiforecv
// [1] 50
// sender process having pid 50 sent the data
// reader process having pid 51 started
// Data received by receiver 51d is : messgae
// [1]+  Done                    ./fifosend