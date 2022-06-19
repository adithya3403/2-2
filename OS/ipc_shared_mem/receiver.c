#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/shm.h>
#include <unistd.h>
int main() {
    void *shared_memory;
    char buffer[100];
    int shmid;
    shmid = shmget((key_t)1985, 1024, 0666);
    printf("key of shared memory is : %d\n", shmid);
    shared_memory = shmat(shmid, NULL, 0);
    printf("process attached at %p\n", shared_memory);
    printf("data read from shared memory is : %s\n", (char *)shared_memory);
}