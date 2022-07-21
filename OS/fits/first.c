// First Fit

#include <stdio.h>
void main() {
    int bs, ps, bsize[10], psize[10], all[10], flag[10];
    printf("Enter the number of blocks: ");
    scanf("%d", &bs);
    printf("Enter the size of each block: ");
    for (int i = 0; i < bs; i++) {
        scanf("%d", &bsize[i]);
    }
    printf("Enter the number of processes: ");
    scanf("%d", &ps);
    printf("Enter the size of each process: ");
    for (int i = 0; i < ps; i++) {
        scanf("%d", &psize[i]);
    }
    for (int i = 0; i < ps; i++) {
        all[i] = -1;
        flag[i] = 0;
    }
    for (int i = 0; i < ps; i++) {
        for (int j = 0; j < bs; j++) {
            if (!flag[j] && bsize[j] >= psize[i]) {
                all[i] = j;
                flag[j] = 1;
                break;
            }
        }
    }
    printf("\nProcess No.\tProcess Size\tBlock no.\n");
    for (int i = 0; i < ps; i++) {
        printf("%d \t\t\t %d \t\t\t", i + 1, psize[i]);
        if (all[i] != -1)
            printf("%d\n", all[i] + 1);
        else
            printf("Not allpcated\n");
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
3               112             3
4               426             Not allocated
*/