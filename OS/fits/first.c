// First fit

#include <stdio.h>
void main() {
    int bsize[10], psize[10], bno, pno, flags[10], allocation[10], i, j;
    for (i = 0; i < 10; i++) {
        flags[i] = 0;
        allocation[i] = -1;
    }
    printf("Enter no of blocks : ");
    scanf("%d", &bno);
    printf("Enter the size of each block : ");
    for (i = 0; i < bno; i++)
        scanf("%d", &bsize[i]);
    printf("Enter the no of processes : ");
    scanf("%d", &pno);
    printf("Enter the size of each process : ");
    for (i = 0; i < pno; i++)
        scanf("%d", &psize[i]);
    for (int i = 0; i < pno; i++) {
        for (int j = 0; j < bno; j++) {
            if (bsize[j] >= psize[i]) {
                allocation[i] = j;
                bsize[j] -= psize[i];
                break;
            }
        }
    }
    printf("\n processno \t process size\t Block no\n");
    for (int i = 0; i < pno; i++) {
        printf("%d\t\t%d\t\t", i + 1, psize[i]);
        if (allocation[i] != -1)
            printf("%d\n", allocation[i] + 1);
        else
            printf("Not allocated\n");
    }
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/fits$ gcc first.c -o first
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/fits$ ./first
Enter no of blocks : 5
Enter the size of each block : 100 500 200 300 600
Enter the no of processes : 4
Enter the size of each process : 212 417 112 426

processno       process size    Block no
1               212             2
2               417             5
3               112             2
4               426             Not allocated
*/