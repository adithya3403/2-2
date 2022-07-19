// FIFO Page Replacement Algorithm in C
#include <stdio.h>
void fifo(int ref[20], int reflen, int fnum) {
    int i, j, k, firstin = 0, found, phit = 0, pfault = 0;
    int frame[10];
    for (j = 0; j < fnum; j++)
        frame[j] = -1;
    printf("\nPage Trace: \n");
    for (i = 0; i < reflen; i++) {
        found = 0;
        for (j = 0; j < fnum; j++) {
            if (ref[i] == frame[j]) {
                found = 1;
                phit++;
                break;
            }
        }
        if (found == 0) {
            pfault++;
            frame[firstin] = ref[i];
            firstin = (firstin + 1) % fnum;
        }
        for (k = 0; k < fnum; k++) {
            if (frame[k] != -1)
                printf("%d\t", frame[k]);
        }
        printf("\n");
    }
    printf("Page Faults: %d\n", phit, pfault);
}
void main() {
    int i, reflen, fnum, refstr[20];
    printf("Enter reference string length & no of frames: ");
    scanf("%d %d", &reflen, &fnum);
    printf("Enter pages of reference string: ");
    for (i = 0; i < reflen; i++)
        scanf("%d,", &refstr[i]);
    fifo(refstr, reflen, fnum);
}

/*
Enter reference string length & no of frames: 12 3
Enter pages of reference string: 1 2 3 4 1 2 5 1 2 3 4 5

Page Trace:
1
1       2
1       2       3
4       2       3
4       1       3
4       1       2
5       1       2
5       1       2
5       1       2
5       3       2
5       3       4
5       3       4

Page Faults: 9
*/