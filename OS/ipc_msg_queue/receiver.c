#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/types.h>
#include <unistd.h>
struct my_msg {
    long int msg_type;
    char some_text[20];
};
int main() {
    int running = 1;
    int msgid;
    struct my_msg some_data;
    long int msg_to_recv = 0;
    msgid = msgget((key_t)12356, 0666 | IPC_CREAT);
    while (running) {
        msgrcv(msgid, (void *)&some_data, 20, msg_to_recv, 0);
        printf("Data received:%s\n", some_data.some_text);
        if (strncmp(some_data.some_text, "end", 3) == 0)
            running = 0;
    }
    msgctl(msgid, IPC_RMID, 0);
}