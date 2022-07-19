// Write a C program to simulate Paging in Memory Management

#include <stdio.h>
#define MAX 50
int main() {
    int page[MAX], i, n, f, ps, off, pno;
    int choice = 0;
    printf("Enter the no of pages in memory : ");
    scanf("%d", &n);
    printf("Enter page size : ");
    scanf("%d", &ps);
    printf("Enter no of frames : ");
    scanf("%d", &f);
    for (i = 0; i < n; i++)
        page[i] = -1;
    printf("Enter the page table\n");
    printf("(Enter frame no as -1 if that page is not present in any frame)\n");
    printf("Page no.\tFrame no.\n");
    for (i = 0; i < n; i++) {
        printf("%d\t\t", i);
        scanf("%d", &page[i]);
    }
    do {
        printf("Enter the logical address (i.e,page no & offset) : ");
        scanf("%d%d", &pno, &off);
        if (page[pno] == -1)
            printf("The required page is not available in any of frames\n");
        else
            printf("Physical address (frame no., offset) : %d, %d\n", page[pno], off);
        printf("Do you want to continue(1/0)? : ");
        scanf("%d", &choice);
    } while (choice == 1);
    return 1;
}

/*
Enter the no of pages in memory : 4
Enter page size : 10
Enter no of frames : 10
Enter the page table
(Enter frame no as -1 if that page is not present in any frame)
Page no.        Frame no.
0               5
1               -1
2               8
3               -1
Enter the logical address (i.e,page no & offset) : 0 200
Physical address (frame no., offset) : 5, 200
Do you want to continue(1/0)? : 0
*/