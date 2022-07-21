// Worst Fit

#include <stdio.h>
int main() {
    int b, p, bsize[10], psize[10], all[10], flag[10];
    printf("Enter no of blocks : ");
    scanf("%d", &b);
    printf("Enter the size of each block : ");
    for (int i = 0; i < b; i++) {
        scanf("%d", &bsize[i]);
    }
    printf("Enter the no of processes : ");
    scanf("%d", &p);
    printf("Enter the size of each process : ");
    for (int i = 0; i < p; i++) {
        scanf("%d", &psize[i]);
    }
    for (int i = 0; i < p; i++) {
        flag[i] = 0;
        all[i] = -1;
    }
    for (int i = 0; i < p; i++) {
        int worstPlace = -1;
        for (int j = 0; j < b; j++) {
            if (bsize[j] >= psize[i] && !flag[j]) {
                if (worstPlace == -1)
                    worstPlace = j;
                else if (bsize[worstPlace] < bsize[j])
                    worstPlace = j;
            }
        }
        if (worstPlace != -1) {
            all[i] = worstPlace;
            bsize[worstPlace] -= psize[i];
            flag[worstPlace] = 1;
        }
    }
    printf("\nProcess No.\tProcess Size\tBlock no.\n");
    for (int i = 0; i < p; i++) {
        printf("%d \t\t %d \t\t", i + 1, psize[i]);
        if (all[i] != -1)
            printf("%d\n", all[i] + 1);
        else
            printf("Not Allocated\n");
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
3                112            4
4                426           Not Allocated
*/
