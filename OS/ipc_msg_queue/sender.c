#include <stdio.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/types.h>
#include <unistd.h>
#define MAX_TEXT 50
struct my_msg {
    long int msg_type;
    char some_text[MAX_TEXT];
};
int main() {
    int running = 1;
    int msgid;
    struct my_msg some_data;
    char buffer[20];
    msgid = msgget((key_t)12365, 0666 | IPC_CREAT);
    if (msgid == -1)
        printf("Error in creating the message queue\n");
    while (running) {
        printf("Enter some text\n");
        fgets(buffer, 20, stdin);
        some_data.msg_type = 1;
        strcpy(some_data.some_text, buffer);
        if (msgsnd(msgid, (void*)&some_data, MAX_TEXT, 0) == -1)
            printf("Messsage not sent\n");
        if (strncmp(buffer, "end", 3) == 0)
            running = 0;
    }
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/ipc_msg_queue$ gcc sender.c -o sender
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/ipc_msg_queue$ ./sender
Error in creating the message queue
Enter some text
hello world
Messsage not sent
Enter some text
something
Messsage not sent
Enter some text
end
Messsage not sent
*/