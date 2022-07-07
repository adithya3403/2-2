// Worst Fit

#include <stdio.h>
void main() {
    int bsize[20], psize[20];
    int all[20], m, n, i, j;
    printf("Enter no of blocks : ");
    scanf("%d", &m);
    printf("Enter the size of each block : ");
    for (i = 0; i < m; i++) {
        scanf("%d", &bsize[i]);
    }
    printf("Enter the no of processes : ");
    scanf("%d", &n);
    printf("Enter the size of each process : ");
    for (i = 0; i < n; i++) {
        scanf("%d", &psize[i]);
        all[i] = -1;
    }
    for (int i = 0; i < n; i++) {
        int worstplace = -1;
        for (j = 0; j < m; j++) {
            if (bsize[j] >= psize[i]) {
                if (worstplace == -1)
                    worstplace = j;
                else if (bsize[worstplace] < bsize[j])
                    worstplace = j;
            }
        }
        if (worstplace != -1) {
            all[i] = worstplace;
            bsize[worstplace] -= psize[i];
        }
    }
    printf("\n Process No \t Process Size\t Block no.\n");
    for (int i = 0; i < n; i++) {
        printf("% d\t\t % d\t\t", i + 1, psize[i]);
        if (all[i] != -1)
            printf("% d\n", all[i] + 1);
        else
            printf("Not Allocated \n");
    }
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/fits$ gcc worst.c -o worst
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/fits$ ./worst
Enter no of blocks : 5
Enter the size of each block : 100 500 200 300 600
Enter the no of processes : 4
Enter the size of each process : 212 417 112 426
Process No      Process Size    Block no.
1                212            5
2                417            2
3                112            5
4                426           Not Allocated
*/