#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/types.h>
#include <unistd.h>
struct my_msg {
    long int msg_type;
    char some_text[BUFSIZ];
};
int main() {
    int running = 1;
    int msgid;
    struct my_msg some_data;
    long int msg_to_rec = 0;
    msgid = msgget((key_t)14534, 0666 | IPC_CREAT);
    while (running) {
        msgrcv(msgid, (void *)&some_data, BUFSIZ, msg_to_rec, 0);
        printf("Data received: %s\n", some_data.some_text);
        if (strncmp(some_data.some_text, "end", 3) == 0) {
            running = 0;
        }
    }
    msgctl(msgid, IPC_RMID, 0);
}

// adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/os/ipcmsgq$ gcc recv.c -o recv
// adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/os/ipcmsgq$ ./recv
// Data received: red
// Data received: hat
// Data received: end