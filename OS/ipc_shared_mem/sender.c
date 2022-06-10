#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/shm.h>
#include <unistd.h>
int main() {
    void *shared_memory;
    char buffer[100];
    int shmid;
    shmid = shmget((key_t)1985, 1024, 0666 | IPC_CREAT);
    printf("key of shared memory is : %d\n", shmid);
    shared_memory = shmat(shmid, NULL, 0);
    printf("process attached at %p\n", shared_memory);
    printf("enter some data to write to a shared memory \n");
    read(0, buffer, 100);
    strcpy(shared_memory, buffer);
    printf("your data is %s\n", (char *)shared_memory);
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/ipc_shared_mem$ gcc sender.c -o sender
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/ipc_shared_mem$ ./sender
key of shared memory is : 0
process attached at 0x7f8d25d9a000
enter some data to write to a shared memory 
hello world
your data is hello world
*/