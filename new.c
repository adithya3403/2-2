// Best Fit

#include <stdio.h>
void main() {
    int fragment[20], b[20], p[20], i, j, nb, np, temp, lowest = 9999;
    static int barray[20], parray[20];
    printf("\n\t\t\tMemory Management Scheme - Best Fit");
    printf("\nEnter the number of blocks : ");
    scanf("%d", &nb);
    printf("Enter the number of processes : ");
    scanf("%d", &np);
    printf("\nEnter the size of the blocks : \n");
    for (i = 1; i <= nb; i++) {
        printf("Block no.%d : ", i);
        scanf("%d", &b[i]);
    }
    printf("\nEnter the size of the processes : \n");
    for (i = 1; i <= np; i++) {
        printf("Process no.%d : ", i);
        scanf("%d", &p[i]);
    }
    for (i = 1; i <= np; i++) {
        for (j = 1; j <= nb; j++) {
            if (barray[j] != 1) {
                temp = b[j] - p[i];
                if (temp >= 0)
                    if (lowest > temp) {
                        parray[i] = j;
                        lowest = temp;
                    }
            }
        }
        fragment[i] = lowest;
        barray[parray[i]] = 1;
        lowest = 10000;
    }
    printf("\nProcess_no\tProcess_size\tBlock_no\tBlock_size\tFragment");
    for (i = 1; i <= np && parray[i] != 0; i++)
        printf("\n%d\t\t%d\t\t%d\t\t%d\t\t%d", i, p[i], parray[i], b[parray[i]], fragment[i]);
}

/*
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/fits$ gcc best.c -o best
adithya@Adithya:/mnt/c/Users/ADITHYA/Documents/GitHub/VSCODE-FILES/OS/fits$ ./best

                        Memory Management Scheme - Best Fit
Enter the number of blocks:5
Enter the number of processes:4

Enter the size of the blocks:-
Block no.1 : 100
Block no.2 : 500
Block no.3 : 200
Block no.4 : 300
Block no.5 : 600

Enter the size of the processes :-
Process no.1 : 212
Process no.2 : 417
Process no.3 : 112
Process no.4 : 426

Process_no      Process_size    Block_no        Block_size      Fragment
1               212             4               300             88
2               417             2               500             83
3               112             3               200             88
4               426             5               600             174
*/

#include <stdio.h>
void firstFit(int b, int p, int bsize[10], int psize[10], int all[10], int flag[10]) {
    for (int i = 0; i < p; i++) {
        for (int j = 0; j < b; j++) {
            if (bsize[j] >= psize[i] && !flag[j]) {
                all[i] = j;
                flag[j] = 1;
                break;
            }
        }
    }
}
void worstFit(int b, int p, int bsize[10], int psize[10], int all[10], int flag[10]) {
    for (int i = 0; i < p; i++) {
        int k = -1;
        for (int j = 0; j < b; j++) {
            if (bsize[j] >= psize[i] && !flag[j]) {
                if (k == -1)
                    k = j;
                else if (bsize[k] < bsize[j])
                    k = j;
            }
        }
        if (k != -1) {
            all[i] = k;
            bsize[k] -= psize[i];
            flag[k] = 1;
        }
    }
}

int main() {
    int bsize[] = {100, 500, 200, 300, 600};
    int psize[] = {212, 417, 112, 426};
    int b = sizeof(bsize) / sizeof(bsize[0]);
    int p = sizeof(psize) / sizeof(psize[0]);
    int all[10];
    int flag[10];
    for (int i = 0; i < b; i++) {
        all[i] = -1;
        flag[i] = 0;
    }
    // firstFit(b, p, bsize, psize, all, flag);
    worstFit(b, p, bsize, psize, all, flag);
    printf("\nProcess No.\tProcess Size\tBlock no.\n");
    for (int i = 0; i < p; i++) {
        printf("%d \t\t\t %d \t\t\t", i + 1, psize[i]);
        if (all[i] != -1)
            printf("%d\n", all[i] + 1);
        else
            printf("Not allocated\n");
    }
}